package Modele;

import Modele.Abstract.Album;

import java.time.LocalDate;

public class DisqueVinyle extends Album {

    private String numeroSerie;
    private String type;

    public DisqueVinyle(String nom, Auteur auteur, LocalDate annee, int quantite, String numeroSerie, String type) {
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
