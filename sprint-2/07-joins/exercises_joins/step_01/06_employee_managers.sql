-- 6. Select the full name of each employee
-- and the full name of their manager

-- hint look at the employee table to see how to
-- determine who the manager is of each employee

-- you will need to do a "self join" to the employees table
-- and you will need to create table aliases to complete this query

-- (9 rows)

USE northwind;

SELECT CONCAT(emp.first_name, ' ', emp.last_name) AS employee_full_name
	, CONCAT(man.first_name, ' ', man.last_name) AS manager_full_name
FROM employees AS emp
LEFT OUTER JOIN employees AS man
	ON emp.reports_to = man.employee_id;
