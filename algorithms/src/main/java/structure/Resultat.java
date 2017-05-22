package structure;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by stephane on 18/05/17.
 */
public class Resultat {

    private TreeMap<Integer, Integer> resultats;
    private HashMap<Integer, Integer> stats;

    public Resultat(TreeMap<Integer, Integer> resultats, HashMap<Integer, Integer> stats) {
        this.resultats = resultats;
        this.stats = stats;
    }

    public TreeMap<Integer, Integer> getResultats() {
        return resultats;
    }

    public void setResultats(TreeMap<Integer, Integer> resultats) {
        this.resultats = resultats;
    }

    public HashMap<Integer, Integer> getStats() {
        return stats;
    }

    public void setStats(HashMap<Integer, Integer> stats) {
        this.stats = stats;
    }
}
