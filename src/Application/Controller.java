package Application;

import Exceptions.AuteurException;
import Exceptions.DateFormatException;
import Exceptions.DisqueException;
import Exceptions.DoublonException;
import Modele.*;
import Modele.Abstract.Album;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Controller {

    public static Scanner scan = new Scanner(System.in);

    //TODO affichage du menu
    // Affiche le menu principal
    public void afficherMenu() {
        System.out.println("===== GESTION DE LA DISCOTHEQUE =====");
        System.out.println("1. Ajouter un disque");
        System.out.println("2. Supprimer un disque  par titre de l'album");
        System.out.println("3. Supprimer un disque par Auteur et par titre de l'album");
        System.out.println("4. Afficher le contenu de la discotheque");
        System.out.println("5. Vider la discotheque");
        System.out.println("0. Quitter");
    }

    public Auteur saisieAuteur() throws AuteurException {
        Auteur a;
        scan.nextLine();

        System.out.print("saisissez le nom de l'auteur:");
        String nom = scan.nextLine();
        System.out.print("saisissez le prénom de l'auteur:");
        String prenom = scan.nextLine();

        if (nom.isEmpty() && prenom.isEmpty()) {
            throw new AuteurException("Il faut remplir le champ nom ou le champ prénom");
        } else {
            a = new Auteur(nom, prenom);
        }
        return a;
    }

    public String saisieNomDisque() throws DisqueException {
        System.out.print("saisissez le nom de l'album:");
        String nom = scan.nextLine();
        if (nom.isEmpty()) {
            throw new DisqueException("nom  de l'album  non saisi");
        }
        return nom;
    }

    public String saisieNumero() throws DisqueException {
        System.out.print("saisissez le numéro de série de l'album:");
        String numero = scan.nextLine();
        if (numero.isEmpty()) {
            throw new DisqueException("numéro de série de l'album  non saisi");
        }
        return numero;
    }

    public String saisieType() throws DisqueException {
        System.out.print("saisissez le type de l'album:");
        String type = scan.nextLine();
        if (type.isEmpty()) {
            throw new DisqueException("type de l'album  non saisi");
        }
        return type;
    }

    public int saisieTailleVinyle() throws DisqueException {
        System.out.print("saisissez le nom de l'album:");
        int taille = scan.nextInt();
        scan.nextLine();
        if (taille != 33 && taille != 45) {
            throw new DisqueException("Taille du vinyle non valide, doit être 33 ou 45");
        }
        return taille;
    }

    public String saisieFormat() throws DisqueException {
        System.out.print("saisissez le format de l'album:");
        String format = scan.nextLine();
        if (format.isEmpty()) {
            throw new DisqueException("format de l'album  non saisi");
        }
        return format;
    }

    public double saisieTailleFichier() throws DisqueException {
        System.out.print("saisissez la taille du fichier (en MO):");
        double taille = scan.nextDouble();
        scan.nextLine();
        if (taille <= 0) {
            throw new DisqueException("taille de l'album  non saisi");
        }
        return taille;
    }

    public int saisieDuree() throws DisqueException {
        System.out.print("saisissez la durée de l'album (en min):");
        int duree = scan.nextInt();
        scan.nextLine();
        if (duree < 0) {
            throw new DisqueException("durée l'album  non saisi");
        }
        return duree;
    }

    public int saisieQuantite() throws DisqueException {
        System.out.print("saisissez le nombre de disques/fichiers de l'album:");
        int duree = scan.nextInt();
        scan.nextLine();
        if (duree <= 0) {
            throw new DisqueException("L'album ne peut pas avoir une quantité nulle ou négative");
        }
        return duree;
    }

    public LocalDate saisieDate() throws DateFormatException {
        System.out.println("Saisissez la date de publication au format dd/mm/yyyy");
        String date = scan.nextLine();
        if(!date.matches("^\\d{2}/\\d{2}/\\d{4}$")){
            throw new DateFormatException("La date n'est pas au format dd/mm/yyyy");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(date, formatter);
    }

    public CompactDisque creerCD () throws AuteurException, DoublonException, DisqueException {
        Auteur a = saisieAuteur();
        String nom = saisieNomDisque();
        LocalDate date = saisieDate();
        int quantite = saisieQuantite();
        String numero = saisieNumero();
        String type = saisieType();


        CompactDisque cd = new CompactDisque(nom, a, date, quantite, numero, type );
        return cd;
    }

    public FichierNumerique creerFichierNumerique () throws AuteurException, DoublonException, DisqueException {
        Auteur a = saisieAuteur();
        String nom = saisieNomDisque();
        LocalDate date = saisieDate();
        int quantite = saisieQuantite();
        String format = saisieFormat();
        double taille = saisieTailleFichier();
        int duree = saisieDuree();


        FichierNumerique fichierNumerique = new FichierNumerique(nom, a, date, quantite, format, taille, duree );
        return fichierNumerique;
    }

    public DisqueVinyle creerDisqueVinyle () throws AuteurException, DoublonException, DisqueException {
        Auteur a = saisieAuteur();
        String nom = saisieNomDisque();
        LocalDate date = saisieDate();
        int quantite = saisieQuantite();
        int taille = saisieTailleVinyle();
        String numero = saisieNumero();


        DisqueVinyle disqueVinyle = new DisqueVinyle(nom, a, date, quantite, numero, taille);
        return disqueVinyle;
    }

    public void ajouterAlbum() throws AuteurException, DisqueException, DoublonException {
        //TODO saisie des informations de l'album avec les fonctions de saisie
        //TODO demande de la CLASSE d'Album pour appeller les bonnes fonctions de saisie
        //TODO Création de l'entité en conséquence
        System.out.println("Type d'album (1 = CD, 2 = Vinyle, 3 = Fichier numérique) : ");
        int choix = scan.nextInt();
        scan.nextLine();

        Album created = null;
        switch (choix) {
            case 1:
                created = creerCD();
                break;
            case 2:
                created = creerDisqueVinyle();
                break;
            case 3:
                created = creerFichierNumerique();
                break;
            default:
                //message erreur
        }

        Discotheque.ajouterAlbum(created);
    }

    //TODO affichage de la discotheque
    public void afficherDiscotheque() {
      GestionDisque.afficherDiscotheque();
    }

    //TODO vider la discotheque
    public void viderDiscotheque() {
        GestionDisque.viderDiscotheque();
    }

}
