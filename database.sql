<<<<<<< HEAD
create database spring-mvc-jsp-hibernate;
=======
USE spring_mvc_jsp_hibernate_2025;

CREATE TABLE account (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    avatar VARCHAR(100),
    email VARCHAR(50) NOT NULL UNIQUE,
    role ENUM('ADMIN', 'USER', 'EMPLOYEE', 'VENDOR') DEFAULT 'USER',
    createAt DATETIME DEFAULT NOW(),
    updateAt DATETIME DEFAULT NOW()
);

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstname VARCHAR(20) NOT NULL,
    lastname VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    gender ENUM('male', 'female') NOT NULL,
    address VARCHAR(50) NOT NULL,
    phone_number VARCHAR(12) NOT NULL UNIQUE,
    account_id INT,
    FOREIGN KEY (account_id) REFERENCES account(id) ON DELETE CASCADE
);

CREATE TABLE category (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    createAt DATETIME DEFAULT NOW(),
    updateAt DATETIME DEFAULT NOW()
);

CREATE TABLE product (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    price FLOAT NOT NULL,
    description VARCHAR(200),
    quantity INT NOT NULL,
    category_id INT,
    createAt DATETIME DEFAULT NOW(),
    updateAt DATETIME DEFAULT NOW(),
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);

CREATE TABLE `order` (
    id INT PRIMARY KEY AUTO_INCREMENT,
    status ENUM('Delivery', 'Processing', 'Shipped'),
    total_price FLOAT NOT NULL,
    user_id INT,
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE order_item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    order_id INT,
    ship_date DATETIME NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product(id) ON DELETE CASCADE,
    FOREIGN KEY (order_id) REFERENCES `order`(id) ON DELETE CASCADE
);

CREATE TABLE user_push_item (
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT,
    item_name VARCHAR(100) NOT NULL,
    created_at DATETIME DEFAULT NOW(),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
>>>>>>> 5585b6d (upload sql)
