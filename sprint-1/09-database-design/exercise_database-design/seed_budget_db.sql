-- sthis sript seed the budget database with data from budget-data.csv
USE budget;

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
INSERT INTO transactions (transaction_date, user_id, sub_category_id, vendor_id, amount, notes) 
VALUES
('2024-05-01', 1, 1, 1, 1200, 'Monthly rent payment'),
('2024-05-03', 2, 4, 2, 40, 'Filled up the car\'s tank'),
('2024-05-05', 1, 7, 3, 150, 'Weekly grocery shopping'),
('2024-05-07', 2, 10, 4, 20, 'Prescription refill'),
('2024-05-10', 1, 13, 5, 30, 'Movie night out'),
('2024-05-12', 2, 16, 6, 300, 'Booked flight for upcoming trip'),
('2024-05-15', 1, 2, 7, 100, 'Electricity bill payment'),
('2024-05-17', 2, 5, 8, 20, 'Monthly subway pass'),
('2024-05-20', 1, 8, 9, 25, 'Dinner with friends'),
('2024-05-22', 2, 11, 10, 50, 'Routine check-up'),
('2024-05-25', 1, 14, 11, 15, 'Monthly subscription fee'),
('2024-05-28', 2, 17, 12, 200, 'Hotel booking for vacation'),
('2024-05-01', 2, 2, 13, 50, 'Water bill payment'),
('2024-05-04', 1, 6, 14, 100, 'Car oil change'),
('2024-05-09', 2, 9, 15, 10, 'Snacks for movie night'),
('2024-05-14', 1, 12, 16, 15, 'Cold medicine'),
('2024-05-18', 2, 15, 17, 50, 'Tickets to a baseball game'),
('2024-05-23', 1, 18, 18, 150, 'Rental car for trip'),
('2024-05-26', 2, 7, 19, 80, 'Fresh produce and groceries'),
('2024-05-30', 1, 3, 20, 60, 'Internet service provider bill'),
('2024-06-25', 1, 14, 11, 15, 'Monthly subscription fee');

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
JOIN sub_categories ON sub_categories.sub_category_id = transactions.sub_category_id
JOIN categories ON categories.category_id = sub_categories.category_id
JOIN vendors ON vendors.vendor_id = transactions.vendor_id
ORDER BY transaction_id;

-- all categories by Month
SELECT 
	MONTHNAME(transaction_date) AS Month
	, category_name AS Category
	, SUM(amount) AS Amount

FROM transactions
JOIN sub_categories ON sub_categories.sub_category_id = transactions.sub_category_id
JOIN categories ON categories.category_id = sub_categories.category_id
GROUP BY MONTHNAME(transaction_date), MONTH(transaction_date), category_name
ORDER BY MONTH(transaction_date), category_name;

-- I got: 'May', 'Vacation/Travel', '650.00'
-- but there is 450 for Vacation/Travel in May in the example chart provided
-- I believe there should be 650 = 300 + 200 + 150


-- Housing Expensies
SELECT category_name AS 'Category'
	, sub_category_name AS 'Sub Category'
	, SUM(amount) AS Amount
FROM transactions
JOIN sub_categories ON sub_categories.sub_category_id = transactions.sub_category_id
JOIN categories ON categories.category_id = sub_categories.category_id
-- WHERE category_name = 'Housing'
GROUP BY category_name, sub_category_name
ORDER BY category_name, sub_category_name;
