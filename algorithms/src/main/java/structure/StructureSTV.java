package structure;

/**
 * Created by stephane on 29/05/17.
 */

import java.util.*;

/**
 * Classe permettant, à partir d'un objet Matrix de créer et conserver
 * les informations nécessaire à la réalisation d'un scrutin de type
 * STV
 */
public class StructureSTV {

    /**
     * Map permettant de lister les combinaisons présentent ainsi que leurs scores
     */
    private HashMap<String,Double> tabCombinaisons;

    /**
     * Map contenant le score de chaque choix. Le premier élément de la map correspond au premier choix
     */
    private HashMap<Byte,Double> tabScores;

    /**
     * Arraylist contenant les gagnants ordonée. Le premier élément est le gagnant ayant gagner en premier
     */
    private ArrayList<Byte> tabVainqueurs;

    /**
     * Arraylist contenant les perdants ordonée. Le premier élément est le perdant ayant perdu en premier
     */
    private ArrayList<Byte> tabPerdant;

    /**
     * Variable contenant le quota à atteindre.
     */
    Integer quota;

    /**
     * Variable contenant le nombre de choix dans le choix social.
     */
    int nbChoix;

    /**
     * variable permettant de connaître la méthode de calcul du quota.
     * 1 : Haare
     * 2 : autre
     */
    private int choixQuota;

    /**
     * Variable permettant de connaître la méthode de détermination du choix du perdant
     * 1 : le score le plus bas
     * 2 : le plus d'occurence en dernière position
     */
    private int choixPerdant;

    /**
     * Variable contenant le nombre de gagnant du choix social
     */
    int nbGagnant;

    /**
     * Constructeur à partir d'une Matrix d'une structure StructureSTV
     */
    public StructureSTV(Matrix mat, int choixQuota, int choixPerdant, int nbGagnant){
        this.choixQuota = choixQuota;
        this.choixPerdant = choixPerdant;
        this.tabCombinaisons = new HashMap<String,Double>();
        genererListeCombinaison(mat);
        if (choixQuota == 1){
            calculQuotaHare(mat.getVotants(), nbGagnant);
            System.out.println("Le quota à atteindre est : " + quota);
        }
        this.tabPerdant = new ArrayList<Byte>();
        this.tabVainqueurs = new ArrayList<Byte>();
        this.nbGagnant = nbGagnant;
        this.nbChoix = mat.getChoix();

    }

    /**
     * Getter permettant de récupérer, à condition qu'il ne soit pas NULL, le tableau
     * tabCombinaisons
     * @return : le tableau tabCombinaisons
     */
    public HashMap<String,Double> getTabCombinaisons() {
        if (tabCombinaisons != null){
            return tabCombinaisons;
        } else {
            return null;
        }
    }

    /**
     * Getter permettant de récupérer le tableau tabScores
     * @return : le tableau tabScores
     */
    public HashMap<Byte, Double> getTabScores() {
        return tabScores;
    }

    /**
     * Getter permettant de récupérer, à condition qu'il ne soit pas NULL, le tableau
     * tabVainqueurs
     * @return : le tableau tabVainqueurs
     */
    public ArrayList<Byte> getTabVainqueurs() {
        if (tabVainqueurs != null){
            return tabVainqueurs;
        } else {
            return null;
        }
    }

    /**
     * Getter permettant de récupérer, à condition qu'il ne soit pas NULL, le tableau
     * tabPerdant
     * @return : le tableau tabPerdant
     */
    public ArrayList<Byte> getTabPerdant() {
        if (tabPerdant != null){
            return tabPerdant;
        } else {
            return null;
        }
    }

    /**
     * Getter permettant de récupérer la variable quota
     * @return : la variable quota
     */
    public Integer getQuota() {
        return quota;
    }

    /**
     * Getter permettant de récupérer la variable choixQuota
     * @return : la variable choixQuota
     */
    public int getChoixQuota() {
        return choixQuota;
    }

    /**
     * Getter permettant de récupérer la variable choixPerdant
     * @return : la variable choixPerdant
     */
    public int getChoixPerdant() {
        return choixPerdant;
    }

    /**
     * Getter permettant de récupérer la variable nbGagnant
     * @return : la variable nbGagnant
     */
    public int getNbGagnant() {
        return nbGagnant;
    }

    /**
     * Getter permettant de récupérer la variable nbChoix
     * @return : la variable nbChoix
     */
    public int getNbChoix() {
        return nbChoix;
    }

    /**
     * Setter pour la variable nbChoix
     * @param nbChoix : valeur que l'on veut insérer
     */
    public void setNbChoix(int nbChoix) {
        this.nbChoix = nbChoix;
    }

    /**
     * Méthode permettant de générer, à partir d'une structure Matrix, la liste
     * des combinaisons de la matrice.
     * @param : l'objet Matrix contenant la matrice du choix social
     */
    public void genererListeCombinaison(Matrix mat) {
        /**
         * Variable permettant de stocker les combinaisons possibles
         */
        String concatTmp = "";
        /**
         * Variable booléenne permettant de signifier si la combinaison existe déja dans la liste
         */
        Boolean combinaisonTrouvee;
        /**
         * Variable temporaire permettant d'incrémenter le nombre d'occurence d'une combinaison
         */
        Double tmp;

        /**
         * dans le premier for, on parcours pour tous les votants
         */
        for (int i = 0; i<mat.getVotants() ; i++){
            /**
             * On réinitialise le string à vide afin de pouvoir créer une nouvelle combinaison
             */
            concatTmp = "";
            /**
             * dans le deuxième for, on parcours pour tous les choix
             */
            for (int j = 0; j<mat.getChoix();j++){
                /**
                 * on ajoute à la combinaison, chaque choix dans l'ordre,
                 */
                concatTmp += mat.getCase(j,i);
            }
            /**
             * initialisation et réinitialisation de la variable booléenne à false
             */
            combinaisonTrouvee=false;
            /**
             * set contenant les données, contenues dans la map tabCombinaison
             */
            Set<Map.Entry<String, Double>> entry = tabCombinaisons.entrySet();
            /**
             * iterator permettant de parcourir les différents élément contenus dans le set
             */
            Iterator<Map.Entry<String, Double>> iterator = entry.iterator();
            /**
             * tant que le set n'est pas parcouru en entier ou que la variable booléenne n'est pas à
             * true, on pourcourt le set
             */
            while (iterator.hasNext() && !combinaisonTrouvee) {
                /**
                 * déclaration d'un entry qui va correspondre au différent élément du set
                 */
                Map.Entry<String,Double> e = iterator.next();
                /**
                 * si la clé de l'élément est égale au string concatTmp, alors la combinaison est déjà
                 * présente dans la map.
                 * On passe le booléen a true.
                 * On incrémente la valeur de la combinaison.
                 */
                if (e.getKey().equals(concatTmp)){
                    combinaisonTrouvee =true;
                    tmp = e.getValue();
                    tmp += 1.0;
                    tabCombinaisons.put(concatTmp,tmp);
                }
            }
            /**
             * si la variable combinaisonTrouvee est toujours à false, c'est que l'on a parcouru toute la map
             * sans trouver la combinaison. Donc qu'il faut la rajouter. 
             */
            if (!combinaisonTrouvee) {
                tabCombinaisons.put(concatTmp,1.0);
            }
        }
        System.out.println("TabCombinaison : " + tabCombinaisons);
    }

    /**
     * Méthode permettant de calculer le quota à atteindre avec la méthode de Hare.
     * Quota = (nbVotants/(nbGagants+1))+1
     * @param nbVotants : le nombre de votants
     * @param nbGagants : le nombre de gagnants
     * @return : le quota calculé
     */
    public void calculQuotaHare(int nbVotants, int nbGagants){
        this.quota = (nbVotants/(nbGagants+1))+1;
    }

    /**
     * Méthode permettant de calculer le score de chaque choix en fonction des combinaisons.
     * @param struct : structure StructureSTV à mettre à jour.
     */
    public void calculScore(StructureSTV struct){


        /**
         * Variable temporaire servant à tester les clé
         */
        String tmpKey[];
        /**
         * Variable temporaire servant à incrémenter les valeurs contenue dans la map tabScore
         */
        Double tmpValue;


        this.tabScores = new HashMap<Byte, Double>();


        for (Byte i=1; i<=nbChoix; i++) {
            tabScores.put(i,0.0);
        }
        /**
         * for servant à parcourir tous les éléments de la map tabCombinaisons. Donc de parcourir toutes les
         * combinaisons présentent dans le choix sociale.
         */
        for (Map.Entry<String, Double> entry : tabCombinaisons.entrySet()){
            /**
             * On récupère le premier choix de chaque combinaisons
             */
            tmpKey = entry.getKey().split("");

            /**
             * On incrémente le score de ce choix du nombre de voix correspondant au nombre d'occurence de la
             * combinaison
             */
            tmpValue = tabScores.get(Byte.parseByte(tmpKey[0]));
            tmpValue += entry.getValue();
            tabScores.put(Byte.parseByte(tmpKey[0]),tmpValue);

        }
    }

    /**
     * Cette méthode va regarder si un choix à dépasser le quota nécessaire pour gagner et si oui agir en conséquence.
     * @param struct : structure StructureSTV à mettre à jour.
     */
    public void ronde(StructureSTV struct){
        /**
         * Variable servant à savoir si la taille du tableau de vainqueur à changé pendant la ronde, donc à savoir s'il
         * faut retirer un gagnant ou un perdant.
         */
        int tailleTabVainqueurs = 0;

        /**
         * Pour chaque choix, on vérifie si son score dépasse le quota requis ou non. S'il dépasse le quota, on
         * incrémente la variable tailleTabVainqueur pour signifier que l'on a trouver un nouveau vainqueur durant
         * cette ronde.
         */
        for (Map.Entry<Byte, Double> entry : tabScores.entrySet()) {
            if (entry.getValue() >= struct.getQuota()){
                tabVainqueurs.add(entry.getKey());
                tailleTabVainqueurs++;
            }
        }
        String tmpKey[];
        /**
         * Pour chaque combinaisons
         */
        for (Map.Entry<String, Double> entry: tabCombinaisons.entrySet()){
            /**
             * On split le clé, donc la combinaison.
             */
            tmpKey = entry.getKey().split("");
            /**
             * On test si le premier choix de chaque combinaison correspond à un choix ayant gagné. Si c'est le cas,
             * cela signifie qu'il faut calculer le surplus des scores de ces combinaisons.
             */
            for (int i=0; i<tabVainqueurs.size();i++){
                if (tabVainqueurs.get(i) == Byte.parseByte(tmpKey[0])){
                    /**
                     * On modifie la combinaison en changeant le score par le surplus de ce score calculer avec la
                     * méthode calculSurplus
                     */
                    tabCombinaisons.put(entry.getKey(),calculSurplus(entry.getValue(),tabScores.get(Byte.parseByte(tmpKey[0]))));
                }
            }
        }

        /**
         * si la tailleTabVainqueurs est différentes de 0, cela signifie qu'on a un nouveau vainqueurs et donc qu'il
         * faut rétirer du choix social un gagnant
         */
        if (tailleTabVainqueurs != 0){
            retirerChoix(tabVainqueurs);
        }
        /**
         * sinon, cela signifie qu'il faut retirer un perdant selon la méthode de sélection du perdant préalablement
         * défini.
         */
        else {
            determinationPerdant(choixPerdant);
            retirerChoix(tabPerdant);
        }

        System.out.println("TabVainqueur : " + tabVainqueurs);
        System.out.println("TabPerdant : " + tabPerdant);
        System.out.println("=============================================");

    }

    /**
     * Méthode permettant de calculer le surplus de voix d'une combinaison gagnante
     */
    public Double calculSurplus(Double nbVoixCombinaison, Double nbVoixChoix){
        Double surplus = nbVoixChoix - quota;
        return nbVoixCombinaison / nbVoixChoix * surplus;
    }

    /**
     * Méthode de détermination du perdant.
     * choix perdant = 1 : le perdant est le choix ayant le score le plus faible
     * choix perdant = 2 : le perdant est le choix que le retrouve le plus en dernière position des votes
     * @param choixPerdant : variable de déscion de la méthode du choix du perdant
     */
    public void determinationPerdant(int choixPerdant){
        if (choixPerdant == 1) {
            /**
             * Déclarations de valeurs tampons.
             */
            int cpt =0;
            Byte indiceMin=0;
            Double valeurMin = (double) quota;
            Boolean dejaVainqueur;
            Boolean dejaPerdant;
            /**
             * Parcours chaque élément de la map tabScores
             */
            for (Map.Entry<Byte, Double> entry : tabScores.entrySet()) {
                /**
                 * On vérifie que le choix ne fait pas deja partie d'un choix ayant gagné.
                 */
                dejaVainqueur = false;
                for (int j = 0; j<tabVainqueurs.size();j++) {
                    if ( entry.getKey() == tabVainqueurs.get(j)){
                        dejaVainqueur = true;
                    }
                }
                /**
                 * On vérifie que le choix ne fait pas deja partie d'un choix ayant perdu.
                 */
                dejaPerdant = false;
                for (int j = 0; j<tabPerdant.size();j++) {
                    if (entry.getKey() == tabPerdant.get(j)){
                        dejaPerdant = true;
                    }
                }
                /**
                 * S'il n'est pas ni deja gagnant, ni deja perdant, et que son score est plus petit que
                 * celui enregistrer dans les mémoire tampons. Alors on stocke dans les valeurs tamponsles
                 * nouvelles valeurs.
                 */
                if (!dejaVainqueur && !dejaPerdant && entry.getValue() < valeurMin){
                    indiceMin = entry.getKey();
                    valeurMin = entry.getValue();
                }
            }
            /**
             * On ajoute dans le tableau tabPerdant l'indice du choix ayant le score le plus bas.
             */
            tabPerdant.add(indiceMin);
        } else if (choixPerdant == 2){
            /**
             * Déclarationd de variables tampons. Le tableau occurences sert à comptabiliser le nombre de fois
             * ou un choix est en dernière position dans une combinaison.
             */
            ArrayList<Integer> occurences = new ArrayList<Integer>();
            String tmpKey[];
            Integer tmpOccur;
            /**
             * On initialise le tableau occurences à 0 dans chaque case.
             */
            for (int i = 0; i<=nbChoix;i++){
                occurences.add(i,0);
            }
            /**
             * On parcours toutes les combinaisons et incrémente dans le tableau occurences la case correspondant au
             * choix en dernière position.
             */
            for (Map.Entry<String, Double> entry: tabCombinaisons.entrySet()) {
                tmpKey = entry.getKey().split("");
                tmpOccur = occurences.get(Integer.parseInt(tmpKey[(tmpKey.length - 1)]));
                tmpOccur++;
                occurences.remove(Integer.parseInt(tmpKey[tmpKey.length - 1]));
                occurences.add(Integer.parseInt(tmpKey[tmpKey.length - 1]),tmpOccur);
            }

            /**
             * On déclare des variables tampons qui nous serviront à savoir quelle choix à la plus d'occurences.
             */
            Byte indiceMin = 0;
            Boolean dejaVainqueur;
            Boolean dejaPerdant;
            int occurMin = tabCombinaisons.size()+1;
            /**
             * On parcours tous les choix.
             */
            for (Byte i=1; i<=nbChoix;i++){
                /**
                 * On vérifie que le choix n'est pas deja présent dans le tableau des vainqueurs
                 */
                dejaVainqueur = false;
                for (int j = 0; j<tabVainqueurs.size();j++) {
                    if ( i == tabVainqueurs.get(j)){
                        dejaVainqueur = true;
                    }
                }
                /**
                 * On vérifie que le choix n'est pas deja présent dans le tableau des perdants
                 */
                dejaPerdant = false;
                for (int j = 0; j<tabPerdant.size();j++) {
                    if (i == tabPerdant.get(j)){
                        dejaPerdant = true;
                    }
                }
                /**
                 * Si le choix n'a pas deja gagné ni perdu et qu'il a plus d'occurence, on stocke ces valeurs
                 * dans les variables tampons.
                 */
                if (!dejaVainqueur && !dejaPerdant && occurences.get(i) < occurMin) {
                    occurMin = occurences.get(i);
                    indiceMin = i;
                }

            }
            /**
             * On ajoute dans le tableau des perdants l'indice du choix stocké.
             */
            tabPerdant.add(indiceMin);
        }

    }

    /**
     * Méthode permettant de rétirer un choix ayant soit perdu, soit gagné de la liste des combinaisons.
     * @param tabChoixARetirer : tableau avec les choix à retirer
     */
    public void retirerChoix(ArrayList<Byte> tabChoixARetirer) {
        /**
         * Déclaration de variables qui serviront de valeurs tampons
         */
        String concat;
        String tmpKey[];
        Double tmpValue;
        Boolean gagnantTrouve;
        Boolean combinaisonExistante;

        /**
         * Map contenant les nouvelles combinaisons
         */
        HashMap<String, Double> tmpMap = new HashMap<String, Double>();

        /**
         * On parcours chaque combinaisons
         */
        for (Map.Entry<String, Double> entry: tabCombinaisons.entrySet()){
            /**
             * On réinitialise la variable concat à vide et la variable tmpKey à la clé de l'élément courant séparer
             * caractère par caractère.
             */
            concat ="";
            tmpKey = entry.getKey().split("");
            /**
             * On parcours chaque caractère de la clé de l'élément.
             */
            for (int i=0; i<tmpKey.length;i++){
                /**
                 * On réinitialise la variable booléenne gagnantTrouve à false
                 */
                gagnantTrouve = false;
                /**
                 * On parcours le tableau passé en paramètre
                 */
                for (int j = 0; j < tabChoixARetirer.size(); j++){
                    /**
                     * Si la valeur n'a pas déjà été identifier comme une des valeur a retirer et qu'elle est égale
                     * à la valeur contenue dans le tableau passé en paramètre, alors on la supprime.
                     */
                    if (!gagnantTrouve && Byte.parseByte(tmpKey[i]) == tabChoixARetirer.get(j)){
                        tmpKey[i] = "";
                        gagnantTrouve = true;
                    }
                }
                /**
                 * on ajoute a la concaténation la valeur sortante, soit elle n'a pos changé, soit elle a été remplacer
                 * par du vide.
                 */
                concat += tmpKey[i];
            }

            /**
             * Si la map des nouvelles combinaisons n'est pas vide.
             */
            if (tmpMap.size() != 0) {
                /**
                 * On réinitialise la variable booléenne combinaisonExistante à false;
                 */
                combinaisonExistante = false;

                /**
                 * set contenant les données, contenues dans la map tmpMap
                 */
                Set<Map.Entry<String, Double>> entry1 = tmpMap.entrySet();
                /**
                 * iterator permettant de parcourir les différents élément contenus dans le set
                 */
                Iterator<Map.Entry<String, Double>> iterator = entry1.iterator();
                /**
                 * tant que le set n'est pas parcouru en entier ou que la variable booléenne n'est pas à
                 * true, on pourcourt le set
                 */
                while (iterator.hasNext() && !combinaisonExistante) {
                    /**
                     * déclaration d'un entry qui va correspondre au différent élément du set
                     */
                    Map.Entry<String,Double> e = iterator.next();
                    /**
                     * si la clé de l'élément est égale à la concaténation, cela signifie qu'il faut ajouter le score
                     * à cette combinaison déjà existante
                     */
                    if (e.getKey().equals(concat)){
                        combinaisonExistante = true;
                        tmpValue = e.getValue();
                        tmpValue += tabCombinaisons.get(entry.getKey());
                        tmpMap.put(concat, tmpValue);
                    }
                }
                /**
                 * Si la combinaison n'existe pas encore, il faut la rajouter a la map tmpMap
                 */
                if (!combinaisonExistante) {
                    tmpValue = tabCombinaisons.get(entry.getKey());
                    tmpMap.put(concat,tmpValue);
                }
            }
            /**
             * Si la map tmpMap n'a pas d'élément, alors il faut en créer un nouveau.
             */
            else {
                tmpValue = tabCombinaisons.get(entry.getKey());
                tmpMap.put(concat,tmpValue);
            }
        }
        /**
         * On réinitialise la map tabCombinaison à vide.
         */
        tabCombinaisons.clear();
        /**
         * On la rempli avec les nouvelles combinaisons contenues dans tmpMap
         */
        for (Map.Entry<String, Double> entry : tmpMap.entrySet()) {
            tabCombinaisons.put(entry.getKey(),entry.getValue());
        }
        /**
         * On clear tmpMap
         */
        tmpMap.clear();
    }

}
