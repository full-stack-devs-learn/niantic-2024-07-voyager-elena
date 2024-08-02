-- This script creates a new transaction using data entered by the user, 
-- including date, person involved, sub category, vendor, amount, and optional notes

-- To add a transaction, please provide the following information: 
-- Transaction date in format YYYY-MM-DD
-- Person's name
-- Sub category name
-- Vendor's name
-- Any additional notes (optional)
-- Amount spent

SET @transaction_date = '2024-06-09';
SET @user_name = 'Sarah';
SET @sub_category_name = 'Restaurant';
SET @vendor = 'Joe\'s Diner';
-- SET @vendor = 'Paris Baguette'; there is no such vendor in the database yet
SET @notes = 'Breakfast with friends';
SET @amount = '25.95';


-- get user_id
SELECT @user_id := user_id
FROM users
WHERE user_name = @user_name; 

-- get sub category id
SELECT @sub_category_id := sub_category_id
	-- , @category_id := category_id
FROM sub_categories
WHERE sub_category_name = @sub_category_name;

-- get vendor id
SELECT @vendor_id := vendor_id
FROM vendors
WHERE vendor_name = @vendor;

INSERT INTO transactions 
(
	transaction_date
    , user_id
    , sub_category_id
    , vendor_id
    , amount
    , notes
) 
VALUES
(
	@transaction_date
    , @user_id
    , @sub_category_id
    , @vendor_id
    , @amount
    , @notes
);


-- I tryed to implement some logic here...
-- if there is such vendor in the database = we found vendor_id 
-- then we can add new transaction
-- the code below is not working, it look like we need procedures to use IF statements in MySQL :(
/*
IF @vendor_id IS NOT NULL THEN 
{
	SELECT 'vendor_id IS NOT NULL';
-- insert / create a new transaction with given data

}
ELSE 
{
SELECT 'vendor_id NOT NULL!!!';
-- if there no such vendor we need to create a new vendor
}
END IF;
*/

-- check that the added transaction in the database with all the data added correctly
SET @new_transaction_id = LAST_INSERT_ID();

SELECT transaction_id AS ID 
	, transaction_date AS Date
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
WHERE transaction_id = @new_transaction_id;





