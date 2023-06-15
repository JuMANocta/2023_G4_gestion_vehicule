package com.my_compagnie.model;

import java.util.List;

public interface VehiculeDAO {
    public void ajouterVehicule(Vehicule vehicule);
    public Vehicule chercherVehicule(int id);
    public void modifierVehicule(Vehicule vehicule);
    public void supprimerVehicule(int id);
    public List <Vehicule> listerVehicule(int annee);
}
