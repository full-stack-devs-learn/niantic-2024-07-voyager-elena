-- 10. Count of films in each category
-- that GRACE MOSTEL has appeared in as an actress

-- include first_name, last_name, category_name, film_count

-- (11 rows)

USE sakila;

SELECT a.first_name
	, a.last_name
    , c.name AS category_name
	, COUNT(f.film_id) AS film_count
FROM category AS c
INNER JOIN film_category AS fc
	ON c.category_id = fc.category_id
INNER JOIN film AS f
	ON fc.film_id = f.film_id
INNER JOIN film_actor AS fa
	ON f.film_id = fa.film_id
INNER JOIN actor AS a
	ON fa.actor_id = a.actor_id
WHERE CONCAT (a.first_name, ' ', a.last_name) = 'GRACE MOSTEL'
GROUP BY category_name 
	, a.last_name
	, a.first_name;
