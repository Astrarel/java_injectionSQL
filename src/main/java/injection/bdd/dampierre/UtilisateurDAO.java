package injection.bdd.dampierre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurDAO {

    public List<Utilisateur> trouverParNom(String nom) {

        Bdd bdd = new Bdd();
        Connection conn = bdd.connexion();

        String sql = String.format("select id, prenom, nom from profil where nom = '%s'", nom);
        // String sql = String.format ("select ID_USER, Prenom, Nom, Email from user
        // where Nom = ?");
        // A chaque fois que l'on veut faire une entre utilisateur on utilise ? et non
        // une concaténation
        List<Utilisateur> utilisateurs = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            // Faire une requête preparer pour avoir plus de sécurité et enlever les
            // caractères bizzarre apres le nom
            // PreparedStatement stmt = conn.prepareStatement(sql);
            // Pour le premier point ? on lui ajoute la variable nom que l'on veut demander
            // à l'utilisateur
            // stmt.setString(1,nom);
            // ResultSet res = stmt.executeQuery();

            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                utilisateurs.add(contruireClientDepuis(res));
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return utilisateurs;
    }

    private Utilisateur contruireClientDepuis(ResultSet res) throws SQLException {

        Long id = res.getLong("id");
        String prenom = res.getString("prenom");
        String nom = res.getString("nom");

        Utilisateur utilisateur = new Utilisateur(id, prenom, nom);

        return utilisateur;
    }

}
