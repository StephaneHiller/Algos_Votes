package test;

import algo.JugementMajoritaire;
import algo.ScrutinMajoritaireParSomme;
import algo.UninominaleDeuxTours;
import exception.MatrixFormatException;
import structure.Matrix;

/**
 * Created by stephane on 12/05/17.
 */
public class Main {

    static Matrix initValeur(){
        int votants = 10;
        int choix = 10;
        Matrix mat = null;
        try {
            mat = new Matrix(votants,choix);
        } catch (MatrixFormatException e) {
            e.printStackTrace();
        }
        mat.init();
        return mat;
    }

    public static void testUninominaleUnTour(){
        Matrix mat = initValeur();
        mat.GenAutoChoixUnique();
        System.out.println(mat.toString());

        ScrutinMajoritaireParSomme.voteScrutinMajoritaireParSomme(mat);
    }

    public static void testPlurinominaleUnTour() {

        Matrix mat = initValeur();
        mat.GenAutoChoixMultiple(3);
        System.out.println(mat.toString());
        System.out.println("Nombre de choix : " + 3);


        ScrutinMajoritaireParSomme.voteScrutinMajoritaireParSomme(mat);
    }

    public static void testUninominaleDeuxTour(){
        Matrix mat = initValeur();

        long debut = System.currentTimeMillis();

        int vainqueur = UninominaleDeuxTours.voteUninominaleDeuxTour(mat);

        long duree = System.currentTimeMillis() - debut;
        System.out.println("La durée est de : " + duree + " millisecondes");
    }

    public static void testBorda(){

        Matrix mat = initValeur();
        mat.GenAutoListePreferences();
        System.out.println(mat.toString());

        ScrutinMajoritaireParSomme.voteScrutinMajoritaireParSomme(mat);
    }

    public static void testJugementMajoritaire(){

        Matrix mat = initValeur();
        mat.GenAutoListJugementMajoritaire(7);
        System.out.println(mat.toString());

        JugementMajoritaire.voteJugementMajoritaire(mat,7);
    }

    public static void main(String[] args) {

        System.out.println("========= Uninominale à un tour ========= ");
        Main.testUninominaleUnTour();

        System.out.println("\n\n========= Plurinominale à un tour ========= ");
        Main.testPlurinominaleUnTour();
/*
        System.out.println("\n\n========= Uninominale à deux tour ========= ");
        Main.testUninominaleDeuxTour();
*/
        System.out.println("\n\n========= Borda ========= ");
        Main.testBorda();

        System.out.println("\n\n========= Jugement majoritaire ========= ");
        Main.testJugementMajoritaire();

    }
}
