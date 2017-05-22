package algo;

import structure.Matrix;
import structure.Resultat;
import structure.StructureJugementMajoritaire;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stephane on 22/05/17.
 */
public class JugementMajoritaire {

    public static Resultat voteJugementMajoritaire(Matrix mat, int echelle){

        int cpt;
        StructureJugementMajoritaire tabStats = new StructureJugementMajoritaire(mat,echelle);
        System.out.println(tabStats.toString());

        tabStats.calculStats(mat,tabStats);
        System.out.println(tabStats.toString());

        tabStats.statsEnPourcentage(tabStats,mat.getVotants());
        System.out.println(tabStats.toString());


/*
        for (int i = 0; i<mat.getChoix();i++){
            for (int j= 0; j< mat.getVotants();j++){
               tabEchelle[i][mat.getCase(i,j)] ++;
            }
        }

        for (int i = 0 ; i < mat.getChoix() ; i++) {
            for (int j = 0 ; j < echelle ; j++) {
                tabEchelle[i][j] *= 100;
                tabEchelle[i][j] /= mat.getVotants();
                System.out.print(tabEchelle[i][j] + " ");
            }
            System.out.println();
        }*/



        return null;
    }

}
