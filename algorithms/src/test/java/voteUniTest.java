import algo.ScrutinMajoritaireParSomme;
import junit.framework.TestCase;
import org.junit.Test;
import structure.Matrix;
import structure.Resultat;

/**
 * Created by stephane on 17/05/17.
 */
public class voteUniTest extends TestCase {


    @Test
    public final void testScrutinMajoritaireParSomme(){
        int votants = 10;
        int choix = 5;
        Byte tab[][] = {
                {0,1,0,0,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,0,0},
                {0,0,0,1,0,0,1,0,0,0},
                {0,0,1,0,1,0,0,0,0,1},
                {0,0,0,0,0,1,0,0,0,0}};
        Matrix mat = new Matrix(tab,votants,choix);

        System.out.println(mat.toString());

        Resultat result = ScrutinMajoritaireParSomme.voteScrutinMajoritaireParSomme(mat);
        int cpt = 0;
        int j = 0;

        //assertEquals("Le resultat devrait etre " + vainqueurEscompte, vainqueur, vainqueurEscompte);

    }

}
