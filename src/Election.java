public class Election {
    private CandidateList candidateList= new CandidateList();
    private String electionType;
    private String location;
    private int date;
    private int numSeats;

    /**
     * Constructor
     */
    public  Election(String electionType, String location,int date,int numSeats,CandidateList candidateList){

        this.setElectionType(electionType);
        this.setLocation(location);
        this.setDate(date);
        this.setNumSeats(numSeats);
        this.setCandidateList(candidateList);
    }

    public  Election(String electionType, String location,int date,int numSeats){

        this.setElectionType(electionType);
        this.setLocation(location);
        this.setDate(date);
        this.setNumSeats(numSeats);
    }

    /*Setters*/

    /**
     * Sets CandidateList For this Candidate
     * @param candidateList - candidateList for this Election
     */
    public void setCandidateList(CandidateList candidateList) {
        this.candidateList = candidateList;
    }

    /**
     * Sets Election Type For this Election
     * @param electionType - Election Type for this Election
     */
    public void setElectionType(String electionType) {
        this.electionType = electionType;
    }

    /**
     * Sets Location For this Election
     * @param location - Location for this Election
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Sets Date For the Election
     * @param date - Date for the Election
     */
    public void setDate(int date) {
        this.date = date;
    }

    /**
     * Gets How many Car Spaces this Property Has
     * @return - Number of Car Spaces at this Property
     */
    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    /*Getters*/

    public CandidateList getCandidateList() {
        return candidateList;
    }

    /**
     * Gets the Election Type
     * @return electionType - Election type for this Election
     */
    public String getElectionType() {
        return electionType;
    }

    /**
     * Gets Location for the Election
     * @return location - The Location for this Election
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets Date for the Election
     * @return date - The date for the Election
     */
    public int getDate() {
        return date;
    }

    /**
     * Gets How many Seat Spaces this Election Has
     * @return numSeats - Number of Seat Spaces at this Election
     */
    public int getNumSeats() {
        return numSeats;
    }
    //Will change to driver.
    public String checkElectionType(String electionType){
        electionType.toUpperCase();
        if (electionType.contains("GENERAL")){
            electionType=("General");
        }
        else if(electionType.contains("PRESIDENTIAL")){
            electionType=("Presidential");
        }
        else if (electionType.contains("LOCAL")){
            electionType=("Local");
        }
        else if(electionType.contains("European")){
            electionType=("European");
        }
        return electionType;
    }
    public int compareTo(Election election){
        return this.getElectionType().compareTo(election.getElectionType());
    }

}

