-- 12. The average line_item amount for all sales in the US
-- (Use the customer_orders view)
-- expect approx $748.77

-- (1 row)

USE northwind;

SELECT AVG(sales_price * quantity) as average_line_item_amount
FROM customer_orders
WHERE country = 'USA'; 
