package structure;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by stephane on 22/05/17.
 */
public class StructureJugementMajoritaire {

    HashMap<Integer, ArrayList<Double>> tabEchelle;
    int echelle;
    Integer mentionMajoritaire;

    public HashMap<Integer, ArrayList<Double>> getTabEchelle() {
        return tabEchelle;
    }

    public StructureJugementMajoritaire(Matrix mat, int echelle) {
        this.echelle = echelle;
        tabEchelle = new HashMap<Integer, ArrayList<Double>>();
        ArrayList<Double>  res;
        mentionMajoritaire = null;
        for (int i=0; i<mat.getChoix();i++){
            res = new ArrayList<Double>();
            for (int j=0; j<echelle;j++){
                res.add(0.0);
            }
            tabEchelle.put(i,res);
        }
    }

    public void calculStats(Matrix mat, StructureJugementMajoritaire struct){
        Double tmp;
        for (int i=0 ; i<tabEchelle.size();i++){
            for (int j= 0; j< mat.getVotants();j++){
                tmp = struct.tabEchelle.get(i).get(mat.getCase(i,j));
                tmp++;
                struct.tabEchelle.get(i).set(mat.getCase(i,j),tmp);
            }
        }
    }

    public void statsEnPourcentage(StructureJugementMajoritaire struct, int nbVotants){
        double tmp;
        for (int i=0 ; i <struct.tabEchelle.size(); i++){
            for (int j =0; j<struct.echelle ;j++){
                tmp = struct.tabEchelle.get(i).get(j);
                tmp *=100;
                tmp /= nbVotants;
                struct.tabEchelle.get(i).set(j,tmp);
            }
        }
    }

    @Override
    public String toString() {
        return "StructureJugementMajoritaire{" +
                "tabEchelle=" + tabEchelle +
                ", mentionMajoritaire=" + mentionMajoritaire +
                '}';
    }
}
