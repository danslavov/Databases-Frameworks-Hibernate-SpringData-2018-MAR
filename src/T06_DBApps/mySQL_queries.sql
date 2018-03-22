-- create DB and tables

CREATE DATABASE minionsDB;
USE minionsDB;

CREATE TABLE towns (
town_id INT AUTO_INCREMENT PRIMARY KEY,
town_name VARCHAR(50),
country VARCHAR(20));

CREATE TABLE villains (
villain_id INT AUTO_INCREMENT PRIMARY KEY,
villain_name VARCHAR(20),
evilness VARCHAR(10));

CREATE TABLE minions (
minion_id INT AUTO_INCREMENT PRIMARY KEY,
minion_name VARCHAR(20),
minion_age INT,
town_id INT NOT NULL,
CONSTRAINT fk_minions_towns FOREIGN KEY (town_id) REFERENCES towns(town_id));

CREATE TABLE minions_villains (
minion_id INT NOT NULL,
villain_id INT NOT NULL,
PRIMARY KEY (minion_id, villain_id),
CONSTRAINT fk_minions_villains_minions
FOREIGN KEY(minion_id) REFERENCES minions(minion_id),
CONSTRAINT fk_minions_villains_villains
FOREIGN KEY(villain_id) REFERENCES villains(villain_id));


-- fill records

INSERT INTO towns(town_name, country) VALUES
('Sofia', 'Bulgaria'),
('Varna', 'Bulgaria'),
('Athens', 'Greece'),
('Thessaloniki', 'Greece'),
('Mangalia', 'Romania');

INSERT INTO villains(villain_name, evilness) VALUES
('Pencho', 'good'),
('Gencho', 'bad'),
('Muncho', 'evil'),
('Perduncho', 'evil'),
('Tapuncho', 'super evil');

INSERT INTO minions(minion_name, minion_age, town_id) VALUES
('Min1', 1, 1),
('Min2', 2, 1),
('Min3', 2, 2),
('Min4', 2, 3),
('Min5', 3, 3),
('Min6', 2, 3),
('Min7', 2, 3),
('Min8', 2, 3),
('Min9', 2, 3),
('Min10', 2, 3);

INSERT INTO minions_villains VALUES
(1, 1), (2, 1), (3, 1), (4, 1), (1, 2), (2, 2), (3, 2);


-- ***************************
-- Exercises
-- ***************************

-- 2. Get Villains’ Names

SELECT v.villain_name AS v_name, count(*) AS m_count
FROM villains AS v
JOIN minions_villains AS mv ON v.villain_id = mv.villain_id
GROUP BY v_name
HAVING m_count > 3;


-- 3. Get Minion Names

SELECT v.villain_name, m.minion_name, m.minion_age
FROM minions AS m
JOIN minions_villains AS mv ON m.minion_id = mv.minion_id
RIGHT JOIN villains AS v ON mv.villain_id = v.villain_id
WHERE v.villain_id = 10;


-- 4. Add Minion

DELIMITER $$
DROP PROCEDURE IF EXISTS make_names_unique$$
CREATE PROCEDURE make_names_unique()
BEGIN
	ALTER TABLE towns ADD UNIQUE(town_name);
	ALTER TABLE villains ADD UNIQUE(villain_name);
	ALTER TABLE minions ADD UNIQUE(minion_name);
END$$
DELIMITER ;

CALL make_names_unique();

DELIMITER $$
DROP PROCEDURE IF EXISTS drop_unique_keys$$
CREATE PROCEDURE drop_unique_keys()
BEGIN
	ALTER TABLE `minionsdb`.`minions` 
	DROP INDEX `minion_name` ;
	ALTER TABLE `minionsdb`.`towns` 
	DROP INDEX `town_name` ;
	ALTER TABLE `minionsdb`.`villains` 
	DROP INDEX `villain_name` ;
END$$
DELIMITER ;

CALL drop_unique_keys;

DELIMITER $$
DROP PROCEDURE IF EXISTS add_records$$
CREATE PROCEDURE add_records(
	minion_name VARCHAR(20), minion_age INT,
    town_name VARCHAR(50), villain_name VARCHAR(20))
BEGIN
	INSERT INTO towns(town_name) VALUES(town_name);
    INSERT INTO villains(villain_name) VALUES(villain_name);
    
	INSERT INTO minions(minion_name, minion_age, town_id) VALUES (
		minion_name,
		minion_age,
        (SELECT t.town_id FROM towns AS t WHERE t.town_name = town_name));
    
    INSERT INTO minions_villains VALUES (
		(SELECT m.minion_id FROM minions AS m WHERE m.minion_name = minion_name),
		(SELECT v.villain_id FROM villains AS v WHERE v.villain_name = villain_name));
END$$
DELIMITER ;

CALL add_records('delete_minion', 100, 'delete_town', 'delete_villain');

INSERT INTO towns(town_name)
SELECT * FROM (SELECT 'Mahachkala') AS tmp
WHERE NOT EXISTS (SELECT t.town_name FROM towns AS t
WHERE t.town_name = 'Mahachkala') LIMIT 1;

INSERT IGNORE INTO minions(minion_name, minion_age, town_id) VALUES (
	minion_name,
	minion_age,
	(SELECT t.town_id FROM towns AS t WHERE t.town_name = town_name));


-- 5. Change Town Names Casing

UPDATE towns SET town_name = UPPER(town_name)
WHERE country = 'Bulgaria';

SELECT t.town_name FROM towns AS t WHERE t.country = 'Bulgaria';


-- 6. Remove Villain

SET FOREIGN_KEY_CHECKS=0;
SELECT v.villain_name FROM villains AS v WHERE v.villain_id = 1;
DELETE FROM villains WHERE villain_id = 1;
DELETE FROM minions_villains WHERE villain_id = 1;
SET FOREIGN_KEY_CHECKS=1;


-- 8. Increase Minions Age

UPDATE minions AS m SET m.minion_age = m.minion_age + 1
WHERE m.minion_id IN (2, 3, 4);

UPDATE minions AS m SET m.minion_name =
concat(upper(left(m.minion_name, 1)), substr(m.minion_name, 2))
WHERE m.minion_id IN (1, 3, 5);


-- 9. Increase Age Stored Procedure

DELIMITER $$
DROP PROCEDURE IF EXISTS usp_get_older$$

CREATE PROCEDURE usp_get_older(minion_id INT)
BEGIN
UPDATE minions AS m SET m.minion_age = m.minion_age + 1
WHERE m.minion_id = minion_id;
END$$
DELIMITER ;