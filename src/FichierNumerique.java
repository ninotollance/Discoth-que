import java.time.LocalDate;

public class FichierNumerique extends Album{

    private String format;
    private String taille;
    private String duree;

    public FichierNumerique(String nom, Auteur auteur, LocalDate annee, int quantite, String format, String taille, String duree) {
        super(nom, auteur, annee, quantite);
        this.format = format;
        this.taille = taille;
        this.duree = duree;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }
}
