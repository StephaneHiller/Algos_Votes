package algo;

import structure.Matrix;
import structure.Resultats;

import java.util.ArrayList;
import java.util.HashMap;

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
    public static Resultats voteUninominaleUnTour(Matrix mat) {

        HashMap<Integer,Integer> stats = new HashMap<Integer, Integer>();
        mat.GenAutoChoixUnique();

        System.out.println(mat.toString());

        long debut = System.currentTimeMillis();
        HashMap<Integer, Integer> resultats = Somme.sommeDeUn(mat);

        Integer vainqueur = Somme.vainqueur(resultats);

        long duree = System.currentTimeMillis() - debut;
        System.out.println("La durée est de : " + duree + " millisecondes");

        System.out.print("Tableau de résultats : ");
        System.out.println(resultats);

        Resultats res = new Resultats(resultats,stats);

        System.out.println();
        System.out.println("Le vainqueur est le " + vainqueur + " avec : " + resultats.get(vainqueur));

        return res;
    }


}
