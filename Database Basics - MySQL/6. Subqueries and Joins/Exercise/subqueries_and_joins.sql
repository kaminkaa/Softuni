/* ###### 1 ###### */
SELECT 
    e.first_name, e.last_name, e.address_id, text
FROM
    employees AS e
        JOIN
    addresses AS a ON e.address_id = a.address_id
ORDER BY a.address_id
LIMIT 5;

/* ###### 2 ###### */
SELECT 
    e.first_name, e.last_name, t.name, a.address_text
FROM
    employees AS e
        INNER JOIN
    addresses AS a ON e.address_id = a.address_id
        INNER JOIN
    towns AS t ON t.town_id = a.town_id
ORDER BY e.first_name , e.last_name ASC
LIMIT 5;

/* ###### 3 ###### */
SELECT 
    e.employee_id, e.first_name, e.last_name, d.name
FROM
    employees AS e
        LEFT JOIN
    departments AS d ON d.department_id = e.department_id
WHERE
    d.name = 'Sales'
ORDER BY e.employee_id DESC;

/* ###### 4 ###### */
SELECT 
    e.employee_id,
    e.first_name,
    e.salary,
    d.name AS 'department_name'
FROM
    employees AS e
        INNER JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    e.salary >= 15000
ORDER BY d.department_id DESC
LIMIT 5;

/* ###### 5 ###### */
SELECT 
    e.employee_id, e.first_name
FROM
    employees AS e
        LEFT JOIN
    employees_projects AS p ON e.employee_id = p.employee_id
WHERE
    p.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;

/* ###### 6 ###### */
SELECT 
    e.first_name, e.last_name, e.hire_date, d.name
FROM
    employees AS e
        INNER JOIN
    departments AS d ON e.department_id = d.department_id
        AND DATE(e.hire_date) > '1999-01-01'
WHERE
    d.name IN ('Finance' , 'Sales')
ORDER BY e.hire_date;

/* ###### 7 ###### */
SELECT 
    e.employee_id, e.first_name, p.name
FROM
    employees AS e
        INNER JOIN
    employees_projects AS ep ON ep.employee_id = e.employee_id
        INNER JOIN
    projects AS p ON p.project_id = ep.project_id
        AND DATE(p.start_date) > '2002-08-13'
        AND DATE(p.end_date) IS NULL
ORDER BY e.first_name , p.name ASC
LIMIT 5;

/* ###### 8 ###### */
SELECT 
    e.employee_id,
    e.first_name,
    CASE
        WHEN p.start_date >= '2005-01-01' THEN NULL
        ELSE p.name
    END
FROM
    employees AS e
        INNER JOIN
    employees_projects AS ep ON ep.employee_id = e.employee_id
        INNER JOIN
    projects AS p ON ep.project_id = p.project_id
WHERE
    ep.employee_id = 24
ORDER BY p.name ASC;

/* ###### 9 ###### */
SELECT 
    e.employee_id,
    e.first_name,
    e.manager_id,
    m.first_name AS `manager_name`
FROM
    employees AS e
        LEFT JOIN
    employees AS m ON e.manager_id = m.employee_id
WHERE
    m.employee_id IN (3 , 7)
ORDER BY e.first_name;

/* ###### 10 ###### */
SELECT 
    e.employee_id,
    CONCAT(e.first_name, ' ', e.last_name) AS `employee_name`,
    CONCAT(m.first_name, ' ', m.last_name) AS `manager_name`,
    d.name AS `department_name`
FROM
    employees AS e
        INNER JOIN
    employees AS m ON e.manager_id = m.employee_id
        INNER JOIN
    departments AS d ON d.department_id = e.department_id
ORDER BY e.employee_id
LIMIT 5;

/* ###### 11 ###### */
SELECT 
    MIN(min_avg_salary)
FROM
    (SELECT 
        AVG(e.salary) AS min_avg_salary
    FROM
        employees AS e
    GROUP BY e.department_id) AS min_salaries;

/* ###### 12 ###### */
SELECT 
    c.country_code, m.mountain_range, p.peak_name, p.elevation
FROM
    countries AS c
        INNER JOIN
    mountains_countries AS mc ON mc.country_code = c.country_code
        INNER JOIN
    mountains AS m ON m.id = mc.mountain_id
        INNER JOIN
    peaks AS p ON p.mountain_id = mc.mountain_id
WHERE
    c.country_name = 'Bulgaria'
        AND p.elevation > 2835
ORDER BY p.elevation DESC;
	
/* ###### 13 ###### */
SELECT 
    c.country_code,
    COUNT(mc.mountain_id) AS `mountain_range_count`
FROM
    countries AS c
        INNER JOIN
    mountains_countries AS mc ON mc.country_code = c.country_code
WHERE
    mc.country_code IN ('US' , 'RU', 'BG')
GROUP BY mc.country_code
ORDER BY mountain_range_count DESC;

/* ###### 14 ###### */
SELECT 
    c.country_name, r.river_name
FROM
    countries AS c
        LEFT JOIN
    countries_rivers AS cr ON c.country_code = cr.country_code
        LEFT JOIN
    rivers AS r ON r.id = cr.river_id
WHERE
    c.continent_code = 'AF'
ORDER BY c.country_name ASC
LIMIT 5;

/* ###### 15 ###### */
SELECT 
    t1.continent_code, t1.currency_code, t1.currency_usage
FROM
    (SELECT 
        c.continent_code AS continent_code,
            b.currency_code AS currency_code,
            COUNT(b.currency_code) AS currency_usage
    FROM
        continents AS c
    JOIN countries AS b ON c.continent_code = b.continent_code
    JOIN currencies AS a ON a.currency_code = b.currency_code
    GROUP BY c.continent_code , b.currency_code
    HAVING currency_usage > 1) AS t1
        INNER JOIN
    (SELECT 
        sub.continent_code AS code, MAX(currency_usage) AS max_u
    FROM
        (SELECT 
        c.continent_code AS continent_code,
            b.currency_code AS currency_code,
            COUNT(b.currency_code) AS currency_usage
    FROM
        continents AS c
    JOIN countries AS b ON c.continent_code = b.continent_code
    JOIN currencies AS a ON a.currency_code = b.currency_code
    GROUP BY c.continent_code , b.currency_code
    HAVING currency_usage > 1) AS sub
    GROUP BY code) AS t2 ON t1.continent_code = t2.code
WHERE
    t1.currency_usage = t2.max_u;

/* ###### 16 ###### */
SELECT 
    COUNT(*)
FROM
    countries AS c
        LEFT OUTER JOIN
    mountains_countries AS mc ON mc.country_code = c.country_code
WHERE
    mc.country_code IS NULL;

/* ###### 17 ###### */
SELECT 
    c.`country_name`,
    MAX(p.`elevation`) AS 'highest_peak_elevation',
    MAX(r.`length`) AS 'longest_river_length'
FROM
    `countries` AS c
        LEFT JOIN
    `mountains_countries` AS mc ON c.`country_code` = mc.`country_code`
        LEFT JOIN
    `peaks` AS p ON mc.`mountain_id` = p.`mountain_id`
        LEFT JOIN
    `countries_rivers` AS cr ON c.`country_code` = cr.`country_code`
        LEFT JOIN
    `rivers` AS r ON cr.`river_id` = r.`id`
GROUP BY c.`country_name`
ORDER BY `highest_peak_elevation` DESC , `longest_river_length` DESC , c.`country_name`
LIMIT 5;