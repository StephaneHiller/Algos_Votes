package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by stephane on 22/05/17.
 */

/**
 * Classe permettant, à partir d'un objet Matrix de créer et conserver
 * les informations nécessaire à la réalisation d'un scrutin de type
 * jugement majoritaire.
 */
public class StructureJugementMajoritaire {

    /**
     * Hashmap servant à identifié, pour chaque vote, le pourcentage obtenu
     * pour chaque niveau de l'echelle
     * ex : 0 : [14.0, 22.0, 16.0, 8.0, 14.0, 11.0, 15.0]
     */
    private HashMap<Integer, ArrayList<Double>> tabPourcentage;

    /**
     * L'echelle correspond au niveau de l'échelle, cad si c'est une échelle
     * à 5,6 ou 7 niveaux
     */
    int echelle;

    /**
     * Hashmap servant à identifié, pour chaque vote, sa mention majoritaire
     * parmis les mentions possible
     * ex : soit une echelle - Très Bien / Bien / Sans Avis / Passable / Insuffisant
     *      on aura : choix 0 : 2 (Sans avis)
     *                choix 1 : 3 (Passable)
     *                choix 3 : 1 (Bien)
     *                ...
     */
    private HashMap<Integer, Integer>  mentionMajoritaire;

    /**
     * Hashmap servant à identifié, pour chaque vote étant en "finale", le pourcentage
     * de personne qui pensent que ce choix vaut soit Strictement plus, soit strictement
     * moins. La première case du Arraylist correspond au pourcentage évaluant le choix
     * strictement plus haut et la seconde case strictement plus bas.
     * ex : Choix 0 : [35.0 , 42.0]
     */
    private HashMap<Integer, ArrayList<Double>> tabResult;

    /**
     * Getter permettant de récupérer, à condition qu'il ne soit pas NULL, le tableau
     * tabPourcentage
     * @return : le tableau tabPourcentage
     */
    public HashMap<Integer, ArrayList<Double>> getTabPourcentage() {
        if (tabPourcentage !=null){
            return tabPourcentage;
        }
        else return null;
    }

    /**
     * Getter permettant de récupérer le niveau de l'échelle
     * @return : le niveau de l'échelle
     */
    public int getEchelle() {
        return echelle;
    }

    /**
     * Getter permettant de récupérer, à condition qu'il ne soit pas NULL,
     * le tableau des mentions majoritaires pour chaque choix
     * @return : le tableau des mentions majoritaires
     */
    public HashMap<Integer, Integer> getMentionMajoritaire() {
        if (mentionMajoritaire != null) {
            return mentionMajoritaire;
        }else return null;
    }

    /**
     * Constructeur d'un objet StructureJugementMajoritaire à partir d'un
     * objet Matrix et du nombre de niveau de l'échelle. A partir de cela,
     * initialise le tableau des Pourcentages à 0.0
     * @param mat : l'objet Matrix contenant les infos du choix social
     * @param echelle : le nombre de niveau de l'échelle
     */
    public StructureJugementMajoritaire(Matrix mat, int echelle) {
        this.echelle = echelle;
        tabPourcentage = new HashMap<Integer, ArrayList<Double>>();
        ArrayList<Double>  res;
        mentionMajoritaire = null;
        for (int i=0; i<mat.getChoix();i++){
            res = new ArrayList<Double>();
            for (int j=0; j<echelle;j++){
                res.add(0.0);
            }
            tabPourcentage.put(i,res);
        }
    }

    /**
     * Méthode qui calcul, à partir de la matrice contenue dans mat, les
     * stattistiques pour chacuns des choix et les insèrent dans tabPourcentage.
     * À ce moment là, les informations contenues dans tabPourcentage ne sont pas
     * encore des pourcentages mais de simple somme.
     * @param mat : objet Matrix où l'on va tirer la matrice du choix sociale
     * @param struct : objet StructureJugementMajoritaire qui va être mis à jour
     *               durant la méthode
     */
    public void calculStats(Matrix mat, StructureJugementMajoritaire struct){
        /***
         * valeur tampon
         */
        Double tmp;

        /***
         * le premier for sert à parcourir tous les choix possibles
         */
        for (int i = 0; i< tabPourcentage.size(); i++){
            /**
             * le second for sert à parcourir tous les votants
             */
            for (int j= 0; j< mat.getVotants();j++){
                /**
                 * soit X la valeur correspondant au niveau attribué au choix i par le votant j dans la matrice de
                 * choix social.
                 * on stocke dans tmp, la valeur contenue dans tabPourcentage à l'indice correspondant au choix i
                 * et l'ordonnée correspondant à X.                 *
                 */
                tmp = struct.tabPourcentage.get(i).get(mat.getCase(i,j));
                /**
                 * on incrémente tmp pour signifier que l'on a rencontrer une fois de plus cette apréciation dans
                 * la matrice du choix sociale.
                 */
                tmp++;
                /**
                 * on remet le nouveau tmp incrémenter à sa place initiale
                 */
                struct.tabPourcentage.get(i).set(mat.getCase(i,j),tmp);
            }
        }
    }


    /**
     * Méthode qui calcul, à partir de la map tabPourcentage encore rempli de somme, le pourcentage correspondant
     * à chacune de ces valeurs, de ces sommes.
     * @param struct : objet StructureJugementMajoritaire qui va être mis à jour durant la méthode
     * @param nbVotants : le nombre de votant du choix social
     */
    public void statsEnPourcentage(StructureJugementMajoritaire struct, int nbVotants){
        double tmp;
        for (int i = 0; i <struct.tabPourcentage.size(); i++){
            for (int j =0; j<struct.echelle ;j++){
                tmp = struct.tabPourcentage.get(i).get(j);
                tmp *=100;
                tmp /= nbVotants;
                struct.tabPourcentage.get(i).set(j,tmp);
            }
        }
    }

    /**
     * Méthode permettant de définir, à partir de la map tabPourcentage en pourcentage, la mention majoritaire
     * de chaque choix.
     * @param struct : objet StructureJugementMajoritaire qui va être mis à jour durant la méthode
     */
    public void calculMentionMajoritaire(StructureJugementMajoritaire struct){
        /**
         * valeur tampon
         */
        Double tmp;

        /**
         * booleen permettant de signifier si l'on a, ou non, trouvé la mention majoritaire
         */
        Boolean mentionTrouve = false;

        /**
         * initialisation de la map mentionMajoritaire que l'on va remplir
         */
        struct.mentionMajoritaire = new HashMap<Integer, Integer>();

        /**
         * compteur
         */
        int j;

        /**
         * le for sert à parcourir tous les choix
         */
        for (int i = 0; i<struct.getTabPourcentage().size(); i++){
            /**
             * réinitialisation des valeurs tampons
             */
            tmp = 0.0;
            j=0;
            mentionTrouve=false;
            /**
             * le while permet de boucler tant que l'on a pas trouver la mention majoritaire
             */
            while(mentionTrouve == false){
                /**
                 * on ajoute à la valeur tampon la valeur contenu dans la case j correspondant au choix i
                 */
                tmp += struct.tabPourcentage.get(i).get(j);

                /**
                 * si la valeur tampon est supérieure à 50 c'est que l'on a trouvé la mention majoritaire
                 * on sort de la boucle
                 */
                if (tmp >= 50.0){
                    mentionTrouve = true;
                }
                /**
                 * sinon on incrémente et on recommence jusqu'à trouver la mention
                 */
                else {
                    j++;
                }
            }
            /**
             * on ajoute a la map la mention majoritaire j correspondant au choix i
             */
            struct.mentionMajoritaire.put(i,j);
        }
    }


    /**
     * Méthode permettant de calculer, à partir d'un tableau de valeurs ainsi que l'indice de la mention
     * majoritaire, le pourcentage de gens qui evaluent le choix plus haut que la mention majoritaire.
     * @param valeurs : tableau des valeurs d'un choix
     * @param indexMentionMajoritaire : l'indice de la mention majoritaire
     * @return : le pourcentage de gens évaluant le choix plus haut
     */
    public Double strictementPlusQueMentionMaj(ArrayList<Double> valeurs, int indexMentionMajoritaire) {

        Double tmp = 0.0;
        for (int i = 0; i<indexMentionMajoritaire;i++){
            tmp += valeurs.get(i);
        }
        return tmp;
    }

    /**
     * Méthode permettant de calculer, à partir d'un tableau de valeurs ainsi que l'indice de la mention
     * majoritaire, le pourcentage de gens qui evaluent le choix plus bas que la mention majoritaire.
     * @param valeurs : tableau des valeurs d'un choix
     * @param indexMentionMajoritaire : l'indice de la mention majoritaire
     * @return : le pourcentage de gens évaluant le choix plus bas
     */
    public Double strictementMoinsQueMentionMaj(ArrayList<Double> valeurs, int indexMentionMajoritaire) {

        Double tmp = 0.0;
        for (int i = indexMentionMajoritaire +1 ; i<valeurs.size() ;i++){
            tmp += valeurs.get(i);
        }
        return tmp;
    }

    /**
     * Méthode permettant de remplir la map tabResult, à partir d'un objet de type StructureJugementMajoritaire et de
     * l'indice de la mention majoritaire.
     * @param struct : objet StructureJugementMajoritaire qui va être mis à jour durant la méthode
     * @param indexMentionMajoritaire : indice de la mention majoritaire
     */
    public void calculEcart(StructureJugementMajoritaire struct, int indexMentionMajoritaire){
        /**
         * pour chaque élément de la map tabResult
         */
        for(Map.Entry<Integer, ArrayList<Double>> entry : struct.tabResult.entrySet()){
            /**
             * soit X la clé de l'élément entry contenu dans le tabResult, correspondant au numéro du choix
             * struct.tabPourcentage.get(entry.getKey()) : c'est le tableau des pourcentages du choix X.
             * On ajoute en première case de l'arraylist de la map tabResult le pourcentage de gens évaluant le choix
             * strictement plus haut
             */
            entry.getValue().add(strictementPlusQueMentionMaj(struct.tabPourcentage.get(entry.getKey()),indexMentionMajoritaire));
            /**
             * soit X la clé de l'élément entry contenu dans le tabResult, correspondant au numéro du choix
             * struct.tabPourcentage.get(entry.getKey()) : c'est le tableau des pourcentages du choix X.
             * On ajoute en seconde case de l'arraylist de la map tabResult le pourcentage de gens évaluant le choix
             * strictement plus bas
             */
            entry.getValue().add(strictementMoinsQueMentionMaj(struct.tabPourcentage.get(entry.getKey()),indexMentionMajoritaire));
        }
    }

    /**
     * Méthode permettant TODO
     * @param tabResult
     * @return
     */
    public TreeMap<Integer,Integer> getVainqueurAvecEgalite(HashMap<Integer, ArrayList<Double>> tabResult){
        Boolean vainqueurtrouve = false;
        Integer numChoix;
        Integer indexTmp;
        Double choixTmp;
        TreeMap<Integer,Integer> res = new TreeMap<Integer, Integer>();

        while ( vainqueurtrouve == false) {
            numChoix = (Integer) tabResult.keySet().toArray()[0];
            indexTmp = 0;
            choixTmp = tabResult.get(numChoix).get(0);

            for(Map.Entry<Integer,ArrayList<Double>> entry : tabResult.entrySet()) {
                for (int i = 0 ; i < entry.getValue().size();i++){
                    if (entry.getValue().get(i) > choixTmp) {
                        choixTmp = entry.getValue().get(i);
                        numChoix = entry.getKey();
                        indexTmp = i;
                    }
                }
            }
            if (indexTmp == 0) {
                res.put(1,numChoix);
                System.out.println("Le vainqueur est : " + numChoix.toString());
                vainqueurtrouve=true;
            }
            else if (indexTmp == 1 && tabResult.size() > 1) {
                tabResult.remove(numChoix);
            } else {
                res.put(1,numChoix);
                System.out.println("Le vainqueur est : " + numChoix.toString());
                vainqueurtrouve=true;
            }
        }
        return res;
    }

    /**
     * Méthode permettant de récupérer le vainqueur du jugement majoritaire sous forme d'une map trié. Le premier
     * élément aura la forme :
     * ex : {1} , {3} signifie que en première place, donc en vainqueur, se trouve le choix numéro 3
     * @param struct : objet StructureJugementMajoritaire qui va être mis à jour durant la méthode
     * @param tabOrdre : map trié dans l'ordre croissant des indices de mentions majoritaires avec leur clé
     *                 correspondant au numéro des votes.
     * @return : la map contenant le vainqueur
     */
    public TreeMap<Integer,Integer> getVainqueur(StructureJugementMajoritaire struct, TreeMap<Integer,Integer> tabOrdre){
        /**
         * initialisation de la map tabResult
         */
        tabResult = new HashMap<Integer, ArrayList<Double>>();
        /**
         * initialisation de la mention majoritaire à la premier valeur contenue dans la map tabOrdre
         */
        Integer mentionGagnante = (Integer) tabOrdre.values().toArray()[0];
        /**
         * initialisation de la map trié res
         */
        TreeMap<Integer,Integer> res = new TreeMap<Integer, Integer>();

        /**
         * permet de parcourir tous les choix
         */
        for(Map.Entry<Integer,Integer> entry : tabOrdre.entrySet()) {
            /**
             * pour chaque choix, si la mention majoritaire de ce choix est égale à la mention garder
             * en mémoire, alors on l'ajoute à la map tabResult.
             */
            if (entry.getValue() == mentionGagnante){
                tabResult.put(entry.getKey(),new ArrayList<Double>());
            }
        }

        /**
         * si la map tabResult contient plus que un élément, cela signifie qu'il y a une égalité et qu'il
         * faut départager ces choix restant
         */
        if (tabResult.size() > 1) {
            /**
             * on lance la méthode calculEcart qui permet de calculer les écarts pour les choix restants
             */
            struct.calculEcart(struct, mentionGagnante);
            /**
             * on lance la méthode getVainqueurAvecEgalite qui permet de récupérer le vainqueur meme avec
             * des égalités
             */
            res = struct.getVainqueurAvecEgalite(tabResult);

        }
        /**
         * sinon cela signifie que un choix à une meilleur mention majoritaire que tous les autres et donc
         * que c'est le vainqueur.
         */
        else {
            /**
             * on ajoute ce vainqueur à la map res
             */
            res.put(1,(Integer)tabResult.keySet().toArray()[0]);
            System.out.println("Le vainqueur est : " + tabResult.keySet().toArray()[0]);
        }
        /**
         * on retourne la map res
         */
        return res;
    }

    /**
     * Méthode permettant d'afficher les informations d'un objet StructureJugementMajoritaire sur la sortie écran
     * @return le string contenant l'affichage
     */
    @Override
    public String toString() {
        String concatTab = "";


        for (Map.Entry<Integer,ArrayList<Double>> entry : tabPourcentage.entrySet()){
            concatTab += "Choix n°" + entry.getKey() + " : " + entry.getValue() + " Mention Majoritaire : " + mentionMajoritaire.get(entry.getKey()) + "\n";
        }

        return  "Echelle à " + echelle + " niveaux \n" +
                concatTab;
    }
}
