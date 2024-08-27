-- 4. I want to know what category is the most popular
-- category for my best customer.

-- SELECT the Company Name, Category, and the OrderCount
-- for Save-a-lot Markets. (my best customer)
-- (the order count specifies how many times a category
-- was included in their orders)

-- sort in the order of the most ordered category to the least

-- (8 rows)

USE northwind;

SELECT DISTINCT c.company_name
    , cat.category_name
	-- , o.order_id
    , COUNT(o.order_id) AS order_count
FROM orders AS o
INNER JOIN customers AS c
	ON o.customer_id = c.customer_id
INNER JOIN order_details AS od
	ON o.order_id = od.order_id
INNER JOIN products AS p
	ON od.product_id = p.product_id
INNER JOIN categories AS cat
	ON cat.category_id = p.category_id
WHERE company_name = 'Save-a-lot Markets'
GROUP BY cat.category_name
ORDER BY order_count DESC;
