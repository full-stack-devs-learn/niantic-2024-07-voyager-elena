USE northwind;

-- delete one of your new sporting goods products
-- from the database
-- choose one that has not been purchased 


SET @category_name = 'Sporting Goods';
SET @category_id = (SELECT category_id 
FROM categories
WHERE category_name = @category_name
LIMIT 1);


SELECT @product_id := product_Id
FROM products
WHERE category_id = @category_id AND product_ID NOT IN (SELECT product_id FROM order_details)
LIMIT 1;

DELETE FROM products
WHERE product_id = @product_id;
