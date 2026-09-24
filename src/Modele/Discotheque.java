package Modele;

import Exceptions.DoublonException;
import Modele.Abstract.Album;

import java.util.ArrayList;

public class Discotheque {
    private static ArrayList<Album> discotheque = new ArrayList<>();


    /**public static void creerAlbum(Album a) {
        // ajouter le disque à la discotheque
        getDiscotheque().add(a);
        System.out.println("Album ajouté la discotheque");
    }

    public static void supprimerAlbumParNom(String n) throws DoublonException {
        int compteur =0;
        Album trouve=null;
        for (Album a : getDiscotheque()) {
            if (a.getNom().equals(n)) {
                trouve = a;
                compteur++;
            }
        }
        //levée d'exception si supprime 2 disques
        if(compteur>1){
            throw new DoublonException("Doublons détectés! Utiliser l'autre suppression : choix 3");
        }
        else if(compteur==1) {
            getDiscotheque().remove(trouve);
            System.out.println("disque supprimé de la discotheque");
        }else {
            System.err.println("Impossible de supprimer.disque non trouvé!");
        }
    }

    public static void supprimeAlbum(String n, Auteur auteur) {
        Album trouve = null;
        for (Album a : getDiscotheque()) {
            if (a.getNom().equals(n) &&
                    a.getAuteur().getNom().equals(auteur.getNom()) &&
                    a.getAuteur().getPrenom().equals(auteur.getPrenom())) {
                trouve = a;
                break;
            }
        }
        if (trouve != null) {
            System.out.println("disque trouvé:" + trouve);
            discotheque.remove(trouve);
            System.out.println("disque supprimé de la discotheque");
        } else {
            System.err.println("Impossible de supprimer.disque non trouvé!");
        }

    }*/

    public static ArrayList<Album> getDiscotheque() {
        return discotheque;
    }

    public static void setDiscotheque(ArrayList<Album> discotheque) {
        Discotheque.discotheque = discotheque;
    }

    public static void afficherDiscotheque() {
        System.out.println(getDiscotheque());
    }
    public static void viderDiscotheque() {
       getDiscotheque().clear();
        System.out.println("discotheque vidée!");
    }
    protected void ajouterAlbum(Album a) {
        getDiscotheque().add(a);
        System.out.println("Album ajouté avec succès !");
    }
    protected void listerAlbum() {
        if (getDiscotheque().isEmpty()) {
            System.out.println("Discothèque vide !");
        }
        for (Album a : getDiscotheque()) {
            System.out.println(a);
        }
    }
    rechercherAlbum() {

    }
    supprimerAlbum() {

    }
}
