-- This script creates a new Sub Category using data entered by the user, 
-- including category name and sub category name

-- To add a Sub Category, please provide the following information: 
-- Category name in which you want to add sub category - VARCHAR(200)
-- New sub category name - VARCHAR(200)

SET @category_name = 'Education';
SET @sub_category_name = 'Online courses';
-- SET @sub_category_name = 'Textbooks';
-- SET @sub_category_name = 'Supplies';


USE budget;

-- get category id
SELECT @category_id := category_id
FROM categories
WHERE category_name = @category_name;

-- insert new sub category
INSERT INTO sub_categories (sub_category_name, category_id)
VALUES (@sub_category_name, @category_id);



