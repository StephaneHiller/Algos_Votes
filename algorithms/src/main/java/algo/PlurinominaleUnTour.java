package algo;

import structure.Matrix;

/**
 * Created by stephane on 12/05/17.
 */
public class PlurinominaleUnTour {

    public static void votePlurinominaleUnTour(Matrix mat, int nbChoixPossible) {

        System.out.println("Nombre de choix : " + nbChoixPossible);
        mat.GenAutoChoixMultiple(nbChoixPossible);
        //mat.afficher();

        Integer resultats[] = Somme.sommeDeUn(mat);

        Integer vainqueur = Somme.vainqueur(resultats);

        System.out.print("Tableau de résultats : ");
        for (int i = 0; i < resultats.length;i++) {
            System.out.print(resultats[i] + " ");
        }
        System.out.println();
        System.out.println("Le vainqueur est " + vainqueur);
    }




}
