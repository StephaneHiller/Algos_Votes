package algo;

import structure.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


/**
 * Created by stephane on 22/05/17.
 */
public class JugementMajoritaire {

    public static Resultat voteJugementMajoritaire(Matrix mat, int echelle){

        TreeMap<Integer,Integer> resultats;
        HashMap<Integer, ArrayList<Double>> stats;

        int cpt;
        StructureJugementMajoritaire tabStats = new StructureJugementMajoritaire(mat,echelle);
        tabStats.calculStats(mat,tabStats);
        tabStats.statsEnPourcentage(tabStats,mat.getVotants());
        tabStats.calculMentionMajoritaire(tabStats);

        AscendingComparator comparateur = new AscendingComparator(tabStats.getMentionMajoritaire());
        TreeMap<Integer,Integer> mapTriee = new TreeMap<Integer,Integer>(comparateur);
        mapTriee.putAll(tabStats.getMentionMajoritaire());

        System.out.println(tabStats.toString());

        resultats = tabStats.getVainqueur(tabStats, mapTriee);
        stats = tabStats.getTabPourcentage();
        Resultat res = new Resultat(resultats,null);
        res.setStatsJugementMajoritaire(stats);

        return res;
    }

}
