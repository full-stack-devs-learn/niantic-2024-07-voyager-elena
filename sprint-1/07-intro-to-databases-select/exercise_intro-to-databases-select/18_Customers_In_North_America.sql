USE northwind;

-- The name and country
-- of all customers in North America
-- Canada, USA, Mexico
-- Sort the results by country in alphabetic order

-- Expected: 21 Rows

SELECT 	company_name
	, country
FROM customers
WHERE country IN ('Canada', 'USA', 'Mexico')
ORDER BY country;