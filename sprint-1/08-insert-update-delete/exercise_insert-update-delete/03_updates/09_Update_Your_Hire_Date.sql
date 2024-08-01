USE northwind;

-- write an update statement and change your hire date to 
-- Monday 2 weeks ago

SET @current_day_of_week = dayofweek(curdate()); 
SET @this_week_mon = curdate() + (2 - @current_day_of_week);
SET @mon_two_weeks_ago = @this_week_mon - 14;
-- SELECT @this_week_mon;
-- SELECT @mon_two_weeks_ago;


UPDATE employees
SET hire_date = @mon_two_weeks_ago
WHERE last_name = 'Bychenkova' AND first_name = 'Elena';
