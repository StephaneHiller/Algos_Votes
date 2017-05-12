package algo;

import structure.Matrix;

/**
 * Created by stephane on 12/05/17.
 */
public class Somme {

    public static Integer[] somme(Matrix mat){

        Integer resultats[] = new Integer[mat.getChoix()];
        for (int i = 0; i < mat.getChoix();i++) {
            resultats[i] = 0;
        }
        for (int i = 0; i < mat.getChoix(); i++) {
            for (int j = 0; j < mat.getVotants(); j++) {
                if (mat.getCase(i, j) == 1) {
                    resultats[i]++;
                }
            }
        }

        return resultats;
    }

    public static int vainqueur(Integer[] resultats){

        int res = 0;
        int tmp = resultats[0];
        for (int i = 1; i < resultats.length ;i++) {
            if (tmp < resultats[i]) {
                tmp = resultats[i];
                res = i;
            }
        }
        return res;
    }
}
