package Application;

import Exceptions.AuteurException;
import Exceptions.DateFormatException;
import Exceptions.DoublonException;
import Modele.Abstract.Album;
import Modele.Auteur;
import Modele.CompactDisque;
import Modele.Discotheque;
import Modele.Disque;

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
        System.out.print("saisissez le nom du disque:");
        String nom = scan.nextLine();
        if (nom.isEmpty()) {
            throw new DisqueException("nom  du disque  non saisi");
        }
        return nom;
    }

    public String saisieNumero(){
        //TODO saisie du numéro du disque
        //TODO exception
    }

    public String saisieType(){
        //TODO saisie du type du disque
        //TODO exception
    }

    public int saisieTailleVinyle(){
        //TODO saisie de la taille du disque
        //TODO exception
    }

    public String saisieFormat(){
        //TODO saisie du type du disque
        //TODO exception
    }

    public double saisieTailleFichier(){
        //TODO saisie de la taille du fichier
        //TODO exception
    }

    public int saisieDuree(){
        //TODO saisie de la durée du fichier
        //TODO exception
    }

    public int saisieQuantite(){
        //TODO saisie de la quantite
        //TODO exception
    }

    public LocalDate saisieDate() throws DateFormatException {
        System.out.println("Saisissez la date de publication au format dd/mm/yyyy");
        String date = scan.nextLine();
        if(!date.matches("^\d{2}/\d{2}/\d{4}$")){
            throw new DateFormatException("La date n'est pas au format dd/mm/yyyy");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(date, formatter);
    }

    public CompactDisque creerCD () throws AuteurException, DoublonException {
        Auteur a = saisieAuteur();
        String nom = saisieNomDisque();
        LocalDate date = saisieDate();
        int quantite = saisieQuantite();
        String numero = saisieNumero();
        String type = saisieType();

        try {
            CompactDisque cd = new CompactDisque(nom, a, date, quantite, numero, type );
            Discotheque.ajouterAlbum(cd);
        } catch (DoublonException e) {
            System.out.println("Album déjà existant ");
        }
    }

    public void ajouterAlbum(){
        //TODO saisie des informations de l'album avec les fonctions de saisie
        //TODO demande de la CLASSE d'Album pour appeller les bonnes fonctions de saisie
        //TODO Création de l'entité en conséquence
        System.out.println("Type d'album (1 = CD, 2 = Vinyle, 3 = Fichier numérique) : ");
        int choix = scan.nextInt();
        scan.nextLine();

        switch (choix) {
            case 1:
                //création CD
                break;
            case 2:
                //création vinyle
                break;
            case 3:
                //création fichier numérique
                break;
            default:
                //message erreur
        }








        Album created;
        Discotheque.ajouterAlbum(created);
    }

    //TODO ajout disque
    public void ajouterDisque() throws AuteurException, DisqueException {
        Auteur a = saisieAuteur();
        LocalDate dateDisque = LocalDate.now();
        String nomD = saisieNomDisque();
        LocalDate dateD = saisieDate();
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dateDisque = LocalDate.parse(dateD, formatter);
            Disque d = new Disque(nomD, a, dateDisque);
            GestionDisque.creerDisque(d);
        } catch (DateTimeParseException e) {
            System.err.println("Format invalide. exemple : 22/09/2026");
        }
    }

    //TODO suppression disque
    public void supprimerDisqueParAuteurEtNom() throws AuteurException, DisqueException {
    Auteur a =saisieAuteur();
    String n= saisieNomDisque();
    GestionDisque.supprimerDisque(n,a);
    }
    public void supprimerDisqueParNom() throws AuteurException, DisqueException, DoublonException {
        scan.nextLine();
        String n= saisieNomDisque();
        GestionDisque.supprimerDisqueParNom(n);
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
