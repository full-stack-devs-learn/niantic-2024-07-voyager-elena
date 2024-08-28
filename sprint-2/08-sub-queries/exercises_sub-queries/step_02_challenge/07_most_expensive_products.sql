-- 7. expensive products report

-- Display the most expensive product in each category

-- Columns to include:
-- Category Name
-- Product Name
-- Unit price

-- NOTE: you can combine INNER JOIN and sub queries in the
-- query if you would like

-- (8 rows - one per category)
-- Beverages        Cte de Blaye            263.5000
-- Condiments       Vegie-spread            43.9000
-- Confections      Sir Rodney's Marmalade  81.0000
-- Dairy Products   Raclette Courdavault    55.0000
-- Grains/Cereals   Gnocchi di nonna Alice  38.0000
-- Meat/Poultry     Thringer Rostbratwurst  123.7900
-- Produce          Manjimup Dried Apples   53.0000
-- Seafood          Carnarvon Tigers        62.5000


USE northwind;

SELECT category_name
	, (
		SELECT product_name
        FROM products
        WHERE category_id = c.category_id 
			AND unit_price IN ( -- I had unit_price = (... at first, but then decided to chnge it to IN because there could be more than one products with the same max_price
				SELECT MAX(unit_price)
                FROM products
                WHERE category_id = c.category_id
            )
    ) AS most_expesive_product
    , (
		SELECT MAX(unit_price)
		FROM products
		WHERE category_id = c.category_id
    ) AS max_unit_price
FROM categories AS c;


