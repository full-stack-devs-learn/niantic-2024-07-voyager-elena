-- 12. Most Popular film report
-- return the name of the 10 most popular films
-- title and number of times each film was rented

-- which tables will you need to join?

--
-- (10 rows)

USE sakila;

SELECT f.title AS film_title
	, COUNT(r.rental_id) AS rent_count
FROM rental AS r
INNER JOIN inventory AS i
	ON r.inventory_id = i.inventory_id
INNER JOIN film AS f
	ON i.film_id = f.film_id
GROUP BY film_title
ORDER BY rent_count DESC
	, film_title
LIMIT 10;



