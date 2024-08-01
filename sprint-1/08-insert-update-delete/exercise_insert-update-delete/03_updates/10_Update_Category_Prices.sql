USE northwind;

-- Write a script that updates the price of all products 
-- within a category by a certain percent.
-- use variables to accept the Category name and the percent increase 

SET @category_name = 'Sporting Goods';
SET @increase_percent = 0.1;
SET @category_id = (SELECT category_id 
FROM categories
WHERE category_name = @category_name
LIMIT 1);

UPDATE products
SET unit_price = ROUND(unit_price * (1 + @increase_percent), 2)
WHERE category_id = @category_id;

