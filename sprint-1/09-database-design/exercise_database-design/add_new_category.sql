-- This script creates a new Category using category name entered by the user

-- To add a Category, please provide the following information: 
-- Category name VARCHAR(200)

SET @category_name = 'Education';

USE budget;

INSERT INTO categories (category_name)
VALUES (@category_name);