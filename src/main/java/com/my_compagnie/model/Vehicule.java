package com.my_compagnie.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Vehicule implements VehiculeDAO {
    private int id;
    private String marque;
    private String modele;
    private String annee;

    @Override
    public void ajouterVehicule(Vehicule vehicule) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicule?useSSL=false", "root","")) {
            String sql = "INSERT INTO vehicule (marque, modele, annee) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, vehicule.getMarque());
            statement.setString(2, vehicule.getModele());
            statement.setString(3, vehicule.getAnnee());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Vehicule chercherVehicule(int id) {
        Vehicule vehicule = null;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicule?useSSL=false", "root","")) {
            String sql = "SELECT * FROM vehicule WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                vehicule = new Vehicule();
                vehicule.setId(result.getInt("id"));
                vehicule.setMarque(result.getString("marque"));
                vehicule.setModele(result.getString("modele"));
                vehicule.setAnnee(result.getString("annee"));
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return vehicule;
    }

    @Override
    public void modifierVehicule(Vehicule vehicule) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicule?useSSL=false", "root","")) {
            String sql = "UPDATE vehicule SET marque = ?, modele = ?, annee = ? WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, vehicule.getMarque());
            statement.setString(2, vehicule.getModele());
            statement.setString(3, vehicule.getAnnee());
            statement.setInt(4, vehicule.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void supprimerVehicule(int id) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehicule?useSSL=false", "root","")) {
            String sql = "DELETE FROM vehicule WHERE id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
