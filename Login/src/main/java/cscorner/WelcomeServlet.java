package cscorner;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter(); 
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
		    for (Cookie c : cookies) {
		        if (c.getName().equals("username")) {
		            String user = c.getValue();
		            out.println("<h1>User Name: " + user+"</h1>");
		    			//response.getWriter().append("Served at: ").append(request.getContextPath());
		        }       
		    }
		}

	}

}
