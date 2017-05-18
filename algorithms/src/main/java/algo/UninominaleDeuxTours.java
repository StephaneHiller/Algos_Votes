package algo;

import exception.MatrixFormatException;
import structure.Matrix;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by stephane on 12/05/17.
 */
public class UninominaleDeuxTours {


    /***
     * Méthode de scrutin uninominal à deux tour. À partir d'un tableau initialisé et vide :
     *     - génère un nombre nbChoixPossible de choix aléatoire dans le tableau
     *     - calcul la somme de chaque choix
     *     - à partir des ces sommes, affiche les résultats et regarde si un choix dépasse le quota requis
     *     - si oui, ce choix est le vainqueur
     *     - si non, organise un deuxième tour avec les deux choix ayant récu le plus de voix
     *     - calcul les nouvelles sommes
     *     - à partir des ces nouvelles sommes, détermine le vainqueur
     *     - affiche le tableau de résultats ainsi que le vainqueur
     * @param mat : matrice contenant les informations
     */
    public static int voteUninominaleDeuxTour(Matrix mat) {
/*
        System.out.println("Majorité à obtenir : " + mat.getVotants()/2);
        mat.GenAutoChoixUnique();
        //mat.afficher();

        Integer[] resultats = Somme.sommeDeUn(mat);

        Arrays.sort(resultats, Collections.reverseOrder());

        System.out.print("Tableau de résultats : ");
        for(Integer i : resultats){
            System.out.print(i +" ");
        }

        System.out.println();

        if (resultats[0] <= mat.getVotants()/2) {
            System.out.println("----- Deuxième tour -----");
            Matrix deuxiemeTour = null;
            try {
                deuxiemeTour = new Matrix(mat.getVotants(), 2);
            } catch (MatrixFormatException e) {
                e.printStackTrace();
            }
            deuxiemeTour.GenAutoChoixUnique();
            //deuxiemeTour.afficher();
            resultats = Somme.sommeDeUn(deuxiemeTour);

            System.out.print("Tableau de résultats : ");
            for(Integer i : resultats){
                System.out.print(i +" ");
            }
            Integer vainqueur = Somme.vainqueur(resultats);
            System.out.println();
            System.out.println("Le vainqueur est le " + (vainqueur+1) + " avec : " + resultats[vainqueur]);
            return vainqueur+1;
        } else {
            System.out.println("Le vainqueur est le 1 avec : " + resultats[0]);
            return 1;
        }*/
    return 0;


    }

}
