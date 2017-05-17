import algo.Somme;
import algo.UninominaleUnTour;
import junit.framework.TestCase;
import org.junit.Test;
import structure.Matrix;

/**
 * Created by stephane on 17/05/17.
 */
public class voteUniTest extends TestCase {


    @Test
    public final void testUni(){
        int votants = 10;
        int choix = 5;
        int tab[][] = {
                {0,1,0,0,0,0,0,0,1,0},
                {1,0,0,0,0,0,0,1,0,0},
                {0,0,0,1,0,0,1,0,0,0},
                {0,0,1,0,1,0,0,0,0,1},
                {0,0,0,0,0,1,0,0,0,0}};
        Matrix mat = new Matrix(tab,votants,choix);

        System.out.println(mat.toString());

        Integer[] resultats = UninominaleUnTour.voteUninominaleUnTour(mat);
        Integer[] resultatsEscompte = {2,2,2,3,1};
        int cpt = 0;
        int j = 0;

        for (int i=0 ; i<resultats.length;i++){
            assertEquals("Le resultat devrait etre " + resultatsEscompte[i], resultats[i], resultatsEscompte[i]);
            cpt++;
        }
        assertEquals("Le nombre de tests reussi devraient être 5", cpt,5);

    }

}
