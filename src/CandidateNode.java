public class CandidateNode {
    Candidate candidate;
    CandidateNode nextNode;

    public CandidateNode(Candidate candidate){
        this.setCandidate(candidate);
    }
    /*Setters*/
    public void setNextNode(CandidateNode nextNode) {
        this.nextNode = nextNode;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
    /*Getters*/
    public CandidateNode getNextNode() {
        return nextNode;
    }

    public Candidate getCandidate() {
        return candidate;
    }
}