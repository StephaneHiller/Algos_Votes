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
     * Méthode de scrutin majoritaire par somme.
     * @param mat : matrice contenant les informations
     */
   public static Resultat voteScrutinMajoritaireParSomme(Matrix mat) {

       /**
        * Déclaration et instanciation de la map des statistiques a partir de l'objet Matrix
        */
       HashMap<Integer, Integer> stats = Somme.somme(mat);

       /**
        * Récupère l'indice du vainqueur
        */
       Integer vainqueur = Somme.vainqueur(stats);

       /**
        * Classe la map des stats par ordre décroissant
        */
       DescendingComparator comparateur = new DescendingComparator(stats);
       TreeMap<Integer,Integer> mapTriee = new TreeMap<Integer,Integer>(comparateur);
       mapTriee.putAll(stats);

       /**
        * Déclaration de la map contenant le vainqueur
        */
       TreeMap<Integer,Integer> resultats = new TreeMap<Integer, Integer>();
       /**
        * Ajout du vainqueur à la map
        */
       resultats.put(1,mapTriee.firstKey());

       System.out.print("Tableau de résultats : ");
       System.out.println(resultats);

       System.out.print("Tableau de Statistiques : ");
       System.out.println(stats);

       /**
        * Déclaration et instanciation de l'objet Resultat que l'on va retourner
        */
       Resultat res = new Resultat(resultats,stats);

       System.out.println();
       System.out.println("Le vainqueur est le " + vainqueur + " avec : " + stats.get(vainqueur));

       /**
        * retourne l'objet Resultat
        */
       return res;
   }




}
