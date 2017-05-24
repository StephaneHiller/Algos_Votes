package structure;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by stephane on 23/05/17.
 */

/**
 * Permet de classer une Map dans l'odre croissant
 */
public class AscendingComparator implements Comparator<Integer> {
    Map<Integer, Integer> base;
    public AscendingComparator(Map<Integer, Integer> base) {
        this.base = base;
    }

    public int compare(Integer a, Integer b) {
        if (base.get(a) <= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}
