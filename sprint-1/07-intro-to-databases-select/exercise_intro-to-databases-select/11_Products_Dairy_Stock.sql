USE northwind;

-- The Product name, price and the number
-- of units available for sale (in stock + on order)
-- of all dairy products

-- Hint: Be sure to create a column alias for 
-- the new column

-- Expected: 10 rows

SELECT product_name
	, unit_price
    , products.category_id
--     , units_in_stock
--     , units_on_order
    , units_in_stock + units_on_order as 'units_available'
FROM products
JOIN categories ON products.category_id = categories.category_id
WHERE categories.category_name = 'Dairy Products';

