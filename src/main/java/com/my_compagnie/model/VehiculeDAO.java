package com.my_compagnie.model;

public interface VehiculeDAO {
    public void ajouterVehicule(Vehicule vehicule);
    public Vehicule chercherVehicule(int id);
    public void modifierVehicule(Vehicule vehicule);
    public void supprimerVehicule(int id);
}
