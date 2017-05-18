package structure;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by stephane on 18/05/17.
 */
public class Resultats {

    TreeMap<Integer, Integer> resultats;
    HashMap<Integer, Integer> stats;

    public Resultats(TreeMap<Integer, Integer> resultats, HashMap<Integer, Integer> stats) {
        this.resultats = resultats;
        this.stats = stats;
    }
}
