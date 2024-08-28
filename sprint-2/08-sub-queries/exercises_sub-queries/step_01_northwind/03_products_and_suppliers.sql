-- 3. Create a product supplier report

-- Columns to include:
-- -------------------
-- Product Name
-- units in stock
-- Supplier Name


-- Use a sub query to display the Category Name
-- you are not allowed to use a JOIN statment

-- sort by product name

USE Northwind;

SELECT product_name
    , units_in_stock
    ,	(
		SELECT company_name
		FROM suppliers
        WHERE supplier_id = p.supplier_id
	) AS supplier_name 
FROM products AS p
ORDER BY product_name;
