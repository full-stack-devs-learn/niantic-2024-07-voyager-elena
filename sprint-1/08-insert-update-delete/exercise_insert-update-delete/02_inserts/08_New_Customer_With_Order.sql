-- Create a full script with variables that allows you 
-- to add a new Customer into the database. Then create an order for them
-- that includes 5 products. Create 5 variables at the top of the script
-- that store the 5 product names the customer wants to buy. You will use
-- the product names to find the id

-- Requirements
/*
    I should be able to run the script on my machine without having to
    write any queries to look up the id's of any tables. (The only id that
    I should have to know is the new CustomerId - which is a 5 letter code 
    that we will choose )

    Use variables at the top of the script to collect User Input. The rest 
    of the script should run without hardcoding ANY values.

    I.E. if I want to add a new customer, and order, I should be able 
    to change the variables at the beginning of the script, and run the whole
    script.
*/

/*
Customer must include: 
    Customer Id: 5 letter code
    Company Name: (You can use chatgpt or https://businessnamegenerator.com to pick a name)
    Contact Name: (you can use chatgpt or http://random-name-generator.info to pick a name)
    Address
    City
    Region
    Postal Code
    Country

Order:
    Order id: auto generated
    Customer Id: id from the inserted customer
    Order Date: today's date
    Ship Name: Contact name
    Ship Address: The company address information

OrderDetails: (Create 5 line items)
    Order Id: the one created above
    Product Id: use the product names to select/find the id of each product
    Unit Price: use the default list price of each product
    Quantity: you decide - between 1-10
    Discount: 0
*/

-- new customer info
SET @customer_id = 'LMANC';
SET @company_name = 'Laughing Man Coffee';
SET @contact_name = 'Hugh Jackman';
SET @address = '184 Duane St';
SET @city = 'New York';
SET @region = 'NY';
SET @postal_code = '10013';
SET @country = 'USA';

-- order info
SET @product_id1 = 10;
SET @product_id2 = 20;
SET @product_id3 = 30;
SET @product_id4 = 40;
SET @product_id5 = 50;

SET @order_date = CURDATE();
SET @quantity1 = 1;
SET @quantity2 = 2;
SET @quantity3 = 3;
SET @quantity4 = 4;
SET @quantity5 = 5;


SELECT @unit_price1 := unit_price
FROM products
WHERE product_id = @product_id1;

-- is there a difference bewteen the way above and this way of getting price1?
-- SET @unit_price1 = (SELECT unit_price
-- FROM products
-- WHERE product_id = @product_id1);

SELECT @unit_price2 := unit_price
FROM products
WHERE product_id = @product_id2;

SELECT @unit_price3 := unit_price
FROM products
WHERE product_id = @product_id3;

SELECT @unit_price4 := unit_price
FROM products
WHERE product_id = @product_id4;

SELECT @unit_price5 := unit_price
FROM products
WHERE product_id = @product_id5;


-- add a new Customer into the database
INSERT INTO customers
(
	  customer_id
    , company_name
    , contact_name
    , address
    , city
    , region
    , postal_code
    , country
)
VALUES
(
	  @customer_id
	, @company_name
    , @contact_name
    , @address
    , @city
    , @region
    , @postal_code
    , @country
);

-- create an order for the just added customer that includes 5 products
INSERT INTO orders
(
	  customer_id
    , order_date
    , ship_name
    , ship_address
    , ship_city
    , ship_region
    , ship_postal_code
    , ship_country
)
VALUES
(
	  @customer_id
	, @order_date
    , @contact_name
    , @address
    , @city
    , @region
    , @postal_code
    , @country
);

-- create order details
SET @order_id = last_insert_id();

INSERT INTO order_details
(
	  order_id
	, product_id
    , quantity
    , unit_price
)
VALUES
(
	  @order_id
    , @product_id1
	, @quantity1
    , @unit_price1
),
(
	  @order_id
    , @product_id2
	, @quantity2
    , @unit_price2
),
(
	  @order_id
    , @product_id3
	, @quantity3
    , @unit_price3
),
(
	  @order_id
    , @product_id4
	, @quantity4
    , @unit_price4
),
(
	  @order_id
    , @product_id5
	, @quantity5
    , @unit_price5
);














