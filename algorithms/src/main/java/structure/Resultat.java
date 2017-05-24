package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by stephane on 18/05/17.
 */
public class Resultat {

    private TreeMap<Integer, Integer> resultats;
    private HashMap<Integer, Integer> stats;
    private HashMap<Integer, ArrayList<Double>> statsJugementMajoritaire;


    public Resultat(TreeMap<Integer, Integer> resultats, HashMap<Integer, Integer> stats) {
        this.resultats = resultats;
        this.stats = stats;
    }

    public void setStatsJugementMajoritaire(HashMap<Integer, ArrayList<Double>> statsJugementMajoritaire) {
        this.statsJugementMajoritaire = statsJugementMajoritaire;
    }

    public HashMap<Integer, ArrayList<Double>> getStatsJugementMajoritaire() {
        if (statsJugementMajoritaire != null){
            return statsJugementMajoritaire;
        } else return null;
    }

    public TreeMap<Integer, Integer> getResultats() {
        if (resultats!= null){
            return resultats;
        }
        else return null;
    }

    public void setResultats(TreeMap<Integer, Integer> resultats) {
        this.resultats = resultats;
    }

    public HashMap<Integer, Integer> getStats() {
        if (stats != null){
            return stats;
        }
        else return null;
    }

    public void setStats(HashMap<Integer, Integer> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Resultat{" +
                "resultats=" + resultats +
                ", stats=" + stats +
                ", statsJugementMajoritaire=" + statsJugementMajoritaire +
                '}';
    }
}
