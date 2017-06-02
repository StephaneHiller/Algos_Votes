package algo;

import structure.Matrix;
import structure.Resultat;
import structure.StructureSTV;

import java.util.TreeMap;

/**
 * Created by stephane on 29/05/17.
 */
/**
 * Méthode permettant de réaliser un scrutin de type STV à partir d'une matrice, de la méthode de choix
 * du quota et de la méthode de choix du perdant.
 */
public class STV {

    public static Resultat voteSTV(Matrix mat, int choixQuota, int choixPerdant, int nbGagnant){

        /**
         * Déclaration de la structure StructureSTV
         */
        StructureSTV struct = new StructureSTV(mat,choixQuota,choixPerdant, nbGagnant);

        /**
         * Tant que l'on a pas le nombre de gagnant souhaité, on effectue une nouvelle ronde.
         */
        while (struct.getTabVainqueurs().size() < nbGagnant) {
            /**
             * Calcul des scores pour les différents choix.
             */
            struct.calculScore(struct);
            System.out.println("TabScore : " + struct.getTabScores().toString());

            /**
             * Calcul du surplus
             */
            struct.ronde(struct);
            System.out.println("TabCombinaison : " + struct.getTabCombinaisons().toString());

        }

        /**
         * Déclare une treemap et la rempli avec le tableau tabVainqueur pour rendre le résultat sous la forme souhaité
         */
        TreeMap<Integer,Integer> resultats = new TreeMap<Integer, Integer>();
        for (int i =1; i<=struct.getTabVainqueurs().size();i++){
            resultats.put(i,struct.getTabVainqueurs().get(i-1).intValue()-1);
        }
        Resultat res = new Resultat(resultats,null);
        System.out.println(res);

        System.out.println("\nFINI\n");
        return res;
    }
}
