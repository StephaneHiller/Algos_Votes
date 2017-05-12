package algo;

import structure.Matrix;

/**
 * Created by stephane on 12/05/17.
 */
public class UninominaleUnTour {



    public static void voteUninominaleUnTour(Matrix mat) {

        mat.GenAutoChoixUnique();
        mat.afficher();

        Integer[] resultats = Somme.somme(mat);

        System.out.print("Tableau de résultats : ");
        for (int i = 0; i < resultats.length;i++) {
            System.out.print(resultats[i] + " ");
        }

        Integer vainqueur = Somme.vainqueur(resultats);
        System.out.println();
        System.out.println("Le vainqueur est " + vainqueur);
    }

}
