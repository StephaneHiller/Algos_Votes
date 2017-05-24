package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by stephane on 18/05/17.
 */
public class Resultat {

    /**
     * Map contenant la liste des vainqueur ordonnée comme suit :
     *     en premier élément se trouve le numéro  du choix gagnant
     *     en deuxième élément se trouve le numéro du choix arrivant à la seconde place
     *     ...
     */
    private TreeMap<Integer, Integer> resultats;
    /**
     * Map contenant la liste des statistiques pour chaque choix. La clé correspond au numéro du choix et
     * la valeur correspondant au nombre de point correspondant à ce choix.
     */
    private HashMap<Integer, Integer> stats;
    /**
     * Map contenant les statistiques correspondant à un scrutin de type jugement majoritaire. La clé correspond au
     * numéro du choix et l'Arraylist correspond aux pourcentages pour chaque mention obtenu par ce choix.
     */
    private HashMap<Integer, ArrayList<Double>> statsJugementMajoritaire;


    /**
     * Constructeur à partir d'une map contenant la liste des gagnants et une autre map contenant les statistiques des
     * choix.
     * @param resultats : map contenant les gagnants
     * @param stats : map contenant les statistiques
     */
    public Resultat(TreeMap<Integer, Integer> resultats, HashMap<Integer, Integer> stats) {
        this.resultats = resultats;
        this.stats = stats;
    }

    /**
     * Permet de rajouter les stats correspondant à un vote de type jugement majoritaire à un objet Resultat
     * @param statsJugementMajoritaire : map contenant les statistiques
     */
    public void setStatsJugementMajoritaire(HashMap<Integer, ArrayList<Double>> statsJugementMajoritaire) {
        this.statsJugementMajoritaire = statsJugementMajoritaire;
    }

    /**
     * Getter pour la map statsJugementMajoritaire
     * @return : la map statsJugementMajoritaire
     */
    public HashMap<Integer, ArrayList<Double>> getStatsJugementMajoritaire() {
        if (statsJugementMajoritaire != null){
            return statsJugementMajoritaire;
        } else return null;
    }

    /**
     * Getter pour la map resultats
     * @return : la map resultats
     */
    public TreeMap<Integer, Integer> getResultats() {
        if (resultats!= null){
            return resultats;
        }
        else return null;
    }

    /**
     * Setter pour la map resultats
     * @param resultats : la map à ajouter
     */
    public void setResultats(TreeMap<Integer, Integer> resultats) {
        this.resultats = resultats;
    }

    /**
     * Getter pour la map stats
     * @return : la map stats
     */
    public HashMap<Integer, Integer> getStats() {
        if (stats != null){
            return stats;
        }
        else return null;
    }

    /**
     * Setter pour la map stats
     * @param stats : la map à ajouter
     */
    public void setStats(HashMap<Integer, Integer> stats) {
        this.stats = stats;
    }

    /**
     * Méthode permettant d'afficher les informations d'un objet Resultat sur la sortie écran
     * @return le string contenant l'affichage
     */
    @Override
    public String toString() {
        return "Resultat{" +
                "resultats=" + resultats +
                ", stats=" + stats +
                ", statsJugementMajoritaire=" + statsJugementMajoritaire +
                '}';
    }
}
