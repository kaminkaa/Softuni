/* ###### 00 ###### */ 
CREATE DATABASE colonial_journey_management_system_db;

USE colonial_journey_management_system_db;

/* ###### 01 ###### */ 
CREATE TABLE planets (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

CREATE TABLE spaceports (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    planet_id INT,
    FOREIGN KEY (planet_id)
        REFERENCES planets (id)
);

CREATE TABLE spaceships (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    manufacturer VARCHAR(30) NOT NULL,
    light_speed_rate INT DEFAULT 0
);

CREATE TABLE colonists (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(20) NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    ucn CHAR(10) UNIQUE NOT NULL,
    birth_date DATE NOT NULL
);

CREATE TABLE journeys (
    id INT AUTO_INCREMENT PRIMARY KEY,
    journey_start DATETIME NOT NULL,
    journey_end DATETIME NOT NULL,
    purpose ENUM('Medical', 'Technical', 'Educational', 'Military'),
    destination_spaceport_id INT,
    spaceship_id INT,
    FOREIGN KEY (destination_spaceport_id)
        REFERENCES spaceports (id),
    FOREIGN KEY (spaceship_id)
        REFERENCES spaceships (id)
);

CREATE TABLE travel_cards (
    id INT AUTO_INCREMENT PRIMARY KEY,
    card_number CHAR(10) UNIQUE NOT NULL,
    job_during_journey ENUM('Pilot', 'Engineer', 'Trooper', 'Cleaner', 'Cook'),
    colonist_id INT,
    journey_id INT,
    FOREIGN KEY (colonist_id)
        REFERENCES colonists (id),
    FOREIGN KEY (journey_id)
        REFERENCES journeys (id)
);

/* ###### 1 ###### */ 
SELECT 
    CONCAT(YEAR(birth_date),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN DAY(birth_date)
                            ELSE MONTH(birth_date)
                        END)
                ),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN LEFT(ucn, 4)
                            ELSE RIGHT(ucn, 4)
                        END)
                ))
FROM
    colonists
WHERE
    id BETWEEN 96 AND 100;
    
SELECT 
    LEFT(ucn, 1)
FROM
    colonists
WHERE
    id BETWEEN 96 AND 100;

SELECT
(CASE
	WHEN id%2 = 0 THEN 'Pilot'
    WHEN id%3 = 0 THEN 'Cook'
	ELSE 'Engineer'
END)
from colonists 
where id BETWEEN 96 AND 100;

insert into travel_cards (card_number, job_during_journey, colonist_id, journey_id)
VALUES ((SELECT 
    CONCAT(YEAR(birth_date),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN DAY(birth_date)
                            ELSE MONTH(birth_date)
                        END)
                ),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN left(ucn, 4)
                            ELSE right(ucn, 4)
                        END)
                ))
FROM
    colonists
WHERE
    id=96), (SELECT
(CASE
	WHEN id%2 = 0 THEN 'Pilot'
    WHEN id%3 = 0 THEN 'Cook'
	ELSE 'Engineer'
END)
from colonists 
where id=96), 96 , (SELECT 
    LEFT(ucn, 1)
FROM
    colonists
WHERE
    id=96)),
((SELECT 
    CONCAT(YEAR(birth_date),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN DAY(birth_date)
                            ELSE MONTH(birth_date)
                        END)
                ),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN left(ucn, 4)
                            ELSE right(ucn, 4)
                        END)
                ))
FROM
    colonists
WHERE
    id=97), (SELECT
(CASE
	WHEN id%2 = 0 THEN 'Pilot'
    WHEN id%3 = 0 THEN 'Cook'
	ELSE 'Engineer'
END)
from colonists 
where id=97), 97 , (SELECT 
    LEFT(ucn, 1)
FROM
    colonists
WHERE
    id=97)),
     ((SELECT 
    CONCAT(YEAR(birth_date),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN DAY(birth_date)
                            ELSE MONTH(birth_date)
                        END)
                ),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN left(ucn, 4)
                            ELSE right(ucn, 4)
                        END)
                ))
FROM
    colonists
WHERE
    id=98), (SELECT
(CASE
	WHEN id%2 = 0 THEN 'Pilot'
    WHEN id%3 = 0 THEN 'Cook'
	ELSE 'Engineer'
END)
from colonists 
where id=98), 98 , (SELECT 
    LEFT(ucn, 1)
FROM
    colonists
WHERE
    id=98)),
    ((SELECT 
    CONCAT(YEAR(birth_date),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN DAY(birth_date)
                            ELSE MONTH(birth_date)
                        END)
                ),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN left(ucn, 4)
                            ELSE right(ucn, 4)
                        END)
                ))
FROM
    colonists
WHERE
    id=99), (SELECT
(CASE
	WHEN id%2 = 0 THEN 'Pilot'
    WHEN id%3 = 0 THEN 'Cook'
	ELSE 'Engineer'
END)
from colonists 
where id=99), 99 , (SELECT 
    LEFT(ucn, 1)
FROM
    colonists
WHERE
    id=99)),
    ((SELECT 
    CONCAT(YEAR(birth_date),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN DAY(birth_date)
                            ELSE MONTH(birth_date)
                        END)
                ),
            (SELECT 
                    (CASE
                            WHEN birth_date > '1980-01-01' THEN left(ucn, 4)
                            ELSE right(ucn, 4)
                        END)
                ))
FROM
    colonists
WHERE
    id=100), (SELECT
(CASE
	WHEN id%2 = 0 THEN 'Pilot'
    WHEN id%3 = 0 THEN 'Cook'
	ELSE 'Engineer'
END)
from colonists 
where id=100), 100 , (SELECT 
    LEFT(ucn, 1)
FROM
    colonists
WHERE
    id=100));

/* ###### 2 ###### */     
UPDATE journeys 
SET 
    purpose = CASE
        WHEN id % 2 = 0 THEN 'Medical'
        WHEN id % 3 = 0 THEN 'Technical'
        WHEN id % 5 = 0 THEN 'Educational'
        WHEN id % 7 = 0 THEN 'Military'
        ELSE purpose
    END;

/* ###### 3 ###### */      
DELETE FROM colonists 
WHERE
    id NOT IN (SELECT 
        colonist_id
    FROM
        travel_cards);
    
DELETE FROM colonists 
WHERE
    id IN (SELECT 
        colonist_id
    FROM
        travel_cards
    
    WHERE
        journey_id IS NULL);