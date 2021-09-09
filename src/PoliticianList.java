public class PoliticianList {
    private PoliticianNode head;
    private PoliticianNode tail;

    /**
     * Adds User Specified PoliticianNode to the PoliticianList
     *
     * @param politicianNode - User Specified PoliticianNode to be added to PoliticianList
     */
    public void addPolitician(PoliticianNode politicianNode) {
        if (tail == null) {
            head = politicianNode;
        } else {
            tail.setNextNode(politicianNode);
        }
        tail = politicianNode;
    }

    /**
     * Finds User Specified Politician
     *
     * @param lastName - User Specified Last Name of Politician to be found
     * @return a.getPolitician - Null if Property cannot be found
     * Found Politician Object if Politician is Found
     */
    public Politician findPolitician(String lastName) {
        if (head == null) {
            System.out.println("Empty List");
            return null;
        } else {
            PoliticianNode a = head;
            while ((a != null) && (!a.getPolitician().getLastName().equals(lastName))) {
                a = a.getNextNode();
            }
            return a.getPolitician();
        }
    }

    public PoliticianNode getHead() {
        return head;
    }

    /**
     * Deletes User Specified PoliticianNode from PoliticianList
     *
     * @param lastName - User Specified LastName of PoliticianNode to be Deleted
     * @return - 0 if Deleting the Found Politician would result in an Error
     * 1 if the Politician was Successfully Deleted
     */
    public void deletePolitician(String lastName) {
        PoliticianNode temp = head;
        PoliticianNode previous = null;
        if (temp != null && temp.politician.getLastName().equals(lastName)) {
            head = temp.nextNode;
            return;
        }
        while (temp != null && !temp.getPolitician().getLastName().equals(lastName)) {
            previous = temp;
            temp = temp.nextNode;
        }
        if (temp == null) {
            return;
        }
        previous.nextNode = temp.nextNode;
    }
    public PoliticianNode merge(PoliticianNode x,PoliticianNode y){
        PoliticianNode sorted=null;
        if (x==null){
            return y;
        }
        if (y==null){
            return x;
        }
        if(x.getPolitician().getLastName().compareTo(y.getPolitician().getLastName())<0){
            sorted=x;
            sorted.setNextNode(merge(x.getNextNode(),y));
        }
        else{
            sorted = y;
            sorted.setNextNode(merge(x,y.getNextNode()));
        }
        return sorted;
    }
    public PoliticianNode mergeSort(PoliticianNode head){
        if ((head==null) || (head.getNextNode()==null)){
            return head;
        }
        PoliticianNode middle = findMiddle(head);
        PoliticianNode nextMiddle=findMiddle(middle.getNextNode());
        middle.setNextNode(null);
        //Merge sort stops
        PoliticianNode left = mergeSort(head);
        PoliticianNode right= mergeSort(nextMiddle);
        PoliticianNode sorted=merge(left,right);
        return sorted;
    }
    /**
     * Hare moves at twice the speed than the turtle. When the hare reaches the end of the list
     * the turtle is in the middle;
     * @param head head of list
     * @return turtle value
     */
    public PoliticianNode findMiddle(PoliticianNode head){
        if (head==null){
            return head;
        }
        PoliticianNode turtle=head;
        PoliticianNode hare=head;
        while(hare.getNextNode()!=null && hare.getNextNode().getNextNode()!=null){
            turtle=turtle.getNextNode();
            hare=hare.getNextNode().getNextNode();
        }
        return turtle;
    }
}

