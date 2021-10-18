package injection.bdd.dampierre;

public class Utilisateur {

    private long id;
    private String prenom;
    private String nom;

    public Utilisateur(long id, String prenom, String nom) {

        this.setId(id);
        this.setPrenom(prenom);
        this.setNom(nom);
    }

    public long getId() {
        return id;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
