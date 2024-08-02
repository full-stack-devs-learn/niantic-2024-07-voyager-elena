-- this script creates budget database
-- with 5 tables: categories, sub-categories, users, vendors, and transactions
DROP DATABASE IF EXISTS budget;

CREATE DATABASE budget;

USE budget;

-- create tables
CREATE TABLE categories (
    category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE sub_categories (
    sub_category_id INT NOT NULL AUTO_INCREMENT,
    sub_category_name VARCHAR(200) NOT NULL,
    category_id INT NOT NULL,
    PRIMARY KEY (sub_category_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);

CREATE TABLE users (
    user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE vendors (
    vendor_id INT NOT NULL AUTO_INCREMENT,
    vendor_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (vendor_id)
);

CREATE TABLE transactions (
    transaction_id INT NOT NULL AUTO_INCREMENT,
    transaction_date DATE NOT NULL,
    user_id INT NOT NULL,
    sub_category_id INT NOT NULL,
    vendor_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    notes TEXT NULL,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (sub_category_id) REFERENCES sub_categories (sub_category_id),
    FOREIGN KEY (vendor_id) REFERENCES vendors (vendor_id)
);
