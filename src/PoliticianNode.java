public class PoliticianNode {
    Politician politician;
    PoliticianNode nextNode;

    /**
     * Politician to be added to PoliticianNode
     * @param politician - User Specified Poltician to be added to PoliticianNode
     */
    public PoliticianNode(Politician politician){
        this.setPolitician(politician);
    }

    /**
     * Sets the Next Node in the PolticianList
     * @param nextNode - Node to be set as Next Node in PoliticianList
     */
    /*Setters*/
    public void setNextNode(PoliticianNode nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Sets User Specified Politician
     * @param politician - User Specified Politician
     */
    public void setPolitician(Politician politician) {
        this.politician = politician;
    }
    /*Getters*/

    /**
     * Gets the Next Node in the PoliticianList
     * @return nextNode - Next Node in PoliticianList
     */
    public PoliticianNode getNextNode() {
        return nextNode;
    }

    /**
     * Gets User Specified Politician
     * @return politician - User Specified Politician
     */
    public Politician getPolitician() {
        return politician;
    }
}

