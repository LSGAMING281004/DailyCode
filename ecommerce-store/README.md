# Simple E-commerce Store (Docker-ready)

This is a simplified e-commerce example with:
- Spring Boot backend (Products, Cart, Orders)
- React frontend (product listing, cart, checkout)
- MySQL database with sample products

## Run (requires Docker)
1. Unzip the package:
   unzip ecommerce-store.zip
   cd ecommerce-store

2. Start services:
   docker-compose up --build

3. Open:
   - Frontend: http://localhost:3000
   - Backend API: http://localhost:8080/api/products
   - MySQL exposed on host port 3307

Notes:
- The backend uses `SPRING_DATASOURCE_*` environment variables defined in docker-compose.
- Cart is a simple in-memory per-session implementation keyed by `sessionId` (stored in browser localStorage). Orders are stored in-memory while containers run.
- This project is intentionally minimal so it starts quickly. You can extend it (add authentication, persistent orders, images, payment).
