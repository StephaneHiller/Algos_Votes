package algo;

import structure.Matrix;

import java.util.*;


/**
 * Created by stephane on 12/05/17.
 */

/**
 * Classe permettant de faire des opérations de sommes sur un tableau à deux dimensions
 */
public class Somme {

    /**
     * TODO
     */
    static HashMap<Integer, Integer> sommeDeUn(Matrix mat){

        ArrayList<Integer> tmp = new ArrayList<Integer>();
        HashMap<Integer,Integer> resultats = new HashMap<Integer, Integer>();
        for (int i = 0; i < mat.getChoix();i++) {
            tmp.add(0);
        }

        int cpt;
        for (int i = 0; i < mat.getChoix(); i++) {
            for (int j = 0; j < mat.getVotants(); j++) {
                if (mat.getCase(i, j) == 1) {
                    cpt = tmp.get(i);
                    cpt++;
                    tmp.set(i,cpt);
                }
            }
        }

        for (int i = 0; i < tmp.size(); i++) {
            resultats.put(i,tmp.get(i));
        }

        return resultats;
    }

    /**
     * TODO
     */
    static int vainqueur(HashMap<Integer,Integer> resultats){
        int vainqueur = 0;
        int tmp =0;

        for (Map.Entry<Integer,Integer> i : resultats.entrySet()) {

            if (i.getValue() > tmp) {
                tmp = i.getValue();
                vainqueur = i.getKey();
            }
        }
        return vainqueur;
    }

    /**
     * Méthode permettant de faire la somme pour chaque choix, donc pour chaque ligne
     * @param mat : matrice contenant la tableau
     * @return le tableau de résultats contenant la somme pour chaque choix
     */
    static Integer[] somme(Matrix mat){

        Integer resultats[] = new Integer[mat.getChoix()];
        for (int i = 0; i < mat.getChoix();i++) {
            resultats[i] = 0;
        }
        for (int i = 0; i < mat.getChoix(); i++) {
            for (int j = 0; j < mat.getVotants(); j++) {
                resultats[i]+= mat.getCase(i,j);
            }
        }

        return resultats;
    }


}
