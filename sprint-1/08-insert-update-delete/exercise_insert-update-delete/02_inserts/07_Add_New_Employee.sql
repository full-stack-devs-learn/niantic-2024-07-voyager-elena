USE northwind;

-- You were just hired by Northwind Traders, Inc and 
-- you need to add yourself as a Sales Associate to the Employees table.
-- Inlcude your:
    -- full name
    -- job title
    -- preferred title (Mr, Mrs, etc)
    -- Birthday
    -- hire date: (today)
    -- home address
-- leave all other fields null by default


-- SELECT CURDATE();

INSERT INTO employees
(
	  first_name
	, last_name
    , title
    , title_of_courtesy
	, birth_date
	, hire_date
	, address
    , city
    , region
    , postal_code
    , country
    , notes
)
VALUES
(
	'Elena'
    , 'Bychenkova'
    , 'Sales Associate'
    , 'Mrs'
    , DATE '2001-01-01'
    , CURDATE()
    , '2393 Central Pkw'
    , 'Dublin'
    , 'CA'
    , '94568'
    , 'USA'
    , ''
);

-- SELECT *
-- FROM employees
-- WHERE employee_id = last_insert_id();
