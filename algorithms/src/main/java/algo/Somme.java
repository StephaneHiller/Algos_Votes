package algo;

import structure.Matrix;


/**
 * Created by stephane on 12/05/17.
 */

/**
 * Classe permettant de faire des opérations de sommes sur un tableau à deux dimensions
 */
public class Somme {

    /**
     * Méthode permettant de compter le nombre de 1 pour chaque choix, donc pour chaque ligne
     * @param mat : matrice contenant la tableau
     * @return le tableau de résultats contenant la somme pour chaque choix
     */
    static Integer[] sommeDeUn(Matrix mat){

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

    /**
     * Méthode permettant de chercher, dans un tableau de résultats, le vainqueur, celui ayant la valeur la plus haute
     * @param resultats : tableau contenant les résultats d'un choix social
     * @return l'indice du vainqueur dans le tableau de résultat
     */
    static int vainqueur(Integer[] resultats){

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
