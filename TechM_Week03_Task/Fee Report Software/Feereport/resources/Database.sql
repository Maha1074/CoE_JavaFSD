-- Create the database
CREATE DATABASE FeeReportDB;
USE FeeReportDB;

-- Create Admin Table
CREATE TABLE admin (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Create Accountant Table
CREATE TABLE accountant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    phone VARCHAR(15) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create Student Table
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    course VARCHAR(100) NOT NULL,
    fee DOUBLE NOT NULL,
    paid DOUBLE NOT NULL,
    due DOUBLE NOT NULL,
    address TEXT NOT NULL,
    phone VARCHAR(15) NOT NULL
);

-- Insert Default Admin
INSERT INTO admin (username, password) VALUES ('admin', 'admin123');

-- Sample Accountant Data
INSERT INTO accountant (name, email, phone, password) 
VALUES 
('John Doe', 'john@example.com', '9876543210', 'pass123'),
('Jane Smith', 'jane@example.com', '9123456780', 'password');

-- Sample Student Data
INSERT INTO student (name, email, course, fee, paid, due, address, phone)
VALUES 
('Alice Johnson', 'alice@example.com', 'Computer Science', 50000, 25000, 25000, '123 Main St', '9876543211'),
('Bob Williams', 'bob@example.com', 'Electronics', 45000, 30000, 15000, '456 Park Ave', '9123456782');
