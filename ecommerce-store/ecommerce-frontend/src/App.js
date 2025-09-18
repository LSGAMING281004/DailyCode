import React, {useEffect, useState} from 'react';
import axios from 'axios';

const API = axios.create({ baseURL: 'http://localhost:8080/api' });

function App(){
  const [products,setProducts] = useState([]);
  const [sessionId] = useState(() => localStorage.getItem('sessionId') || (function(){ const id = 's-'+Math.random().toString(36).slice(2); localStorage.setItem('sessionId', id); return id; })());
  const [cart,setCart] = useState([]);

  useEffect(()=> {
    API.get('/products').then(r=> setProducts(r.data)).catch(e=>console.error(e));
    loadCart();
  },[]);

  function loadCart(){
    API.get('/cart', { params: { sessionId } }).then(r=> setCart(r.data)).catch(()=> setCart([]));
  }

  function addToCart(productId){
    API.post('/cart/add?sessionId='+sessionId, { productId, quantity:1 }).then(()=> loadCart()).catch(()=> alert('Add failed'));
  }

  function checkout(){
    API.post('/orders/checkout?sessionId='+sessionId).then(r=> {
      alert('Order placed. Total: ₹'+r.data.total);
      setCart([]);
    }).catch(e=> alert('Checkout failed'));
  }

  return (
    <div style={{padding:20, fontFamily:'Arial, sans-serif'}}>
      <h1>Simple E-commerce Store</h1>
      <div style={{display:'flex',gap:20}}>
        <div style={{flex:3}}>
          <h2>Products</h2>
          <div style={{display:'grid',gridTemplateColumns:'repeat(3,1fr)',gap:10}}>
            {products.map(p=> (
              <div key={p.id} style={{border:'1px solid #ddd',padding:10}}>
                <img src={p.imageUrl} alt={p.name} style={{width:'100%', height:150, objectFit:'cover'}}/>
                <h3>{p.name}</h3>
                <p>{p.description}</p>
                <p>₹ {p.price}</p>
                <button onClick={()=>addToCart(p.id)}>Add to cart</button>
              </div>
            ))}
          </div>
        </div>
        <div style={{flex:1}}>
          <h2>Cart</h2>
          {cart.length===0 ? <p>Cart empty</p> : (
            <div>
              <ul>{cart.map((i,idx)=><li key={idx}>Product {i.productId} x {i.quantity}</li>)}</ul>
              <button onClick={checkout}>Checkout</button>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}
export default App;
