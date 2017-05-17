package algo;

import structure.Matrix;

/**
 * Created by stephane on 12/05/17.
 */
public class UninominaleUnTour {

    /***
     * Méthode de scrutin uninominal à un tour. À partir d'un tableau initialisé et vide :
     *     - génère un choix aléatoire pour chaque votant dans le tableau
     *     - calcul la somme de chaque choix
     *     - à partir des ces sommes, détermine le vainqueur
     *     - affiche le tableau de résultats ainsi que le vainqueur
     * @param mat : matrice contenant les informations
     */
    public static Integer[] voteUninominaleUnTour(Matrix mat) {

        //mat.GenAutoChoixUnique();

        long debut = System.currentTimeMillis();
        Integer[] resultats = Somme.sommeDeUn(mat);

        Integer vainqueur = Somme.vainqueur(resultats);

        long duree = System.currentTimeMillis() - debut;
       System.out.println("La durée est de : " + duree + " millisecondes");

        System.out.print("Tableau de résultats : ");
        for(Integer i : resultats){
            System.out.print(i +" ");
        }


        System.out.println();
        System.out.println("Le vainqueur est le " + (vainqueur+1) + " avec : " + resultats[vainqueur]);

        return resultats;
    }


}
