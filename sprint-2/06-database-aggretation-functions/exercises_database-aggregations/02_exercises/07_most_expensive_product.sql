-- 7. Select the price of the most expensive product

-- (1 row)
USE northwind;

SELECT max(unit_price)
FROM products;

-- or

SELECT unit_price
FROM products
ORDER BY unit_price DESC
LIMIT 1;
