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
  PRIMARY KEY (minion_id, villain_id));


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
  ('Min5', 3, 3);

INSERT INTO minions_villains VALUES
  (1, 1), (1, 2), (1, 3), (2, 1), (3, 1), (4, 1), (1, 5);