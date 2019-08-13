/* ###### 1 ###### */
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above_35000() 
BEGIN
  SELECT first_name, last_name
  FROM employees
  WHERE salary > 35000
  ORDER BY first_name, last_name;
END $$

/* ###### 2 ###### */
DELIMITER $$
CREATE PROCEDURE usp_get_employees_salary_above(num DOUBLE) 
BEGIN
  SELECT first_name, last_name
  FROM employees
  WHERE salary >= num
  ORDER BY first_name, last_name;
END $$

/* ###### 3 ###### */
DELIMITER $$
CREATE PROCEDURE usp_get_towns_starting_with(IN _letter VARCHAR(50))
BEGIN
SELECT t.name FROM towns AS t
WHERE LEFT (t.name, CHAR_LENGTH(_letter)) = _letter
order by t.name;
END $$

/* ###### 4 ###### */
DELIMITER $$
CREATE PROCEDURE usp_get_employees_from_town(town_name varchar(20))
BEGIN
SELECT e.first_name,e.last_name FROM employees AS e
JOIN addresses as a on a.address_id = e.address_id
JOIN towns as t on t.town_id = a.town_id
WHERE t.name = town_name
order by e.first_name,e.last_name;
END $$

/* ###### 5 ###### */
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(employee_salary DECIMAL)
RETURNS VARCHAR(10)
BEGIN
	DECLARE salary_level varchar(10);
	if(employee_salary<30000) then 
		set salary_level := 'Low';
	elseif(employee_salary>=30000 and employee_salary <= 50000) then 
		set salary_level := 'Average';
	else 
		set salary_level := 'High';
	end if;
	RETURN salary_level;
END $$

/* ###### 6 ###### */
DELIMITER $$
CREATE FUNCTION ufn_get_salary_level(salary DECIMAL(19,4))
RETURNS VARCHAR(10)
BEGIN
	DECLARE salary_level VARCHAR(10);
IF (salary < 30000) THEN
SET salary_level := 'Low';
ELSEIF(salary >= 30000 AND salary <= 50000) THEN
SET salary_level := 'Average';
ELSE
SET salary_level := 'High';
END IF;
RETURN salary_level;
END;

CREATE PROCEDURE usp_get_employees_by_salary_level(IN salary_level VARCHAR(10))
BEGIN
 SELECT e.first_name, e.last_name FROM employees AS e 
 WHERE ufn_get_salary_level(e.salary) = salary_level
 ORDER BY e.first_name DESC, e.last_name DESC;
END $$

/* ###### 7 ###### */
DELIMITER $$
create function ufn_is_word_comprised(set_of_letters varchar(50), word varchar(50))
returns int
begin
	declare result int;
	declare ind int;
	declare val int;
	declare size int;
	set size := length(word);
	set ind := 1;
	set result := 1;
	
	while(ind < size) do
		set val := (select instr(set_of_letters, substring(word, ind, 1)));
			if(val = 0) then 
				set result = 0;
				return result;
			end if;
		set ind = ind +1;
	end while;
	return result;
end  $$

/* ###### 8 ###### */
DELIMITER $$
SET FOREIGN_KEY_CHECKS = 0;

DELETE FROM employees
WHERE department_id IN (SELECT d.department_id FROM `departments` AS d
WHERE d.name IN ('Production', 'Production Control'));

DELETE FROM `departments`
WHERE
  `name` IN ('Production', 'Production Control');
SET FOREIGN_KEY_CHECKS = 1;
