public class CandidateList {
    CandidateNode head;
    CandidateNode tail;

    /**
     * Adds User Specified CandidateNode to CandidateList
     * @param candidateNode - User Specified CandidateNode to be added to CandidateList
     */
    public void addCandidate(CandidateNode candidateNode){
        if(tail==null){
            head = candidateNode;
        } else{
            tail.setNextNode(candidateNode);
        }
        tail=candidateNode;
    }

    /**
     * Deletes User Specified CandidateNode from CandidateList
     * @param lastName - User Specified lastName of CandidateNode to be Deleted
     */
    public void deleteCandidate(String lastName){
        CandidateNode temp=head;
        CandidateNode previous=null;
        if (temp!=null&& temp.getCandidate().getPolitician().getLastName().equals(lastName)){
            head=temp.nextNode;
            return;
        }
        while (temp != null && !temp.getCandidate().getPolitician().getLastName().equals(lastName)){
            previous=temp;
            temp=temp.nextNode;
        }
        if (temp==null){
            return;
        }
        previous.nextNode = temp.nextNode;
    }

    /**
     * Finds User Specified Candidate
     * @param lastName - User Specified lastName of Candidate to be found
     * @return - Null if Candidate cannot be found
     *           Found Candidate Object if Candidate is Found
     */
    public Candidate findCandidate (String lastName) {

        if (head == null) {
            System.out.println("No such Candidates in System");
            return null;
        }
        else {
            CandidateNode temp = head;
            while ((temp != null) && (temp.getCandidate().getPolitician().getLastName().equals(lastName))) {
                temp = temp.getNextNode();
            }
            return temp.getCandidate();
        }
    }



}

