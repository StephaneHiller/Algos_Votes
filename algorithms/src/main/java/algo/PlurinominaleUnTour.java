package algo;

import structure.Matrix;
import structure.Resultats;
import structure.ValueComparator;

import java.util.HashMap;
import java.util.TreeMap;

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
   public static Resultats votePlurinominaleUnTour(Matrix mat, int nbChoixPossible) {

       System.out.println("Nombre de choix : " + nbChoixPossible);
       mat.GenAutoChoixMultiple(nbChoixPossible);
       System.out.println(mat.toString());

       HashMap<Integer, Integer> stats = Somme.sommeDeUn(mat);

       Integer vainqueur = Somme.vainqueur(stats);

       ValueComparator comparateur = new ValueComparator(stats);
       TreeMap<Integer,Integer> mapTriee = new TreeMap<Integer,Integer>(comparateur);
       mapTriee.putAll(stats);

       TreeMap<Integer,Integer> resultats = new TreeMap<Integer, Integer>();
       resultats.put(1,mapTriee.firstKey());

       System.out.print("Tableau de résultats : ");
       System.out.println(resultats);

       System.out.print("Tableau de Statistiques : ");
       System.out.println(mapTriee);

       Resultats res = new Resultats(mapTriee,stats);

       System.out.println();
       System.out.println("Le vainqueur est le " + vainqueur + " avec : " + stats.get(vainqueur));


       return res;
   }




}
