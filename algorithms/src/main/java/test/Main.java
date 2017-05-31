package test;

import algo.JugementMajoritaire;
import algo.STV;
import algo.ScrutinMajoritaireParSomme;
import exception.MatrixFormatException;
import structure.Matrix;

/**
 * Created by stephane on 12/05/17.
 */
public class Main {

    static Matrix initValeur(){
        int votants = 100;
        int choix = 7;
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

    public static void testBorda(){

        Matrix mat = initValeur();
        mat.GenAutoListePreferences();
        System.out.println(mat.toString());

        ScrutinMajoritaireParSomme.voteScrutinMajoritaireParSomme(mat);
    }

    public static void testJugementMajoritaire(){

        Matrix mat = initValeur();
        mat.GenAutoListJugementMajoritaire(6);
        System.out.println(mat.toString());

        JugementMajoritaire.voteJugementMajoritaire(mat,6);
    }

    public static void testSTV(){
        Matrix mat = initValeur();
        int choixQuota = 1;
        int choixPerdant = 2;
        int nbGagnant = 3;
        mat.GenAutoListePreferences();
        System.out.println(mat.toString());
        STV.voteSTV(mat, choixQuota, 1, nbGagnant);
        STV.voteSTV(mat, choixQuota, choixPerdant, nbGagnant);
    }

    public static void main(String[] args) {

        System.out.println("========= Uninominale à un tour ========= ");
        Main.testUninominaleUnTour();

        System.out.println("\n\n========= Plurinominale à un tour ========= ");
        Main.testPlurinominaleUnTour();

        System.out.println("\n\n========= Borda ========= ");
        Main.testBorda();

        System.out.println("\n\n========= Jugement majoritaire ========= ");
        Main.testJugementMajoritaire();

        System.out.println("\n\n========= STV ========= ");
        Main.testSTV();

    }
}
