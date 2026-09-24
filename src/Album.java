import java.time.LocalDate;

public class Album {

    private String nom;
    private Auteur auteur;
    private LocalDate annee;
    private int quantite;

    public Album(String nom, Auteur auteur, LocalDate annee, int quantite) {
        this.nom = nom;
        this.auteur = auteur;
        this.annee = annee;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public LocalDate getAnnee() {
        return annee;
    }

    public void setAnnee(LocalDate annee) {
        this.annee = annee;
    }
}
