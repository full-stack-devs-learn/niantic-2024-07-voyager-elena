-- 4. Display the
        -- product_name,
        -- sales_price,
        -- quantity,
        -- sub_total (price * qty)
        -- total_discount (sub_total * discount %)
        -- line_total (sub_total - discount amount)

-- Display all rows where the total discount is  over $1000.
-- (Use the customer_orders View)


-- Order the results by total_discount, highest first.
-- (8 rows)

USE northwind;

SELECT product_name
	, sales_price
    , quantity
    , sales_price * quantity as sub_total
    , sales_price * quantity * discount as total_discount
    , sales_price * quantity * (1 - discount) as line_total
FROM customer_orders
WHERE sales_price * quantity * discount > 1000
ORDER BY line_total DESC;


