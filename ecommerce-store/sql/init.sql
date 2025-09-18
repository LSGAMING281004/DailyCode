CREATE DATABASE IF NOT EXISTS ecommerce;
USE ecommerce;

CREATE TABLE IF NOT EXISTS product (
  id BIGINT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255),
  description TEXT,
  price DECIMAL(10,2),
  image_url VARCHAR(512),
  stock INT
);

INSERT INTO product (name, description, price, image_url, stock) VALUES
('Wireless Mouse','Ergonomic wireless mouse',499.00,'https://via.placeholder.com/300',50),
('Mechanical Keyboard','RGB mechanical keyboard',2499.00,'https://via.placeholder.com/300',30),
('USB-C Charger','Fast 30W USB-C charger',799.00,'https://via.placeholder.com/300',100);
