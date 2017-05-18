package algo;

import structure.Matrix;
import structure.Resultats;
import structure.ValueComparator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by stephane on 12/05/17.
 */
public class UninominaleUnTour {

    /***
     * TODO
     */
    public static Resultats voteUninominaleUnTour(Matrix mat) {

        Resultats res = PlurinominaleUnTour.votePlurinominaleUnTour(mat,1);

        return res;
    }


}
