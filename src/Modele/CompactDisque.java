package Modele;

import Modele.Abstract.Album;

public class CompactDisque extends Album {

    private String numeroSerie;
    private String type;

    public CompactDisque(String nom, Auteur auteur, java.time.LocalDate annee, int quantite, String numeroSerie, String type) {
        super(nom, auteur, annee, quantite);
        this.numeroSerie = numeroSerie;
        this.type = type;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
