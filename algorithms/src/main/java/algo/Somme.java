package algo;

import structure.Matrix;
import sun.reflect.generics.tree.Tree;

import java.util.*;


/**
 * Created by stephane on 12/05/17.
 */

/**
 * Classe permettant de faire des opérations de sommes sur un tableau à deux dimensions
 */
public class Somme {


    /**
     * Méthode permattant de déterminer le vainqueur à partir d'une map avec les résultats.
     * @param resultats : map contenant les resultats
     * @return : le numéro du choix vainqueur
     */
    static int vainqueur(HashMap<Integer,Integer> resultats){
        int vainqueur = 0;
        int tmp =0;

        for (Map.Entry<Integer,Integer> i : resultats.entrySet()) {

            if (i.getValue() >= tmp) {
                tmp = i.getValue();
                vainqueur = i.getKey();
            }
        }
        return vainqueur;
    }

    /**
     * Méthode permettant de faire la somme pour chaque choix, donc pour chaque ligne
     * @param mat : matrice contenant la tableau
     * @return : le tableau de résultats contenant la somme pour chaque choix
     */
    static HashMap<Integer,Integer> somme(Matrix mat){

        ArrayList<Integer> tmp = new ArrayList<Integer>();
        HashMap<Integer,Integer> resultats = new HashMap<Integer, Integer>();

        for (int i = 0; i < mat.getChoix();i++) {
            tmp.add(0);
        }

        int cpt;
        for (int i = 0; i < mat.getChoix(); i++) {
            for (int j = 0; j < mat.getVotants(); j++) {
                cpt = tmp.get(i);
                cpt += mat.getCase(i,j);
                tmp.set(i,cpt);

            }
        }

        for (int i = 1; i <= tmp.size(); i++) {
            resultats.put(i,tmp.get(i - 1));
        }

        return resultats;

    }


}
