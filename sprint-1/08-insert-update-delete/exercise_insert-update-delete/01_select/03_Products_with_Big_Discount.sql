USE northwind;

-- Use the customer_orders view that we created
-- return the: CompanyName, OrderDate, OrderId,
-- ProductName, SalesPrice, Quantity, Discount,
-- SubTotal, LineDiscount and LineTotal
-- for all orders where the line discount is.    -- I did not get this instruction

-- for all order line items with a LineDiscount that is more than $1000

-- sort the rows by discount highest to lowest


-- Expected: 8 Rows

SELECT company_name
	, order_date
    , order_id
    , product_name
    , sales_price
    , quantity
    , discount
    , sales_price * quantity as sub_total
    , sales_price * discount * quantity as line_discount
    , sales_price * (1 - discount) * quantity as line_total
FROM customer_orders
WHERE (sales_price * discount * quantity) > 1000
ORDER BY discount DESC;
