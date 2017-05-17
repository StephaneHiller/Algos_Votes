package algo;

import structure.Matrix;

/**
 * Created by stephane on 15/05/17.
 */
public class Borda {

    /**
     * Méthode de calcul de Borda. À partir d'un tableau initialisé et vide :
     *     - génère une liste de préférences aléatoire pour chaque votant
     *     - calcul la somme de chaque choix
     *     - à partir des ces sommes, détermine le vainqueur
     *     - affiche le tableau de résultats ainsi que le vainqueur
     * @param mat
     * @return
     */
    public static void voteBorda(Matrix mat){
        mat.GenAutoListePreferences();
        //mat.afficher();

        long debut = System.currentTimeMillis();
        Integer resultats[] = Somme.somme(mat);

        Integer vainqueur = Somme.vainqueur(resultats);

        long duree = System.currentTimeMillis() - debut;
        System.out.println("La durée est de : " + duree + " millisecondes");

        System.out.print("Tableau de résultats : ");
        for (int i = 0; i < resultats.length;i++) {
            System.out.print(resultats[i] + " ");
        }
        System.out.println();
        System.out.println("Le vainqueur est le " + (vainqueur+1) + " avec : " + resultats[vainqueur]);
    }





}
