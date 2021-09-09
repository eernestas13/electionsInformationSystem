import org.junit.Test;

public class MergeSortTest {
    @Test
    public void Test(){
        Election election1=new Election("General","Wexford",2000,50);
        Election election2= new Election("General","Wexford",1999,20);
        Election election3=new Election("Presidental","Dublin",2002,1);
        ElectionNode electionNode1=new ElectionNode(election2);
        ElectionNode electionNode2=new ElectionNode(election3);
        ElectionNode electionNode3=new ElectionNode (election1);
        ElectionList electionList=new ElectionList();
        electionList.addElection(electionNode1);
        electionList.addElection(electionNode2);
        electionList.addElection(electionNode3);
        System.out.println(electionList.head.getElection().getElectionType());
        System.out.println(electionList.head.getNextNode().getElection().getElectionType());
        System.out.println(electionList.head.getNextNode().getNextNode().getElection().getElectionType());
        electionList.head=electionList.mergeSort(electionList.head);
        System.out.println(electionList.head.getElection().getElectionType());
        System.out.println(electionList.head.getNextNode().getElection().getElectionType());
        System.out.println(electionList.head.getNextNode().getNextNode().getElection().getElectionType());

    }
}
