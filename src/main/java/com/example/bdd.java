package com.example;
import java.sql.*;

public class bdd {
    public static void main(String login){
    String url = "jdbc:mysql://localhost:3306/employer";
    String username = "root";
    String password = "root";
    String sql = "SELECT nom,prenom, mdp FROM profil WHERE id = '"+ login + "'";
    System.out.println("En train de se connecter...");
    
    try {

        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement stmt = connection.prepareStatement(sql); // Utilisation de PreparedStatement qui va préparer la commande avant de l'éxécuter ce qui éviter les injections de différentes données.
        ResultSet users = stmt.executeQuery();
        while (users.next()) {
            String nom = users.getString("nom"); 
            String mdp = users.getString("mdp");
            System.out.println(nom+" "+mdp); 
        }

        if (connection != null) {
            System.out.println("Connexion réussie !");
        }

        } catch (SQLException ex) {
            ex.printStackTrace();
    }
  }
}
