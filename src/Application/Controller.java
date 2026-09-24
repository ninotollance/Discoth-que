package Application;

import Exceptions.AuteurException;
import Exceptions.DisqueException;
import Exceptions.DoublonException;
import Modele.Auteur;
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

    public String saisieDate() throws DisqueException {
        System.out.print("saisissez la date du disque (jj/mm/aaaa):");
        String dateD = scan.nextLine();
        if (dateD.isEmpty()) {
            throw new DisqueException("date du disque  non saisie");
        }
        return dateD;
    }

    //TODO ajout disque
    public void ajouterDisque() throws AuteurException, DisqueException {
        Auteur a = saisieAuteur();
        LocalDate dateDisque = LocalDate.now();
        String nomD = saisieNomDisque();
        String dateD = saisieDate();
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
