-- this script creates budget database
-- with tables and sample data
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
    category_id INT NOT NULL,
    sub_category_id INT NOT NULL,
    vendor_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    notes TEXT NULL,
    PRIMARY KEY (transaction_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id),
    FOREIGN KEY (sub_category_id) REFERENCES sub_categories (sub_category_id),
    FOREIGN KEY (vendor_id) REFERENCES vendors (vendor_id)
);

-- seed data
-- insert data into categories table
INSERT INTO
    categories (category_name)
VALUES
    ('Housing'),
    ('Transportation'),
    ('Food'),
    ('Healthcare'),
    ('Entertainment'),
    ('Vacation/Travel');

-- insert data into sub_categories table
INSERT INTO sub_categories (sub_category_name, category_id)
VALUES
    ('Rent', 1),
    ('Utilities', 1),
    ('Internet', 1),
    ('Gas', 2),
    ('Subway', 2),
    ('Car Maintenance', 2),
    ('Groceries', 3),
    ('Restaurant', 3),
    ('Snacks', 3),
    ('Rx', 4),
    ('Dr Visit', 4),
    ('OTC Medicine', 4),
    ('Movies', 5),
    ('Netflix', 5),
    ('Sports', 5),
    ('Flight', 6),
    ('Hotel', 6),
    ('Car Rental', 6);

-- insert data into users table
INSERT INTO users (user_name)
VALUES ('John'), ('Sarah');

-- insert data into vendors table
INSERT INTO vendors (vendor_name)
VALUES
    ('Landlord Inc.'),
    ('Shell Gas Station'),
    ('Fresh Mart'),
    ('CVS Pharmacy'),
    ('Cinemax Theater'),
    ('Delta Airlines'),
    ('PowerCo'),
    ('Metro Transit'),
    ('Joe\'s Diner'),
    ('HealthFirst Clinic'),
    ('Netflix'),
    ('Oceanfront Resort'),
    ('WaterWorks'),
    ('AutoWorks'),
    ('Snack Haven'),
    ('Pharmax'),
    ('Sports Arena'),
    ('Zoom Car Rentals'),
    ('Farmer\'s Market'),
    ('FastNet');

-- insert data into transactions table
INSERT INTO transactions (transaction_date, user_id, category_id, sub_category_id, vendor_id, amount, notes) 
VALUES
('2024-05-01', 1, 1, 1, 1, 1200, 'Monthly rent payment'),
('2024-05-03', 2, 2, 4, 2, 40, 'Filled up the car\'s tank'),
('2024-05-05', 1, 3, 7, 3, 150, 'Weekly grocery shopping'),
('2024-05-07', 2, 4, 10, 4, 20, 'Prescription refill'),
('2024-05-10', 1, 5, 13, 5, 30, 'Movie night out'),
('2024-05-12', 2, 6, 16, 6, 300, 'Booked flight for upcoming trip'),
('2024-05-15', 1, 1, 2, 7, 100, 'Electricity bill payment'),
('2024-05-17', 2, 2, 5, 8, 20, 'Monthly subway pass'),
('2024-05-20', 1, 3, 8, 9, 25, 'Dinner with friends'),
('2024-05-22', 2, 4, 11, 10, 50, 'Routine check-up'),
('2024-05-25', 1, 5, 14, 11, 15, 'Monthly subscription fee'),
('2024-05-28', 2, 6, 17, 12, 200, 'Hotel booking for vacation'),
('2024-05-01', 2, 1, 2, 13, 50, 'Water bill payment'),
('2024-05-04', 1, 2, 6, 14, 100, 'Car oil change'),
('2024-05-09', 2, 3, 9, 15, 10, 'Snacks for movie night'),
('2024-05-14', 1, 4, 12, 16, 15, 'Cold medicine'),
('2024-05-18', 2, 5, 15, 17, 50, 'Tickets to a baseball game'),
('2024-05-23', 1, 6, 18, 18, 150, 'Rental car for trip'),
('2024-05-26', 2, 3, 7, 19, 80, 'Fresh produce and groceries'),
('2024-05-30', 1, 1, 3, 20, 60, 'Internet service provider bill');

-- test if I can get the same report we have in budget_data.csv file
SELECT transaction_date AS Date
	, user_name AS Person
    , category_name AS Category
    , sub_category_name AS 'Sub Category'
    , vendor_name AS Vendor
    , amount AS Amount 
    , notes AS Notes
FROM transactions
JOIN users ON users.user_id = transactions.user_id
JOIN categories ON categories.category_id = transactions.category_id
JOIN sub_categories ON sub_categories.sub_category_id = transactions.sub_category_id
JOIN vendors ON vendors.vendor_id = transactions.vendor_id
ORDER BY transaction_id;

-- all categories by Month
SELECT 
	-- MONTHNAME(transaction_date) AS Month
	-- , transaction_date
	category_name AS Category
	, SUM(amount) AS Amount

FROM categories
JOIN transactions ON transactions.category_id = categories.category_id
WHERE MONTH(transaction_date) = 5
GROUP BY category_name
ORDER BY category_name;
-- GROUP BY Month, category_name
-- ORDER BY MONTH(transaction_date), category_name;

/*
Now we have transactions that were made in May only. 
If we have more data, for several months,
how too get a report where we group by month first and then inside each month group by category?
*/

-- Housing Expensies
SELECT category_name AS 'Category'
	, sub_category_name AS 'Sub Category'
	, SUM(amount) AS Amount
FROM transactions
JOIN categories ON categories.category_id = transactions.category_id
JOIN sub_categories ON sub_categories.sub_category_id = transactions.sub_category_id
-- WHERE category_name = 'Housing'
GROUP BY category_name, sub_category_name
ORDER BY category_name, sub_category_name;

