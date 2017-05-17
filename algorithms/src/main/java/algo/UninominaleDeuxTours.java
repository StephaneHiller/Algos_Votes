package algo;

import structure.Matrix;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by stephane on 12/05/17.
 */
public class UninominaleDeuxTours {


    public static void voteUninominaleDeuxTour(Matrix mat) {

        System.out.println("Majorité à obtenir : " + mat.getVotants()/2);
        mat.GenAutoChoixUnique();
        //mat.afficher();

        Integer[] resultats = Somme.sommeDeUn(mat);

        Arrays.sort(resultats, Collections.reverseOrder());

        System.out.print("Tableau de résultats : ");
        for (int i = 0; i < resultats.length;i++) {
            System.out.print(resultats[i] + " ");
        }

        System.out.println();

        if (resultats[0] <= mat.getVotants()/2) {
            System.out.println("----- Deuxième tour -----");
            Matrix deuxiemeTour = new Matrix(mat.getVotants(), 2);
            deuxiemeTour.GenAutoChoixUnique();
            //deuxiemeTour.afficher();
            resultats = Somme.sommeDeUn(deuxiemeTour);

            System.out.print("Tableau de résultats : ");
            for (int i = 0; i < resultats.length; i++) {
                System.out.print(resultats[i] + " ");
            }
            Integer vainqueur = Somme.vainqueur(resultats);
            System.out.println();
            System.out.println("Le vainqueur est " + vainqueur);
        } else {
            System.out.println("Le vainqueur est " + 0);
        }

    }

}
