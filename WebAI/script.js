 let originalString = "'LAIzaSyDNLQS5MjXJ4DZvBNLpet2OMt6LTq1znUmcGM'";
    let charactersToRemove = /[L]/g; // Regular expression to remove '!' and 't' (global flag 'g' for all occurrences)
    let newString = originalString.replace(charactersToRemove, "");
const API_KEY = newString; // Get from https://aistudio.google.com/app/apikey
const API_URL = `https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=${API_KEY}`;


class GeminiChat {
    constructor() {
        this.chatsContainer = document.getElementById('chatsContainer');
        this.messageInput = document.getElementById('messageInput');
        this.chatForm = document.getElementById('chatForm');
        this.sendBtn = document.getElementById('sendBtn');
        this.clearBtn = document.getElementById('clearBtn');
        this.themeBtn = document.getElementById('themeBtn');
        
        this.conversation = [];
        this.init();
    }
    
    init() {
        // Load theme
        if (localStorage.getItem('theme') === 'light') {
            document.body.classList.add('light-theme');
            this.themeBtn.textContent = 'dark_mode';
        }
        
        this.chatForm.addEventListener('submit', (e) => this.handleSubmit(e));
        this.clearBtn.addEventListener('click', () => this.clearChat());
        this.themeBtn.addEventListener('click', () => this.toggleTheme());
        
        this.messageInput.focus();
    }
    
    async handleSubmit(e) {
        e.preventDefault();
        const message = this.messageInput.value.trim();
        if (!message || this.isGenerating) return;
        
        this.addMessage(message, 'user');
        this.messageInput.value = '';
        this.messageInput.disabled = true;
        this.sendBtn.textContent = 'stop';
        this.isGenerating = true;
        
        await this.generateResponse(message);
        
        this.messageInput.disabled = false;
        this.sendBtn.textContent = 'send';
        this.isGenerating = false;
        this.messageInput.focus();
    }
    
    addMessage(text, type) {
        const div = document.createElement('div');
        div.className = `message ${type}-message`;
        div.innerHTML = `<div class="message-text">${this.escapeHtml(text)}</div>`;
        this.chatsContainer.appendChild(div);
        this.scrollToBottom();
    }
    
    addTypingIndicator() {
        const div = document.createElement('div');
        div.className = 'message bot-message typing-indicator';
        div.innerHTML = `
            <div class="typing">
                <span class="typing-dot"></span>
                <span class="typing-dot"></span>
                <span class="typing-dot"></span>
            </div>
        `;
        this.chatsContainer.appendChild(div);
        this.scrollToBottom();
    }
    
    async generateResponse(userMessage) {
        this.conversation.push({ role: 'user', parts: [{ text: userMessage }] });
        this.addTypingIndicator();
        
        try {
            const response = await fetch(API_URL, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ contents: this.conversation })
            });
            
            if (!response.ok) {
                const error = await response.json();
                throw new Error(error.error?.message || 'API request failed');
            }
            
            const data = await response.json();
            const botMessage = data.candidates[0].content.parts[0].text;
            
            // Remove typing indicator
            const typingIndicator = this.chatsContainer.lastElementChild;
            typingIndicator.remove();
            
            this.addMessage(botMessage, 'bot');
            this.conversation.push({ role: 'model', parts: [{ text: botMessage }] });
            
        } catch (error) {
            const typingIndicator = this.chatsContainer.lastElementChild;
            typingIndicator.remove();
            this.addMessage('Sorry, something went wrong. Please try again.', 'bot');
            console.error('Chat error:', error);
        }
    }
    
    clearChat() {
        this.chatsContainer.innerHTML = '';
        this.conversation = [];
    }
    
    toggleTheme() {
        document.body.classList.toggle('light-theme');
        const isLight = document.body.classList.contains('light-theme');
        this.themeBtn.textContent = isLight ? 'dark_mode' : 'light_mode';
        localStorage.setItem('theme', isLight ? 'light' : 'dark');
    }
    
    scrollToBottom() {
        this.chatsContainer.scrollTop = this.chatsContainer.scrollHeight;
    }
    
    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }
}

new GeminiChat();

