package structure;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by stephane on 18/05/17.
 */

/**
 * Permet de classer une Map dans l'odre décroissant
 */
public class DescendingComparator implements Comparator<Integer> {
    Map<Integer, Integer> base;
    public DescendingComparator(Map<Integer, Integer> base) {
        this.base = base;
    }

    public int compare(Integer a, Integer b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        }
    }
}