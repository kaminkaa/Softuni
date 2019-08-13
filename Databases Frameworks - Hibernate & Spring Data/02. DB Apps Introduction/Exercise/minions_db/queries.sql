use minions_db;

 /* Problem 1. Get Villains’ Names */
SELECT 
    name AS villain_name,
    COUNT(minions_villains.minion_id) AS minions_count
FROM
    villains
        INNER JOIN
    minions_villains ON villains.id = minions_villains.villain_id
GROUP BY minions_villains.villain_id
HAVING minions_count > 15
ORDER BY minions_count DESC;

/* Problem 2. Get Minion Names */
SELECT 
    v.name AS villain_name, m.name AS minion_name, m.age
FROM
    minions AS m
        INNER JOIN
    minions_villains AS mv ON m.id = mv.minion_id
        INNER JOIN
    villains AS v ON mv.villain_id = v.id
WHERE
    v.id = 7;