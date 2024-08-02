-- This script creates a new User/Person using person's name entered by the user

-- To add a Person, please provide the following information: 
-- Person name VARCHAR(200)

SET @person_name = 'William';

USE budget;

INSERT INTO users (user_name)
VALUES (@person_name);