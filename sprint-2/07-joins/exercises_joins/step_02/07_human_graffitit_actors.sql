-- 7. List the names of all actors who acted in
-- the film "HUMAN GRAFFITI"

-- (4 rows)

USE sakila;

SELECT CONCAT(a.first_name, ' ', a.last_name) AS actor_full_name
	, f.title
FROM film_actor fa
INNER JOIN film AS f
	ON fa.film_id = f.film_id
INNER JOIN actor AS a
	ON fa.actor_id = a.actor_id
WHERE f.title = 'HUMAN GRAFFITI';
