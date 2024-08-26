-- 8. The sum of all sales in the UK
-- sales_price * quantity -- don't worry about discount
-- (Use the customer_orders view)

-- (1 row) - $60616.51

USE northwind;

SELECT sum(sales_price * quantity) as total_sales
FROM customer_orders
WHERE country = 'UK';
