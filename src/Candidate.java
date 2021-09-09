public class Candidate {
    private Politician politician;
    private int totalVotes;
    //something for party history


    /**
     * Constructor
     */
    public Candidate (){}
    public Candidate(Politician politician,int totalVotes){
        this.setPolitician(politician);
        this.setTotalVotes(totalVotes);

    }

    /**
     * Sets Politician
     * @param politician - Politician
     */
    /*Setters*/
    public void setPolitician(Politician politician) {
        this.politician = politician;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    /**
     * Gets User Specified Politician
     * @return - User Specified Politician
     */
    /*Getters*/
    public Politician getPolitician() {
        return politician;
    }

    /**
     * Gets Total Votes
     * @return - Total Votes
     */
    public int getTotalVotes() {
        return totalVotes;
    }
}
