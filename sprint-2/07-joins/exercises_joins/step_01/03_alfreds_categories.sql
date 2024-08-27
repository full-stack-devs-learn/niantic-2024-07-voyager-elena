-- 3.  List of all the categories 
-- that Alfreds Futterkiste has ever ordered
-- (5 rows)

USE Northwind;

SELECT DISTINCT c.company_name
    , p.category_id
    , cat.category_name
FROM orders AS o
INNER JOIN customers AS c
	ON o.customer_id = c.customer_id
INNER JOIN order_details AS od
	ON o.order_id = od.order_id
INNER JOIN products AS p
	ON od.product_id = p.product_id
INNER JOIN categories AS cat
	ON cat.category_id = p.category_id
WHERE company_name = 'Alfreds Futterkiste'
ORDER BY cat.category_name;
