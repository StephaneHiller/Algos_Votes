package test;

import algo.Borda;
import algo.PlurinominaleUnTour;
import algo.UninominaleDeuxTours;
import algo.UninominaleUnTour;
import structure.Matrix;

/**
 * Created by stephane on 12/05/17.
 */
public class Main {

    static Matrix initValeur(){
        int votants = 50;
        int choix = 5;
        Matrix mat = new Matrix(votants,choix);
        mat.init();
        return mat;
    }

    public static long testUninominaleUnTour(){
        Matrix mat = initValeur();


        long tps = UninominaleUnTour.voteUninominaleUnTour(mat);
        return tps;

    }

    public static void testPlurinominaleUnTour() {

        Matrix mat = initValeur();

        long debut = System.currentTimeMillis();

        PlurinominaleUnTour.votePlurinominaleUnTour(mat,2);

        long duree = System.currentTimeMillis() - debut;
        System.out.println("La durée est de : " + duree + " millisecondes");

    }

    public static void testUninominaleDeuxTour(){
        Matrix mat = initValeur();

        long debut = System.currentTimeMillis();

        UninominaleDeuxTours.voteUninominaleDeuxTour(mat);

        long duree = System.currentTimeMillis() - debut;
        System.out.println("La durée est de : " + duree + " millisecondes");
    }

    public static void testBorda(){

        Matrix mat = initValeur();

        Borda.voteBorda(mat);
    }

    public static void main(String[] args) {

        System.out.println("========= Uninominale à un tour ========= ");
        Main.testUninominaleUnTour();

        System.out.println("\n\n========= Plurinominale à un tour ========= ");
        Main.testPlurinominaleUnTour();

        System.out.println("\n\n========= Uninominale à deux tour ========= ");
        Main.testUninominaleDeuxTour();

        System.out.println("\n\n========= Borda ========= ");
        Main.testBorda();

    }
}
