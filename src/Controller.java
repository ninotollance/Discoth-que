import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Controller {

    static Scanner scan = new Scanner(System.in);

    //TODO affichage du menu
    // Affiche le menu principal
    public void afficherMenu() {
        System.out.println("===== GESTION DE LA DISCOTHEQUE =====");
        System.out.println("1. Ajouter un disque");
        System.out.println("2. Supprimer un disque");
        System.out.println("3. Afficher le contenu de la discotheque");
        System.out.println("4. Vider la discotheque");
        System.out.println("0. Quitter");
    }

    //TODO ajout disque
    public void ajouterDisque() throws AuteurException, DisqueException {
        Auteur a;
        scan.nextLine();
        LocalDate date = LocalDate.now();
        System.out.print("saisissez le nom de l'auteur:");
        String nom = scan.nextLine();
        System.out.print("saisissez le prénom de l'auteur:");
        String prenom = scan.nextLine();

        if (nom.isEmpty() || prenom.isEmpty()) {
            throw new AuteurException("Nom ou prénom non saisi");
        } else {
            a = new Auteur(nom, prenom);
        }

        System.out.print("saisissez le nom du disque:");
        String nomd = scan.nextLine();
        System.out.print("saisissez la date du disque (jj/mm/aaaa):");
        String dateD = scan.nextLine();
        if (nomd.isEmpty() || dateD.isEmpty()) {
            throw new DisqueException("nom ou date du disque  non saisi");
        }
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date = LocalDate.parse(dateD, formatter);
            Disque d = new Disque(nomd, a, date);
            GestionDisque.creerDisque(d);


        } catch (DateTimeParseException e) {
            System.out.println("Format invalide. exemple : 22/09/2026");
        }

    }

    //TODO suppression disque
    public void supprimerDisque() {

    }

    //TODO affichage de la discotheque
    public void afficherDiscotheque() {
        System.out.println(GestionDisque.getDiscotheque());
    }

    //TODO vider la discotheque
    public void viderDiscotheque() {

    }

}
