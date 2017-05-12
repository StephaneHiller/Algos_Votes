package structure;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stephane on 12/05/17.
 */
public class Matrix {

    int votants;
    int choix;
    private int tab[][];
    private List array;

    public Matrix() {
    }

    public Matrix(int[][] tab) {
        this.tab = tab;
    }

    public Matrix(List array) {
        this.array = array;
    }

    public Matrix(int nbVotants, int nbChoix){

        this.votants = nbVotants;
        this.choix =nbChoix;
        tab = new int[this.choix][this.votants];

    }

    public int[][] getTab() {
        return tab;
    }

    public int getCase(int i, int j) {
        return tab[i][j];
    }

    public List getArray() {
        return array;
    }

    public int getVotants() {
        return votants;
    }

    public int getChoix() {
        return choix;
    }

    public void setCase(Integer val, int i, int j){
        tab[i][j] = val;
    }

    public void afficher() {
        for(int i=0;i<this.choix;i++){
            for(int j=0;j<this.votants;j++){
                System.out.print(tab[i][j]);
            }
            System.out.println();
        }

        //System.out.println(array.toString());
    }

    public void init() {

        for(int i=0; i<this.choix; i++){
            for(int j=0; j<this.votants; j++){
                tab[i][j] = 0;
            }
        }
        /*
        array = new ArrayList();
        for(int i=0;i<this.choix * this.votants;i++){
            array.add(0);
        }*/
    }

    public void GenAutoChoixUnique() {
        int nb;
        for(int i=0; i<this.votants;i++){
            nb = (int) (Math.random() * this.choix );     //Pour un entier entre 0 et choix
            tab[nb][i]=1;
        }
    }

    public void GenAutoChoixMultiple(int nbChoixPossible) {
        int nb;
        for(int i=0; i<this.votants;i++){
            int j=0;
            while( j < nbChoixPossible) {
                nb = (int) (Math.random() * this.choix );     //Pour un entier entre 0 et choix
                if(tab[nb][i] !=1){
                    tab[nb][i]=1;
                    j++;

                }
            }

        }
    }


}
