import Application.Controller;
import Exceptions.*;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Controller c = new Controller();
        int choix = -1;

        do {
            try {
                c.afficherMenu();
                System.out.print("Choix:");
                choix = Controller.scan.nextInt();

                switch (choix) {
                    case 1:
                        c.ajouterAlbum();
                        break;
                    case 2:
                        c.listerAlbums();
                        break;
                    case 3:
                        c.rechercherAlbum();
                        break;
                    case 4:
                        c.supprimerAlbumParNom();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }

                System.out.println();
            } catch (DiscothequeVideException | AuteurException | AlbumException | DoublonException |
                     InputMismatchException | AlbumIntrouvableException e) {
                System.out.println("Erreur: " + e.getClass().getSimpleName());
            }

        } while (choix != 0);

        Controller.scan.close();

    }
}
