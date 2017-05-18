package algo;

import structure.Matrix;
import structure.Resultats;
import structure.ValueComparator;

import java.util.HashMap;
import java.util.TreeMap;

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
     * @param mat : matrice contenant les informations
     */
    public static Resultats voteBorda(Matrix mat){

        mat.GenAutoListePreferences();
        System.out.println(mat.toString());

        HashMap<Integer, Integer> stats = Somme.somme(mat);

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
