package exception;

/**
 * Created by stephane on 24/05/17.
 */
public class MauvaiseEchelleJugementMajoritaireException extends Exception {
    public MauvaiseEchelleJugementMajoritaireException(){

        System.out.println("Attention, le niveau de l'échelle doit être compris entre 5 et 7.");

    }
}
