package structure;

import java.util.HashMap;

/**
 * Created by stephane on 18/05/17.
 */
public class Resultats {

    HashMap<Integer, Integer> resultats;
    HashMap<Integer, Integer> stats;

    public Resultats(HashMap<Integer, Integer> resultats, HashMap<Integer, Integer> stats) {
        this.resultats = resultats;
        this.stats = stats;
    }
}
