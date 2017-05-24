package algo;

import exception.MauvaiseEchelleJugementMajoritaireException;
import structure.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


/**
 * Created by stephane on 22/05/17.
 */

/**
 * Méthode permettant de réaliser un scrutin de type Jugement Majoritaire
 */
public class JugementMajoritaire {

    public static Resultat voteJugementMajoritaire(Matrix mat, int echelle){

        /**
         * Déclaration des maps qui serviront de retour une fois la méthode terminée.
         */
        TreeMap<Integer,Integer> resultats;
        HashMap<Integer, ArrayList<Double>> stats;

        /**
         * Déclaration et initialisation d'une structure StructureJugementMajoritaire à partir de la Matrix passé en
         * paramètre et de l'échelle de niveau.
         */
        StructureJugementMajoritaire tabStats = null;
        try {
            tabStats = new StructureJugementMajoritaire(mat,echelle);
        } catch (MauvaiseEchelleJugementMajoritaireException e) {
            e.printStackTrace();
        }
        /**
         * Calcul des statistiques des différents choix
         */
        tabStats.calculStats(mat,tabStats);
        /**
         * Transformation des statistiques originellement en somme en pourcentage.
         */
        tabStats.statsEnPourcentage(tabStats,mat.getVotants());
        /**
         * Création du tableau des mention majoritaire pour chaque choix
         */
        tabStats.calculMentionMajoritaire(tabStats);

        /**
         * Transformation de la map des mentions majoritaires non triées en un map triées par ordre croissant des
         * mentions.
         */
        AscendingComparator comparateur = new AscendingComparator(tabStats.getMentionMajoritaire());
        TreeMap<Integer,Integer> mapTriee = new TreeMap<Integer,Integer>(comparateur);
        mapTriee.putAll(tabStats.getMentionMajoritaire());

        System.out.println(tabStats.toString());

        /**
         * récupération de la map contenant le vainqueur
         */
        resultats = tabStats.getVainqueur(tabStats, mapTriee);
        /**
         * récupération de la map contenant les statistiques
         */
        stats = tabStats.getTabPourcentage();
        /**
         * création d'un objet Resultat à partir de la map resultats et d'une hashmap null (correspondant au tableau
         * des statistiques génériques qu'il ne possède pas.
         */
        Resultat res = new Resultat(resultats,null);
        /**
         * ajout dans l'objet resultat de la map contenant les statistiques du jugement majoritaire
         */
        res.setStatsJugementMajoritaire(stats);

        /**
         * renvoie l'objet Resultat contenant les informations du choix social
         */
        return res;
    }

}
