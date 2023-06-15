CREATE DATABASE IF NOT EXISTS gestion_vehicule;
USE gestion_vehicule;
CREATE TABLE IF NOT EXISTS vehicule(
    id INT AUTO_INCREMENT PRIMARY KEY,
    marque VARCHAR(50) NOT NULL,
    modele VARCHAR(50) NOT NULL,
    annee INT NOT NULL
);