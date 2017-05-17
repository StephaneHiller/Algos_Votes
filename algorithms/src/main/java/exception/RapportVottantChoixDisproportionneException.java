package exception;

/**
 * Created by stephane on 17/05/17.
 */
public class RapportVottantChoixDisproportionneException extends MatrixFormatException {
    public RapportVottantChoixDisproportionneException(){

        System.out.println("Attention, le nombre de votant est plus important que le nombre de choix disponible, " +
                "les résultats risquent de ne pas être pertinent voir faux.");

    }

}
