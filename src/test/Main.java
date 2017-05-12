package test;

import algo.PlurinominaleUnTour;
import algo.UninominaleDeuxTour;
import algo.UninominaleUnTour;
import structure.Matrix;

/**
 * Created by stephane on 12/05/17.
 */
public class Main {


    public static void testUninominaleUnTour(){
        int votants = 10;
        int choix = 3;
        Matrix mat = new Matrix(votants,choix);
        mat.init();

        long debut = System.currentTimeMillis();

        UninominaleUnTour.voteUninominaleUnTour(mat);

        long duree = System.currentTimeMillis() - debut;
        System.out.println("La durée est de : " + duree + " millisecondes");
    }

    public static void testPlurinominaleUnTour() {

        int votants = 10;
        int choix = 3;
        Matrix mat = new Matrix(votants,choix);
        mat.init();

        long debut = System.currentTimeMillis();

        PlurinominaleUnTour.votePlurinominaleUnTour(mat,2);

        long duree = System.currentTimeMillis() - debut;
        System.out.println("La durée est de : " + duree + " millisecondes");

    }

    public static void testUninominaleDeuxTour(){
        int votants = 50;
        int choix = 3;
        Matrix mat = new Matrix(votants,choix);
        mat.init();

        long debut = System.currentTimeMillis();

        UninominaleDeuxTour.voteUninominaleDeuxTour(mat);

        long duree = System.currentTimeMillis() - debut;
        System.out.println("La durée est de : " + duree + " millisecondes");
    }

    public static void main(String[] args) {

        System.out.println("========= Uninominale à un tour ========= ");
        Main.testUninominaleUnTour();

        System.out.println();
        System.out.println();

        System.out.println("========= Plurinominale à un tour ========= ");
        Main.testPlurinominaleUnTour();

        System.out.println();
        System.out.println();

        System.out.println("========= Uninominale à deux tour ========= ");
        Main.testUninominaleDeuxTour();

    }
}
