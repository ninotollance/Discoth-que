package Modele;

import Modele.Abstract.Album;

import java.time.LocalDate;

public class DisqueVinyle extends Album {

    private String numero;
    private int type;

    public DisqueVinyle(String nom, Auteur auteur, LocalDate annee, int quantite, String numero, int type) {
        super(nom, auteur, annee, quantite);
        this.numero = numero;
        this.type = type;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
