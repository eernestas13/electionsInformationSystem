public class ElectionNode {
    private Election election;
    private ElectionNode nextNode;

    /**
     * Election to be added to ElectionNode
     * @param election - User Specified Election to be added to ElectionNode
     */
    public ElectionNode (Election election) {
        this.setElection(election);
    }

    /**
     * Sets the Next Node in the ElectionList
     * @param nextNode - Node to be set as Next Node in ElectionList
     */
    /*Setters*/
    public void setNextNode(ElectionNode nextNode) {
        this.nextNode = nextNode;
    }

    /**
     * Sets User Specified Election
     * @param election - User Specified Election
     */
    public void setElection(Election election) {
        this.election = election;
    }

    /**
     * Gets the Next Node in the ElectionList
     * @return nextNode - Next Node in ElectionList
     */
    /*Getters*/
    public ElectionNode getNextNode() {
        return nextNode;
    }

    public Election getElection() {
        return election;
    }
}
