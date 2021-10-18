package injection.bdd.dampierre;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

// Test afin de savoir si les différentes requêtes passe malgré les changements.

class AppTest {

    @Test
    void unNomUnique_trouverParNom_devraitRetournerLeLclient() {

        UtilisateurDAO utilisateur = new UtilisateurDAO();

        List<Utilisateur> listeObtenue = utilisateur.trouverParNom("Jalel");

        assertEquals(1, listeObtenue.size(), "Doit contenir un utilisateur contenant le prénom Jalel");

    }

    @Test
    void doublonDeNom_trouverParNom_devraitRetournerLesDeuxClients() {

        UtilisateurDAO utilisateur = new UtilisateurDAO();

        List<Utilisateur> listeObtenue = utilisateur.trouverParNom("Kyllian");

        assertEquals(2, listeObtenue.size(), "Doit contenir deux utilisateurs contenant le prénom Kyllian");
    }

    @Test
    void aucunNom_trouverParNom_devraitRetournerZeroClient() {

        UtilisateurDAO utilisateur = new UtilisateurDAO();

        List<Utilisateur> listeObtenue = utilisateur.trouverParNom("toto");

        assertEquals(0, listeObtenue.size(), "Doit contenir aucun utilisateurs contenant le prénom toto");
    }

}
