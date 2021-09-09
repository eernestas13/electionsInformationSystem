import org.junit.Test;

public class HashTableTesting {
    @Test
    public void Test(){
        HashTable<PoliticianList> hashTable=new HashTable(10);
        PoliticianList politicianList0=new PoliticianList();
        PoliticianList politicianList1=new PoliticianList();
        PoliticianList politicianList2=new PoliticianList();
        PoliticianList politicianList3=new PoliticianList();
        PoliticianList politicianList4=new PoliticianList();
        PoliticianList politicianList5=new PoliticianList();
        PoliticianList politicianList6=new PoliticianList();
        PoliticianList politicianList7=new PoliticianList();
        hashTable.add(politicianList0,0);
        hashTable.add(politicianList1,1);
        hashTable.add(politicianList2,2);
        hashTable.add(politicianList3,3);
        hashTable.add(politicianList4,4);
        hashTable.add(politicianList5,5);
        hashTable.add(politicianList6,6);
        hashTable.add(politicianList7,7);

        Politician politician1= new Politician("Aaron","Russell","Sinn Fein","Wexford","Blank");
        Politician politician2= new Politician();
        Politician politician3= new Politician();
        PoliticianNode politicianNode=new PoliticianNode(politician1);
        PoliticianNode politicianNode1= new PoliticianNode(politician2);
        int politicianKey=politician1.getLastName().length()%hashTable.hashTable.length;
        System.out.println(politicianKey);
        hashTable.hashTable[politicianKey].value.addPolitician(politicianNode);
        System.out.println(hashTable.hashTable[politicianKey].value);
        System.out.println(hashTable.hashTable[politicianKey].value.findPolitician("Russell").getLastName());
        int option =1;

        }

    }
