package com.my_compagnie.view;

import javax.swing.*;

public class VehiculeGUI {
    private JFrame frame;
    private JTextField marque;
    private JTextField modele;
    private JTextField annee;
    private JButton ajouter;
    private JButton chercher;
    private JButton modifier;
    private JButton supprimer;

    public VehiculeGUI() {
        // création de la fenêtre
        frame = new JFrame("Gestionnaire de Vehicule");
        // action à effectuer lorsque l'utilisateur ferme la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // la taille de la fenêtre
        frame.setSize(600, 400);
        // centrer la fenêtre au centre de l'écran
        frame.setLocationRelativeTo(null);
        // désactiver le redimensionnement de la fenêtre
        frame.setResizable(false);
        // afficher la fenêtre
        frame.setVisible(true);
    }
}
