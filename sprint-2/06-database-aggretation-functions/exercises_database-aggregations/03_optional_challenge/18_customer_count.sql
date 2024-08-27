-- 18. Count the number of customers in each country
-- include the country and total_customer_count
-- (use customers table)

-- (21 rows)

USE northwind;

SELECT COUNT(*) as total_customer_count
	, country
FROM customers
GROUP BY country
ORDER BY total_customer_count DESC;




