USE colonial_journey_management_system_db;

/* ###### 4 ###### */  
SELECT 
    card_number, job_during_journey
FROM
    travel_cards
ORDER BY card_number;

/* ###### 5 ###### */  
SELECT 
    id, CONCAT(first_name, ' ', last_name) AS full_name, ucn
FROM
    colonists
ORDER BY first_name , last_name , id;

/* ###### 6 ###### */  
SELECT 
    id, journey_start, journey_end
FROM
    journeys
WHERE
    purpose = 'Military'
ORDER BY journey_start;

/* ###### 7 ###### */  
SELECT 
    id, CONCAT(first_name, ' ', last_name) AS full_name
FROM
    colonists
WHERE
    id IN (SELECT 
            colonist_id
        FROM
            travel_cards
        WHERE
            job_during_journey = 'Pilot')
ORDER BY id;

/* ###### 8 ###### */  
SELECT 
    COUNT(colonist_id)
FROM
    travel_cards
WHERE
    journey_id IN (SELECT 
            id
        FROM
            journeys
        WHERE
            purpose = 'Technical');

/* ###### 9 ###### */              
SELECT 
    spaceships.name AS spaceship_name,
    spaceports.name AS spaceport_name
FROM
    spaceships
        INNER JOIN
    journeys ON spaceships.id = journeys.spaceship_id
        INNER JOIN
    spaceports ON journeys.destination_spaceport_id = spaceports.id
WHERE
    light_speed_rate = (SELECT 
            MAX(light_speed_rate)
        FROM
            spaceships);

/* ###### 10 ###### */  
SELECT 
    spaceships.name, spaceships.manufacturer
FROM
    spaceships
        INNER JOIN
    journeys ON spaceships.id = journeys.spaceship_id
        INNER JOIN
    travel_cards ON journeys.id = travel_cards.journey_id
        INNER JOIN
    colonists ON travel_cards.colonist_id = colonists.id
WHERE
    (2019 - YEAR(colonists.birth_date) < 30)
        && travel_cards.job_during_journey = 'Pilot'
ORDER BY spaceships.name;

/* ###### 11 ###### */              
SELECT 
    planets.name AS planet_name,
    spaceports.name AS spaceport_name
FROM
    planets
        INNER JOIN
    spaceports ON planets.id = spaceports.planet_id
        INNER JOIN
    journeys ON spaceports.id = journeys.destination_spaceport_id
WHERE
    journeys.purpose = 'Educational'
ORDER BY spaceport_name DESC;

/* ###### 12 ###### */  
SELECT 
    planets.name AS planet_name,
    COUNT(journeys.id) AS journeys_count
FROM
    planets
        INNER JOIN
    spaceports ON planets.id = spaceports.planet_id
        INNER JOIN
    journeys ON spaceports.id = journeys.destination_spaceport_id
GROUP BY planets.id
ORDER BY journeys_count desc, planet_name;

/* ###### 13 ###### */  
SELECT 
    journeys.id,
    planets.name AS planet_name,
    spaceports.name AS spaceport_name,
    journeys.purpose AS journey_purpose
FROM
    planets
        INNER JOIN
    spaceports ON planets.id = spaceports.planet_id
        INNER JOIN
    journeys ON spaceports.id = journeys.destination_spaceport_id
WHERE
    journeys.id = (SELECT 
            id
        FROM
            journeys
        ORDER BY TIMESTAMPDIFF(SECOND,
            journey_start,
            journey_end)
        LIMIT 1);

/* ###### 14 ###### */  
SELECT 
    journeys.id
FROM
    journeys
WHERE
    journeys.id = (SELECT 
            id
        FROM
            journeys
        ORDER BY TIMESTAMPDIFF(SECOND,
            journey_start,
            journey_end) DESC
        LIMIT 1);
        
SELECT 
    *
FROM
    travel_cards
WHERE
    journey_id = 7;
    
SELECT 
    job_during_journey AS job_name
FROM
    travel_cards
WHERE
    journey_id = (SELECT 
            journeys.id
        FROM
            journeys
        WHERE
            journeys.id = (SELECT 
                    id
                FROM
                    journeys
                ORDER BY TIMESTAMPDIFF(SECOND,
                    journey_start,
                    journey_end) DESC
                LIMIT 1))
GROUP BY job_during_journey
ORDER BY COUNT(colonist_id)
LIMIT 1;

/* ###### 15 ###### */  
DELIMITER $$        
create FUNCTION udf_count_colonists_by_destination_planet(planet_name VARCHAR (30))
returns INT
begin
DECLARE result int;

set result:=( 
SELECT 
    COUNT(travel_cards.id) AS count
FROM
    travel_cards
        INNER JOIN
    journeys ON travel_cards.journey_id = journeys.id
        INNER JOIN
    spaceports ON journeys.destination_spaceport_id = spaceports.id
        INNER JOIN
    planets ON spaceports.planet_id = planets.id
WHERE
    planets.name = planet_name);
    
    return result;
end $$ 

SELECT 
    p.name AS name,
    UDF_COUNT_COLONISTS_BY_DESTINATION_PLANET('Otroyphus') AS count
FROM
    planets AS p
WHERE
    p.name = 'Otroyphus';

/* ###### 16 ###### */  
DELIMITER $$
CREATE PROCEDURE udp_modify_spaceship_light_speed_rate(spaceship_name VARCHAR(50), light_speed_rate_increse INT(11)) 
BEGIN
	START TRANSACTION;
    
	IF((SELECT count(id) FROM spaceships WHERE name=spaceship_name)<>1) THEN
		ROLLBACK;
        SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = 'Spaceship you are trying to modify does not exists.';
	ELSE
		UPDATE spaceships
        SET light_speed_rate = light_speed_rate + light_speed_rate_increse 
		WHERE name = spaceship_name;
	END IF; 
END $$

CALL udp_modify_spaceship_light_speed_rate ('Na Pesho koraba', 1914);
SELECT 
    name, light_speed_rate
FROM
    spacheships
WHERE
    name = 'Na Pesho koraba';

CALL udp_modify_spaceship_light_speed_rate ('USS Templar', 5);
SELECT 
    name, light_speed_rate
FROM
    spaceships
WHERE
    name = 'USS Templar';

SELECT 
    COUNT(id)
FROM
    spaceships
WHERE
    name = 'USS Templar';


