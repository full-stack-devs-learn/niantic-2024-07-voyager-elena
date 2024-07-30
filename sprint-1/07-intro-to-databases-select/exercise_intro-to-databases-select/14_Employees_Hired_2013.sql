USE northwind;

-- The employee name and title
-- of all employees who were hired
-- in 2013

-- Expected: 3 rows

SELECT CONCAT(first_name, ' ', last_Name) as name
	, title
  --   , hire_date
FROM employees
WHERE YEAR(hire_date) = 2013;