USE northwind;

-- The Product name, price and category id
-- of all dairy products

-- Expected: 10 rows

SELECT product_name
	, unit_price
    , products.category_id
FROM products
JOIN categories ON products.category_id = categories.category_id
WHERE categories.category_name = 'Dairy Products';


