USE northwind;

-- Return all countries and cities where we 
-- have customers

-- Expected: 69 Rows

SELECT DISTINCT country
	, city
FROM customers
ORDER BY country;

