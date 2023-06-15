package com.my_compagnie.view;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import com.my_compagnie.model.Vehicule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.ArrayList;
import java.util.List;

public class VehiculeGUI {
    private JFrame frame;
    private JTextField id;
    private JTextField marque;
    private JTextField modele;
    private JTextField annee;
    private JButton effacer;
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

        // création des composants avec une contrainte
        JPanel panel = new JPanel(new GridBagLayout());
        // grille de contraintes
        GridBagConstraints constraints = new GridBagConstraints();
        // l'emplacement des composants dans notre grille
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        // ajout notre JLabel dans notre grille
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Marque"), constraints);
        // ajout notre JTextField dans notre grille
        constraints.gridx = 1;
        marque = new JTextField(20);
        panel.add(marque, constraints);
        // ajout d'un bouton pour effacer les informations des jtextfield
        constraints.gridx = 2;
        effacer = new JButton("Effacer");
        effacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetInput();
            }
        });
        panel.add(effacer, constraints);
        // ajout du label et de son jtextfield pour le modele
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Modele"), constraints);
        constraints.gridx = 1;
        modele = new JTextField(20);
        panel.add(modele, constraints);
        // ajout du label et de son jtextfield pour l'annee
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Annee"), constraints);
        constraints.gridx = 1;
        annee = new JTextField(20);
        panel.add(annee, constraints);
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Id"), constraints);
        constraints.gridx = 1;
        id = new JTextField(20);
        panel.add(id, constraints);
        constraints.gridx = 1;

        // ajout des boutons et de leurs emplacement
        JPanel boutonPanel = new JPanel(new GridLayout(1, 4, 10, 0));
        ajouter = new JButton("Ajouter");
        boutonPanel.add(ajouter, constraints);

        chercher = new JButton("Chercher");
        boutonPanel.add(chercher, constraints);

        modifier = new JButton("Modifier");
        boutonPanel.add(modifier, constraints);

        supprimer = new JButton("Supprimer");
        boutonPanel.add(supprimer, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 4;

        panel.add(boutonPanel, constraints);

        // ajout d'un tableau pour afficher les vehicules
        String[] columnNames = { "Id", "Marque", "Modele", "Annee" };
        final DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // TODO
            }
        };
        final JTable table = new JTable(tableModel);
        JButton boutonModifier = new JButton("Modifier");
        JButton boutonSupprimer = new JButton("Supprimer");

        // Définir le rendu de l'éditeur pour les colonnes de boutons
        TableCellRenderer tableCellRenderer = new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                return (Component) value; // TODO
            }
        };
        // TableCellEditor boutonEditeur = new AbstractCellEditor() {
        // public Component getTableCellEditorComponent(JTable table, Object value,
        // boolean isSelected, int row,
        // int column) {
        // return column == 4 ? boutonModifier : boutonSupprimer;
        // }

        // public Object getCellEditorValue() {
        // return null;
        // }
        // };

        JScrollPane scrollPane = new JScrollPane(table);
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 4;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, constraints);

        // ajout notre JLabel dans notre grille
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        // ajuster automatiquement la taille de la fenêtre
        frame.pack();
        // centrer la fenêtre au centre de l'écran
        frame.setLocationRelativeTo(null);
        // désactiver le redimensionnement de la fenêtre
        frame.setResizable(false);
        // afficher la fenêtre
        frame.setVisible(true);

        // ajouter les actions aux boutons
        ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                Vehicule vehicule = new Vehicule();
                if (marque.getText().isEmpty() || modele.getText().isEmpty() || annee.getText().isEmpty()) {
                    retourMessage("Veuillez remplir tous les champs", "Erreur", "erreur");
                } else {
                    try {
                        vehicule.setMarque(marque.getText());
                        vehicule.setModele(modele.getText());
                        vehicule.setAnnee(Integer.parseInt(annee.getText()));
                        vehicule.ajouterVehicule(vehicule);
                        retourMessage("Vehicule ajouté avec succès", "Succès", "succes");
                        resetInput();
                    } catch (Exception ex) {
                        retourMessage("Veuillez entrer un nombre pour l'année", "Erreur", "erreur");
                    }
                }
            }
        });
        // chercher.addActionListener(new ActionListener() {
        // @Override
        // public void actionPerformed(ActionEvent e) {
        // Vehicule vehicule = new Vehicule();
        // vehicule = vehicule.chercherVehicule(Integer.parseInt(id.getText()));
        // if (vehicule != null) {
        // marque.setText(vehicule.getMarque());
        // modele.setText(vehicule.getModele());
        // annee.setText(Integer.toString(vehicule.getAnnee()));
        // } else {
        // JOptionPane.showMessageDialog(frame, "Vehicule introuvable", "Erreur",
        // JOptionPane.ERROR_MESSAGE);
        // }
        // }
        // });
        chercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.setRowCount(0);
                Vehicule vehicule = new Vehicule();
                List<Vehicule> vehicules = vehicule.listerVehicule(Integer.parseInt(annee.getText()));
                // ajouter les vehicules dans le tableau
                for (Vehicule v : vehicules) {
                    tableModel.addRow(new Object[] { v.getId(), v.getMarque(), v.getModele(), v.getAnnee() });
                }
            }
        });
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e) {
                int row = table.getSelectedRow();
                if (row > -1) {
                    id.setText(table.getValueAt(row, 0).toString());
                    marque.setText(table.getValueAt(row, 1).toString());
                    modele.setText(table.getValueAt(row, 2).toString());
                    annee.setText(table.getValueAt(row, 3).toString());
                }
            }
        });
    }

    private void resetInput() {
        marque.setText("");
        modele.setText("");
        annee.setText("");
        id.setText("");
    }

    private void retourMessage(String message, String titre, String type) {
        if (type == "erreur") {
            JOptionPane.showMessageDialog(frame, message, titre, JOptionPane.ERROR_MESSAGE);
        } else if (type == "succes") {
            JOptionPane.showMessageDialog(frame, message, titre, JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(frame, message, titre, JOptionPane.WARNING_MESSAGE);
        }
    }
}
