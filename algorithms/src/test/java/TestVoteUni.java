import algo.ScrutinMajoritaireParSomme;
import junit.framework.TestCase;
import org.junit.Test;
import structure.Matrix;
import structure.Resultat;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by stephane on 17/05/17.
 */
public class TestVoteUni extends TestCase {


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

        HashMap<Integer, Integer> statsEscompte = new HashMap<Integer, Integer>();
        statsEscompte.put(1,2);
        statsEscompte.put(2,2);
        statsEscompte.put(3,2);
        statsEscompte.put(4,3);
        statsEscompte.put(5,1);

        TreeMap<Integer, Integer> resultatsEscompte = new TreeMap<Integer, Integer>();
        resultatsEscompte.put(1,4);

        Resultat resEscomte = new Resultat(resultatsEscompte,statsEscompte);

        for (Map.Entry<Integer,Integer> entry: resEscomte.getResultats().entrySet()){
            assertEquals("Le vainqueur devrait être : " + entry.getValue(),entry.getValue(),result.getResultats().get(1) );
        }
        for (Map.Entry<Integer,Integer> entry: resEscomte.getStats().entrySet()){
            assertEquals("Le score du choix " + entry.getKey() + " devrait être : " + entry.getValue(),entry.getValue(),result.getStats().get(entry.getKey()));
        }
    }

    @Test
    public final void testScrutinMajoritaireParSommeBorda(){
        int votants = 10;
        int choix = 5;
        Byte tab[][] = {
                {3,1,2,5,3,3,4,3,1,4},
                {1,5,3,2,4,5,2,1,2,5},
                {4,4,4,4,2,2,1,5,3,2},
                {5,1,1,3,1,4,4,4,4,1},
                {2,3,5,1,5,1,5,2,5,3}};
        Matrix mat = new Matrix(tab,votants,choix);

        System.out.println(mat.toString());

        Resultat result = ScrutinMajoritaireParSomme.voteScrutinMajoritaireParSomme(mat);

        HashMap<Integer, Integer> statsEscompte = new HashMap<Integer, Integer>();
        statsEscompte.put(1,29);
        statsEscompte.put(2,30);
        statsEscompte.put(3,31);
        statsEscompte.put(4,28);
        statsEscompte.put(5,32);

        TreeMap<Integer, Integer> resultatsEscompte = new TreeMap<Integer, Integer>();
        resultatsEscompte.put(1,5);

        Resultat resEscomte = new Resultat(resultatsEscompte,statsEscompte);

        for (Map.Entry<Integer,Integer> entry: resEscomte.getResultats().entrySet()){
            assertEquals("Le vainqueur devrait être : " + entry.getValue(),entry.getValue(),result.getResultats().get(1) );
        }
        for (Map.Entry<Integer,Integer> entry: resEscomte.getStats().entrySet()){
            assertEquals("Le score du choix " + entry.getKey() + " devrait être : " + entry.getValue(),entry.getValue(),result.getStats().get(entry.getKey()));
        }
    }

}
