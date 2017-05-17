package algo;

import structure.Matrix;

import java.util.ArrayList;

/**
 * Created by stephane on 12/05/17.
 */
public class UninominaleUnTour {



    public static long voteUninominaleUnTour(Matrix mat) {

        mat.GenAutoChoixUnique();
        //mat.afficher();

        long debut = System.currentTimeMillis();
        Integer[] resultats = Somme.sommeDeUn(mat);

        Integer vainqueur = Somme.vainqueur(resultats);

        long duree = System.currentTimeMillis() - debut;
       System.out.println("La durée est de : " + duree + " millisecondes");

        System.out.print("Tableau de résultats : ");
        for (int i = 0; i < resultats.length;i++) {
            System.out.print(resultats[i] + " ");
        }


        System.out.println();
        System.out.println("Le vainqueur est " + vainqueur);
        return duree;
    }


}
