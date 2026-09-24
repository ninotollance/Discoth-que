import Application.Controller;
import Exceptions.AuteurException;
import Exceptions.DisqueException;
import Exceptions.DoublonException;

public class Main {
    public static void main(String[] args) {


        Controller c = new Controller();
        int choix = 0;

        do {
            try {
                c.afficherMenu();
                System.out.print("Choix:");
                choix = Controller.scan.nextInt();

                switch (choix) {
                    case 1:
                        c.ajouterDisque();
                        break;
                    case 2:
                        c.supprimerDisqueParNom();
                        break;
                    case 3:
                        c.supprimerDisqueParAuteurEtNom();
                        break;
                    case 4:
                        c.afficherDiscotheque();
                        break;
                    case 5:
                        c.viderDiscotheque();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, veuillez réessayer.");
                }

                System.out.println();
            } catch (AuteurException e) {
                System.err.println(e.getMessage());
            } catch (DisqueException e) {
                System.err.println(e.getMessage());
            } catch (DoublonException e) {
                System.err.println(e.getMessage());
            }

        } while (choix != 0);

        Controller.scan.close();

    }
}
