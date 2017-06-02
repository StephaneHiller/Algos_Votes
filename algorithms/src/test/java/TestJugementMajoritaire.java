import algo.JugementMajoritaire;
import org.junit.Test;
import structure.Matrix;
import structure.Resultat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by stephane on 01/06/17.
 */
public class TestJugementMajoritaire {

    @Test
    public final void testJugementMajoritaire() {

        int votants = 10;
        int choix = 5;
        Byte tab[][] = {
                {1,0,1,0,0,1,3,2,0,4},
                {3,1,3,2,1,4,3,2,2,2},
                {0,1,4,2,2,1,0,2,1,2},
                {2,1,2,3,4,1,1,3,2,2},
                {2,0,1,4,3,0,1,4,1,2}};
        Matrix mat = new Matrix(tab,votants,choix);
        int echelle = 5;

        HashMap<Integer, ArrayList<Double>> pourcentageEscompte = new HashMap<Integer, ArrayList<Double>>();
        ArrayList<Double> tmp = new ArrayList<Double>();
        tmp.add(40.0);
        tmp.add(30.0);
        tmp.add(10.0);
        tmp.add(10.0);
        tmp.add(10.0);
        pourcentageEscompte.put(0,tmp);
        tmp = new ArrayList<Double>();
        tmp.add(0.0);
        tmp.add(20.0);
        tmp.add(40.0);
        tmp.add(30.0);
        tmp.add(10.0);
        pourcentageEscompte.put(1,tmp);
        tmp = new ArrayList<Double>();
        tmp.add(20.0);
        tmp.add(30.0);
        tmp.add(40.0);
        tmp.add(0.0);
        tmp.add(10.0);
        pourcentageEscompte.put(2,tmp);
        tmp = new ArrayList<Double>();
        tmp.add(0.0);
        tmp.add(30.0);
        tmp.add(40.0);
        tmp.add(20.0);
        tmp.add(10.0);
        pourcentageEscompte.put(3,tmp);
        tmp = new ArrayList<Double>();
        tmp.add(20.0);
        tmp.add(30.0);
        tmp.add(20.0);
        tmp.add(10.0);
        tmp.add(20.0);
        pourcentageEscompte.put(4,tmp);


        TreeMap<Integer, Integer> resultatsEscompte = new TreeMap<Integer, Integer>();
        resultatsEscompte.put(1,0);


        Resultat resEscompte = new Resultat(resultatsEscompte,null);
        resEscompte.setStatsJugementMajoritaire(pourcentageEscompte);

        Resultat result = JugementMajoritaire.voteJugementMajoritaire(mat,echelle);
        System.out.println(resEscompte);
        System.out.println(result);

        for (Map.Entry<Integer,Integer> entry: resEscompte.getResultats().entrySet()){
            assertEquals("Le vainqueur devrait être : " + entry.getValue(),entry.getValue(),result.getResultats().get(1) );
        }
        for (Map.Entry<Integer, ArrayList<Double>> entry: resEscompte.getStatsJugementMajoritaire().entrySet()) {
            for (int i=0;i<resEscompte.getStatsJugementMajoritaire().size();i++){
                assertEquals("La valeur pour la mention " + i + " devrait être : " + resEscompte.getStatsJugementMajoritaire().get(entry.getKey()).get(i),
                        resEscompte.getStatsJugementMajoritaire().get(entry.getKey()).get(i),
                        result.getStatsJugementMajoritaire().get(entry.getKey()).get(i));
            }
        }

    }
}
