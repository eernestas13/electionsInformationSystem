public class ElectionList {
    ElectionNode head;
    ElectionNode tail;

    /**
     * Adds User Specified ElectionNode to the ElectionList
     *
     * @param electionNode - User Specified ElectionNode to be added to ElectionList
     */
    public void addElection(ElectionNode electionNode) {
        if (tail == null) {
            head = electionNode;
        } else {
            tail.setNextNode(electionNode);
        }
        tail = electionNode;
    }

    /**
     * Finds User Specified Election
     *
     * @param typeOfElection - User Specified Election Type to be found
     * @param location       - User Specified Location of Election to be found
     * @return - Null if Property cannot be found
     * Found Election Object if Election is Found
     */
    public Election findElection(String typeOfElection, String location) {
        if (head == null) {
            System.out.println("Empty List");
            return null;
        } else {
            ElectionNode a = head;
            while ((a != null) && (a.getElection().getElectionType() != typeOfElection) && (a.getElection().getLocation() != location)) {
                a = a.getNextNode();
            }
            return a.getElection();
        }
    }

    /**
     * Deletes User Specified ElectionNode from ElectionList
     *
     * @param typeOfElection - User Specified Election Type to be to be Deleted
     * @param location       - User Specified Location of Election to be Deleted
     * @return - 0 if Deleting the Found Election would result in an Error
     * 1 if the Election was Successfully Deleted
     */
    public void deleteElection(String typeOfElection, String location) {
        ElectionNode temp = head;
        ElectionNode previous = null;
        if ((temp != null) && (temp.getElection().getElectionType() == typeOfElection) && temp.getElection().getLocation() == location) {
            head = temp.getNextNode();
            return;
        }
        while ((temp != null) && (temp.getElection().getElectionType() != typeOfElection) && (temp.getElection().getLocation() != location)) {
            previous = temp;
            temp = temp.getNextNode();

        }
        if (temp == null) {
            return;
        }
        previous.setNextNode(temp.getNextNode());
    }
    public ElectionNode merge(ElectionNode x,ElectionNode y){
        ElectionNode sorted;
        if (x==null){
            return y;
        }
        if (y==null){
            return x;
        }
        if(x.getElection().getElectionType().compareTo(y.getElection().getElectionType())<0){
            sorted=x;
            sorted.setNextNode(merge(x.getNextNode(),y));
        }
        else{
            sorted = y;
            sorted.setNextNode(merge(x,y.getNextNode()));
        }
        return sorted;
    }
    public ElectionNode mergeSort(ElectionNode head){
        if ((head==null) || (head.getNextNode()==null)){
            return head;
        }
        ElectionNode middle = findMiddle(head);
        ElectionNode nextMiddle=findMiddle(middle.getNextNode());
        middle.setNextNode(null);
        //Merge sort stops
        ElectionNode left = mergeSort(head);
        ElectionNode right= mergeSort(nextMiddle);
        ElectionNode sorted=merge(left,right);
        return sorted;
    }
    /**
     * Hare moves at twice the speed than the turtle. When the hare reaches the end of the list
     * the turtle is in the middle;
     * @param head head of list
     * @return turtle value
     */
    public ElectionNode findMiddle(ElectionNode head){
        if (head==null){
            return head;
        }
        ElectionNode turtle=head;
        ElectionNode hare=head;
        while(hare.getNextNode()!=null && hare.getNextNode().getNextNode()!=null){
            turtle=turtle.getNextNode();
            hare=hare.getNextNode().getNextNode();
        }
        return turtle;
    }

}

