package algo;

import structure.Matrix;
import structure.Resultat;
import structure.DescendingComparator;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by stephane on 12/05/17.
 */


public class ScrutinMajoritaireParSomme {

    /***
     * Méthode de scrutin plurinominal à un tour. À partir d'un tableau initialisé et vide :
     *     TODO
     * @param mat : matrice contenant les informations
     */
   public static Resultat voteScrutinMajoritaireParSomme(Matrix mat) {

       HashMap<Integer, Integer> stats = Somme.somme(mat);

       Integer vainqueur = Somme.vainqueur(stats);

       DescendingComparator comparateur = new DescendingComparator(stats);
       TreeMap<Integer,Integer> mapTriee = new TreeMap<Integer,Integer>(comparateur);
       mapTriee.putAll(stats);

       TreeMap<Integer,Integer> resultats = new TreeMap<Integer, Integer>();
       resultats.put(1,mapTriee.firstKey());

       System.out.print("Tableau de résultats : ");
       System.out.println(resultats);

       System.out.print("Tableau de Statistiques : ");
       System.out.println(stats);

       Resultat res = new Resultat(resultats,stats);

       System.out.println();
       System.out.println("Le vainqueur est le " + vainqueur + " avec : " + stats.get(vainqueur));


       return res;
   }




}
