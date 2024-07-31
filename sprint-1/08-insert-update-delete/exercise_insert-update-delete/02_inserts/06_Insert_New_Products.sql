USE northwind;

-- Insert 10 new products into the new Sporting Goods Category
-- You can leave the Supplier Id empty for now, but you need to include
-- the product name, category, price, units in stock (20), units on order (0)
-- and re-order level (10) for each product.


-- SET @sporting_goods_category_id = last_insert_id();
-- I experienced with insertion and deletion and have a question: how can I be sure that last inserted id is the sporting goods category id?
-- so I decodet to set @sporting_goods_category_id this way:
SET @sporting_goods_category_id = (SELECT category_id 
FROM categories
WHERE category_name = 'Sporting Goods'
LIMIT 1);

SELECT category_id 
	, category_name
FROM categories
WHERE category_id = @sporting_goods_category_id;

INSERT INTO products
(
	product_name
	, category_id
    , unit_price
    , units_in_stock
	, units_on_order
    , reorder_level
)
VALUES 
-- 1
	( 'Nike Metcon 8 Training Shoes'
    , @sporting_goods_category_id
    , 139.99
    , 20
    , 0
    , 10
    ),
-- 2
    ( 'Bowflex Adjustable Dumbbells'
    , @sporting_goods_category_id
    , 395.95
    , 20
    , 0
    , 10
    ),
-- 3
    ( 'Resistace Loop Bands Set'
    , @sporting_goods_category_id
    , 25.00
    , 20
    , 0
    , 10
    ),
-- 4
    ( 'Wilson NBA Game Basketball'
    , @sporting_goods_category_id
    , 29.99
    , 20
    , 0
    , 10
    ),
-- 5
    ( 'Adidas Defender III Medium Duffel Bag'
    , @sporting_goods_category_id
    , 45.49
    , 20
    , 0
    , 10
    ),
-- 6
    ( 'Giro Aether MIPS Bike Helmet'
    , @sporting_goods_category_id
    , 149.99
    , 20
    , 0
    , 10
    ),
-- 7
    ( 'Lulelemon The Reversible Mat'
    , @sporting_goods_category_id
    , 89.19
    , 20
    , 0
    , 10
    ),
-- 8
    ( 'Mongoose Switchback Comp Mountain Bike'
    , @sporting_goods_category_id
    , 549.99
    , 20
    , 0
    , 10
    ),
-- 9
    ( 'WHOOP 4.0 Activity Tracker'
    , @sporting_goods_category_id
    , 239.00
    , 20
    , 0
    , 10
    ),
-- 10
    ( 'CALIA Balance Ball'
    , @sporting_goods_category_id
    , 55.97
    , 20
    , 0
    , 10
    );
    
    
-- SELECT * FROM products;
    


