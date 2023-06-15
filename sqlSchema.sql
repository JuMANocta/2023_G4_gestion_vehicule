CREATE DATABASE IF NOT EXISTS gestion_vehicule;
USE gestion_vehicule;
CREATE TABLE IF NOT EXISTS vehicule(
    id INT AUTO_INCREMENT PRIMARY KEY,
    marque VARCHAR(50) NOT NULL,
    modele VARCHAR(50) NOT NULL,
    annee INT NOT NULL
);
INSERT INTO vehicule (marque, modele, annee) VALUES 
("Tesla", "Model 3", 2020),
("Renault", "Clio", 2021),
("BMW", "i3", 2019),
("Mercedes", "Class A", 2018),
("Audi", "A3", 2017),
("Ferrari", "F40", 1987),
("Toyota", "Prius", 2016),
("Nissan", "Leaf", 2020),
("Hyundai", "Ioniq", 2021),
("Volkswagen", "Golf", 2018),
("Peugeot", "208", 2021),
("Citroen", "C3", 2020),
("Ford", "Fiesta", 2019),
("Opel", "Corsa", 2020),
("Dacia", "Sandero", 2021),
("Volvo", "XC60", 2018),
("Mitsubishi", "Outlander", 2020),
("Lexus", "RX", 2019),
("Jaguar", "XE", 2020),
("Alfa Romeo", "Giulia", 2017),
("Fiat", "500", 2021),
("Mazda", "3", 2019),
("Land Rover", "Discovery", 2018),
("Subaru", "Impreza", 2020),
("Bentley", "Continental GT", 2019);
