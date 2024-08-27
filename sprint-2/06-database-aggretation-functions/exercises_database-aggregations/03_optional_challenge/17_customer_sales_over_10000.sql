-- 16. Total sales by any customer who has spent more than $10000
-- Include the CompanyName, State and TotalSales
-- Sort by total sales desc
-- (Use the customer_orders view)

-- (6 rows)

USE northwind;

SELECT company_name
	, region
	, SUM(sales_price * quantity) as total_sales
FROM customer_orders
WHERE country = 'USA'
GROUP BY company_name
	, region
HAVING total_sales > 10000
ORDER BY region
	, total_sales DESC;
