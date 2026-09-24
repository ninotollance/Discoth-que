import java.time.LocalDate;
import java.util.ArrayList;

public class GestionDisque {
    private static ArrayList<Disque> discotheque= new ArrayList<>();



    public static void creerDisque(String n, Auteur a, LocalDate d){
        //TODO instancier le disque
        //TODO ajouter le disque à la discotheque
    }
    public static void creerDisque(Disque d){
        //TODO ajouter le disque à la discotheque
        getDiscotheque().add(d);
    }
    public static void supprimerDisque(String n) throws DoublonException{
        //TODO
        //levée d'exception si supprime 2 disques
    }
    public static void supprimerDisque(String n, Auteur a){
        //TODO
    }

    public static ArrayList<Disque> getDiscotheque() {
        return discotheque;
    }

    public static void setDiscotheque(ArrayList<Disque> discotheque) {
        GestionDisque.discotheque = discotheque;
    }

    public void afficherDiscotheque(){
        System.out.println(getDiscotheque());
    }
}
