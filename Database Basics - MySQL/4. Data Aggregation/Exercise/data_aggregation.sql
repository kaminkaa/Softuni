/* ###### 1 ###### */
SELECT 
    COUNT(*) AS count
FROM
    wizzard_deposits;

/* ###### 2 ###### */
SELECT 
    MAX(magic_wand_size) AS `longest_magic_wand`
FROM
    wizzard_deposits;

/* ###### 3 ###### */
SELECT 
    deposit_group, MAX(magic_wand_size) AS `longest_magic_wand`
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY `longest_magic_wand` , deposit_group;

/* ###### 4 ###### */
SELECT 
    `deposit_group`
FROM
    wizzard_deposits AS w
GROUP BY w.deposit_group
ORDER BY AVG(w.magic_wand_size)
LIMIT 1;

/* ###### 5 ###### */
SELECT 
    `deposit_group`, SUM(deposit_amount) AS `total_sum`
FROM
    wizzard_deposits
GROUP BY deposit_group
ORDER BY `total_sum`;

/* ###### 6 ###### */
SELECT 
    `deposit_group`, SUM(deposit_amount) AS `total_sum`
FROM
    wizzard_deposits
WHERE
    magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
ORDER BY deposit_group;

/* ###### 7 ###### */
SELECT 
    `deposit_group`, SUM(deposit_amount) AS `total_sum`
FROM
    wizzard_deposits
WHERE
    magic_wand_creator = 'Ollivander family'
GROUP BY deposit_group
HAVING total_sum < 150000
ORDER BY deposit_group DESC;
 
/* ###### 8 ###### */
SELECT 
    w.magic_wand_creator,
    w.deposit_group,
    MIN(w.deposit_charge) AS min_deposit_charge
FROM
    wizzard_deposits AS w
GROUP BY w.magic_wand_creator , w.deposit_group
ORDER BY w.magic_wand_creator , w.deposit_group;

/* ###### 9 ###### */
SELECT 
    a.age_group, COUNT(*) AS `wizard_count`
FROM
    (SELECT 
        CASE
                WHEN wd.age BETWEEN 0 AND 10 THEN '[0-10]'
                WHEN wd.age BETWEEN 11 AND 20 THEN '[11-20]'
                WHEN wd.age BETWEEN 21 AND 30 THEN '[21-30]'
                WHEN wd.age BETWEEN 31 AND 40 THEN '[31-40]'
                WHEN wd.age BETWEEN 41 AND 50 THEN '[41-50]'
                WHEN wd.age BETWEEN 51 AND 60 THEN '[51-60]'
                ELSE '[61+]'
            END AS `age_group`
    FROM
        `wizzard_deposits` AS `wd`) AS `a`
GROUP BY a.age_group;
        
/* ###### 10 ###### */
SELECT 
    SUBSTRING(first_name, 1, 1) AS `first_letter`
FROM
    wizzard_deposits
WHERE
    deposit_group = 'Troll Chest'
GROUP BY `first_letter`
ORDER BY `first_letter`;

/* ###### 11 ###### */
SELECT 
    deposit_group, is_deposit_expired, AVG(deposit_interest)
FROM
    wizzard_deposits
WHERE
    deposit_start_date > '1985-01-01'
GROUP BY deposit_group , is_deposit_expired
ORDER BY deposit_group DESC , is_deposit_expired ASC;

/* ###### 12 ###### */
SELECT 
    SUM(diff.next) AS sum_difference
FROM
    (SELECT 
        deposit_amount - (SELECT 
                    deposit_amount
                FROM
                    wizzard_deposits
                WHERE
                    id = wd.id + 1) AS next
    FROM
        wizzard_deposits AS wd) AS diff;
     
/* ###### 13 ###### */  
SELECT 
    department_id, MIN(salary)
FROM
    employees
WHERE
    department_id = 2 OR department_id = 5
        OR department_id = 7
        AND hire_date > '2000-01-01'
GROUP BY department_id
ORDER BY department_id ASC;

/* ###### 14 ###### */
CREATE TABLE newtable SELECT * FROM employees where salary > 30000;
delete from newtable where manager_id = 42;
update newtable set salary = salary + 5000 where department_id = 1 and salary > 30000;
SELECT 
    department_id, AVG(salary)
FROM
    newtable
GROUP BY department_id
ORDER BY department_id ASC;

/* ###### 15 ###### */
SELECT 
    department_id, MAX(salary)
FROM
    employees
GROUP BY department_id
HAVING MAX(salary) < 30000
    OR MAX(salary) > 70000
ORDER BY department_id ASC;

/* ###### 16 ###### */
SELECT 
    COUNT(salary)
FROM
    employees
WHERE
    manager_id IS NULL;