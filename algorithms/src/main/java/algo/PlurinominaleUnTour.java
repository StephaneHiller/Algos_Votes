package algo;

import structure.Matrix;

/**
 * Created by stephane on 12/05/17.
 */


public class PlurinominaleUnTour {

    /***
     * Méthode de scrutin plurinominal à un tour. À partir d'un tableau initialisé et vide :
     *     - génère un nombre nbChoixPossible de choix aléatoire pour chaque votant dans le tableau
     *     - calcul la somme de chaque choix
     *     - à partir des ces sommes, détermine le vainqueur
     *     - affiche le tableau de résultats ainsi que le vainqueur
     * @param mat : matrice contenant les informations
     * @param nbChoixPossible : le nombre de choix qui devront être générés dans le tableau
     */
   /* public static void votePlurinominaleUnTour(Matrix mat, int nbChoixPossible) {

        System.out.println("Nombre de choix : " + nbChoixPossible);
        mat.GenAutoChoixMultiple(nbChoixPossible);
        //mat.afficher();

        Integer resultats[] = Somme.sommeDeUn(mat);

        Integer vainqueur = Somme.vainqueur(resultats);

        System.out.print("Tableau de résultats : ");
        for(Integer i : resultats){
            System.out.print(i +" ");
        }
        System.out.println();
        System.out.println("Le vainqueur est le " + (vainqueur+1) + " avec : " + resultats[vainqueur]);
    }*/




}
