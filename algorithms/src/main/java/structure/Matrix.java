package structure;


import exception.MatrixFormatException;
import exception.RapportVottantChoixDisproportionneException;

import java.util.ArrayList;

/**
 * Created by stephane on 12/05/17.
 */

/**
 * Classe représentant un choix social sous forme d'une matrice à n colonnes et m lignes
 * -   n colonnes représentant les n votants du choix social
 * -   m lignes représentant les m choix possibles du choix social
 * -   la valeur numérique contenu dans chaque case de la matrice correspond à l'appréciation d'un votant pour un choix
 * ex : Soit la case tab[1][2] = 5 dans un alphabet allant de [1,5], cela signifie que l'appréciation du votant 2 par
 * rapport au choix 1 est de 5.
 */
public class Matrix {

    /**
     * Nombre de votants
     */
    private int votants;

    /**
     * Nombre de choix
     */
    private int choix;
    /**
     * Matrice de choix social
     */
    private int tab[][];

    /**
     * Constructeur de matrice à partir d'un autre tableau à deux dimension
     * @param tab : tableau à deux dimensions représentant la matrice
     * @param votants : nombre de votants
     * @param choix : nombre de choix
     */
    public Matrix(int[][] tab, int votants, int choix) {
        this.tab = tab;
        this.votants =votants;
        this.choix = choix;
    }

    /**
     * Constructeur de matrice à partir du nombre de votants et du nombre de choix. Initialise un tableau à deux
     * dimensions vide.
     * @param nbVotants : nombre de votants
     * @param nbChoix : nombre de choix
     * @throws MatrixFormatException : exception vérifiant le format de la matrice
     */
    public Matrix(int nbVotants, int nbChoix) throws MatrixFormatException {

        this.votants = nbVotants;
        this.choix =nbChoix;
        tab = new int[this.choix][this.votants];
        checkout();
    }

    /**
     * Méthode vérifiant le format de la matrice
     * @throws MatrixFormatException : exception vérifiant le format de la matrice
     */
    private void checkout() throws MatrixFormatException {

        if(this.getVotants() < this.getChoix()){
            throw new RapportVottantChoixDisproportionneException();
        }

    }
    /**
     * Méthode permettant de récupérer le tableau à deux dimensions
     * @return tab : tableau à deux dimensions
     */
    public int[][] getTab() {
        return tab;
    }

    /**
     * Méthode permettant de récupérer la case d'abscisse i et d'ordonnée j dans le tableau à deux dimensions
     * @param i : l'abscisse de la case que l'on souhaite récupérer
     * @param j : l'ordonnée de la case que l'on souhaite récupérer
     * @return la valeur contenue dans la case tab[i][j]
     */
    public int getCase(int i, int j) {
        return tab[i][j];
    }

    /**
     * Méthode permettant de récupérer le nombre de votants du choix social
     * @return le nombre de votants
     */
    public int getVotants() {
        return votants;
    }

    /**
     * Méthode permettant de récupérer le nombre de choix du choix social
     * @return le nombre de choix
     */
    public int getChoix() {
        return choix;
    }

    /**
     * Méthode permettant d'insérer une valeur val dans la
     * case d'abscisse i et d'ordonnée j du tableau à deux
     * dimension
     * @param val : la valeur que l'on souhaite insérer
     * @param i : l'abscisse à laquelle on souhaite l'insérer
     * @param j : l'ordonnée à laquelle on souhaite l'insérer
     */
    public void setCase(Integer val, int i, int j){
        tab[i][j] = val;
    }


    /**
     * Méthode permettant de remplir un tableau à deux dimensions avec des 0
     */
    public void init() {

        for(int i=0; i<this.choix; i++){
            for(int j=0; j<this.votants; j++){
                tab[i][j] = 0;
            }
        }

    }

    /**
     * Méthode qui place, dans un tableau à deux dimensions initialement rempli de zéro, une valeur 1 correspondant à un
     * choix. Cette valeur est choisi aléatoirement pour chaque votant
     */
    public void GenAutoChoixUnique() {
        int nb;
        for(int i=0; i<this.votants;i++){
            nb = (int) (Math.random() * this.choix );     //Pour un entier entre 0 et choix
            tab[nb][i]=1;
        }
    }

    /**
     * Méthode qui place, dans un tableau à deux dimensions
     * initialement rempli de zéro, nbChoixPossible valeur 1
     * correspondant aux choix. Ces valeurs sont
     * choisis aléatoirement pour chaque votant
     *
     * @param nbChoixPossible : nombre de choix à remplir
     */
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

    /**
     * Méthode génère dans un tableau à deux dimensions une
     * liste de préférences. Cette liste est réprésenté par une
     * valeur comprise entre 1 et le nombre de choix du choix social.
     * Ces valeurs sont réparties aléatoirement pour
     * chacun des candidats pour chacun des choix possibles
     */
    public void GenAutoListePreferences(){
        int nb;
        ArrayList<Integer> valeurs = new ArrayList();

        for(int i=0; i<this.votants;i++){
            for(int k=1; k<=this.getChoix();k++){
                valeurs.add(k);
            }
            for(int j=0; j< this.choix; j++){
                nb = (int) (Math.random() * (this.choix -(j)));
                tab[j][i] = valeurs.get(nb);
                valeurs.remove(nb);
            }
        }
    }

    /**
     * Méthode permettant d'afficher les informations d'une matrix sur la sortie écran
     */
    @Override
    public String toString() {
        int[][] tab = getTab();
        String concat= "";
        for (int i[] : tab){
            for (Integer j : i){
                concat += j.toString() + " ";
            }
            concat += "\n";
        }
        return "Nombre de votants : " + votants + "\n" +
                "Nombre de choix : " + choix + "\n\n" +
                concat;
    }
}
