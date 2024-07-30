USE world;

/* 	
	multi
	line
    comment
*/

-- get all rows and columns from the city table
SELECT * 
FROM city;

-- get name, country code and population from city table
SELECT Name
	, CountryCode
    , Population
FROM city
WHERE CountryCode = 'USA'
ORDER BY Population DESC
LIMIT 5;



