import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    private Scanner input;
    private ElectionList electionList = new ElectionList();
    private PoliticianList politicianList=new PoliticianList();
    private PoliticianList politicianList0 = new PoliticianList();
    private PoliticianList politicianList1 = new PoliticianList();
    private PoliticianList politicianList2 = new PoliticianList();
    private PoliticianList politicianList3= new PoliticianList();
    private PoliticianList politicianList4= new PoliticianList();
    private PoliticianList politicianList5= new PoliticianList();
    private PoliticianList politicianList6= new PoliticianList();
    private PoliticianList politicianList7 = new PoliticianList();
    private PoliticianList politicianList8= new PoliticianList();
    private PoliticianList politicianList9 =new PoliticianList();
    private HashTable<PoliticianList> politicianListHashTable = new HashTable(10);


    public Driver() {
        input = new Scanner(System.in);
    }
    /**
     * Starts the Application
     */
    public static void main(String[] args) throws Exception {
        Driver app = new Driver();
        app.populateHash();
        app.runMenu();
    }
    /**
     * Prints the Main Menu to the console for the user
     */
    private int startMenu() {
        System.out.println("            Hello               ");
        System.out.println("--------------------------------");
        System.out.println("Select an option.");
        System.out.println("1) Add a new Politician");
        System.out.println("2) Add a new Election");
        System.out.println("3) Add a new Candidate");
        System.out.println("--------------------------------");
        System.out.println("4) Search / Filter Elections");
        System.out.println("5) Search / Filter Politicians");
        System.out.println("--------------------------------");
        System.out.println("6) Open Editing");
        System.out.println("7) Open deletion");
        System.out.println("---------------------------------");
        System.out.println("9) Save");
        System.out.println("10) Load");
        System.out.println("0)Exit");
        System.out.print("====>");
        int option = 0;
        try {
            option = input.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input was not a number please try again");
            input.next();
            startMenu();
        }
        if (option >= 0 && option <= 12) {
            return option;
        } else {
            System.out.println("Invalid Selection");
            return startMenu();
        }
    }
    /**
     * Controls the Menus and moves between different menus depending on the user input
     */
    private void runMenu() throws Exception {
        int option = startMenu();
        input.nextLine();
        while (option != 0) {
            switch (option) {
                case 1:
                    addPoliticianMenu();
                    break;
                case 2:
                    addElectionMenu();
                    break;
                case 3:
                    addCandidateMenu();
                    break;
                case 4:
                    int optionSFE = searchElectionMenu();
                    switch (optionSFE) {
                        case 1:
                            sortElectionsByElectionType();
                            break;
                        case 2:
                            //some search
                            break;
                        case 3:
                            //some search
                            break;
                    }
                    break;
                case 5:
                    int optionSearch = searchPoliticianMenu();
                    switch (optionSearch) {
                        case 1:
                            searchForPoliticianLastName();
                            break;
                        case 2:
                            sortPoliticiansByLastName();
                            break;
                        case 3:
                            //some search
                            break;
                    }
                    break;
                case 6:
                    int optionEdit = editMenu();
                    switch (optionEdit) {
                        case 1:
                            editPolitician();
                            break;
                        case 2:
                            editCandidate();
                            break;
                        case 3:
                            editElection();
                            break;
                    }
                    break;
                case 7:
                    int optionDel = deletionMenu();
                    switch (optionDel) {
                        case 1:
                            deletePolitician();
                            break;
                        case 2:
                            deleteElection();
                            break;
                        case 3:
                            deleteCandidate();
                            break;
                        case 0:
                            startMenu();
                            break;
                    }


            break;
            case 9:
                save();
                break;
            case 10:
                load();
            break;

            case 0:
                System.exit(0);
                break;
        }
        System.out.println("Press any key to continue...");
        input.nextLine();
        input.nextLine();
        option = startMenu();
    }
}
    /**
     * Opens the Delete Menu
     */
    private int deletionMenu() {
        System.out.println("Deletion Menu");
        System.out.println("-----------");
        System.out.println("Select an option");
        System.out.println("1)Delete a Politician");
        System.out.println("2)Delete a Election");
        System.out.println("3)Delete a Candidate");
        System.out.println("0) Exit");
        System.out.print("====>");
        int option = input.nextInt();
        if ((option > 0 && option < 5)) {
            System.out.println("Invalid input try again");
            return deletionMenu();
        } else {
            return option;
        }
    }
    /**
     * Opens the Search Election Menu
     */
    private int searchElectionMenu() {
        System.out.println("Search/Filter Elections");
        System.out.println("------------------------");
        System.out.println("Select an option");
        System.out.println("1) Sort by Election Type");
        System.out.println("2) INSERT TYPE OF SEARCH");
        System.out.println("3) INSERT TYPE OF SEARCH");
        System.out.println("ETC");
        System.out.println("0) Exit");
        System.out.print("====>");
        int option = input.nextInt();
        if ((option > 0 && option < 4)) {
            System.out.println("Invalid input try again");
            return searchElectionMenu();
        } else {
            return option;
        }
    }
    /**
     * Opens the Search Politician Menu
     */
    private int searchPoliticianMenu() {
        System.out.println("Search/Filter Politicians");
        System.out.println("------------------------");
        System.out.println("Select an option");
        System.out.println("1) Search for Politician");
        System.out.println("2) Sort Politicians by Last Name");
        System.out.println("3) INSERT TYPE OF SEARCH");
        System.out.println("ETC");
        System.out.println("0) Exit");
        System.out.print("====>");
        int polOption = input.nextInt();
        System.out.println(polOption);
        if ((polOption >= 0) &&  ((polOption<=4))){
            return polOption;
        } else {
            return searchPoliticianMenu();
        }
    }
    /**
     * Opens the Edit Menu
     */
    private int editMenu() {
        System.out.println("Edit Menu");
        System.out.println("---------");
        System.out.println("Select an option");
        System.out.println("1) Edit Politician");
        System.out.println("2) Edit Candidate");
        System.out.println("3) Edit Election");
        System.out.println("0) Exit");
        System.out.print("=====>");
        int option = input.nextInt();
        if (option > 0 && option < 3) {
            System.out.println("Invalid input try again");
            return editMenu();
        } else {
            return option;
        }
    }
    /* Used for just linked list
    private void addPoliticianMenu() {
    System.out.println("Enter the first name of the politician");
    String firstName=input.nextLine();
    if ((firstName.length()>0)&&(firstName.length()<=30)) {
        System.out.println("Enter the last name of the politician");
        String lastName = input.nextLine();
        if ((lastName.length()>0) && (lastName.length()<=30)){
            System.out.println("Enter the party the politician belongs to");
            String party = input.nextLine();
            checkPoliticalParty(party);
            System.out.println("Enter the the home location of the politician");
            String homeCounty = input.nextLine();
            System.out.println("Enter the img URL of the politician");
            String imgURL = input.nextLine();
            Politician politician = new Politician(firstName, lastName, party, homeCounty, imgURL);
            PoliticianNode politicianNode = new PoliticianNode(politician);
            politicianList.addPolitician(politicianNode);
            System.out.println("Politician entered successfully...Press enter to continue");
            input.nextInt();
        }
        else{
            System.out.println("Invalid last name must be between 0 and 30 chars");
        }
    }
    else{
        System.out.println("Invalid first name, must be more than 0 chars and less than 30");
        addPoliticianMenu();
    }
    }
    */
    /**
     * Opens the Add Politician Menu
     */
    public void addPoliticianMenu(){
        input.nextLine();
        System.out.println("Enter the first name of the politician");
        String firstName=input.nextLine();
        if ((firstName.length()>0)&&(firstName.length()<=30)) {
            System.out.println("Enter the last name of the politician");
            String lastName = input.nextLine();
            if ((lastName.length()>0) && (lastName.length()<=30)){
                System.out.println("Enter the party the politician belongs to");
                String party = input.nextLine();
                checkPoliticalParty(party);
                System.out.println("Enter the the home location of the politician");
                String homeCounty = input.nextLine();
                System.out.println("Enter the img URL of the politician");
                String imgURL = input.nextLine();
                Politician politician = new Politician(firstName, lastName, party, homeCounty, imgURL);
                PoliticianNode politicianNode = new PoliticianNode(politician);
                int polKey= politician.getLastName().length()%politicianListHashTable.hashTable.length;
                System.out.println(polKey);
                politicianListHashTable.hashTable[polKey].value.addPolitician(politicianNode);
                System.out.println("Politician entered successfully...Press enter to continue");
                input.nextLine();
            }
            else{
                System.out.println("Invalid last name must be between 0 and 30 chars");
            }
        }
        else{
            System.out.println("Invalid first name, must be more than 0 chars and less than 30");
            addPoliticianMenu();
        }
    }

    /**
     * Opens the Add Election Menu
     */
    private void addElectionMenu() {
        input.nextLine();
        System.out.println("Enter election type");
        String electionType = input.nextLine();
        System.out.println("Location of election");
        String location = input.nextLine();
        System.out.println("Enter date of election (Year)");
        int date = input.nextInt();
        System.out.println("Enter number of seats");
        int numOfSeats = input.nextInt();
        Election election = new Election(electionType, location, date, numOfSeats);
        ElectionNode electionNode = new ElectionNode(election);
        electionList.addElection(electionNode);
        input.nextLine();
    }
    /**
     * Opens the Add Candidate Menu
     */
    private void addCandidateMenu() {
        input.nextLine();
        System.out.println("Enter the type of election you wish to enter the candidate in");
        String typeOfElection = input.nextLine();
        System.out.println("Enter the location of the election");
        String location = input.nextLine();
        System.out.println("Enter the name of the politician to add to candidate");
        String lastName = input.nextLine();
        Politician politician = (politicianList.findPolitician(lastName));
        System.out.println("Enter num of votes gained for politician");
        int numOfVotes = input.nextInt();
        Candidate candidate = new Candidate(politician, numOfVotes);
        CandidateNode candidateNode = new CandidateNode(candidate);
        electionList.findElection(typeOfElection, location).getCandidateList().addCandidate(candidateNode);


    }
    /**
     * Opens the Edit Politician Menu
     */
    private void editPolitician() {
        System.out.println("Enter the last name of the politician you wish to edit");
        String lastName=input.nextLine();
        politicianList.deletePolitician(lastName);
        System.out.println("Enter the updated first name of politician");
        String firstName=input.nextLine();
        System.out.println("Enter the updated last name of politician");
        lastName=input.nextLine();
        System.out.println("Enter the updated political party");
        String politicalParty=input.nextLine();
        politicalParty=checkPoliticalParty(politicalParty);
        System.out.println("Enter the updated home county");
        String homeCounty=input.nextLine();
        System.out.println("Enter the updated IMG URL");
        String imgURL=input.nextLine();
        Politician politician = new Politician(firstName,lastName,politicalParty,homeCounty,imgURL);
        PoliticianNode politicianNode = new PoliticianNode(politician);
        int polKey = politician.getLastName().length()%politicianListHashTable.hashTable.length;
        politicianListHashTable.hashTable[polKey].value.addPolitician(politicianNode);

    }
    /**
     * Opens the Edit Candidate Menu
     */
    private void editCandidate() {
        System.out.println("Enter the type of election the candidate was in");
        String typeOfElection=input.nextLine();
        System.out.println("Enter the location of election");
        String location=input.nextLine();
        System.out.println("Enter the last name of the politician you wish to edit");
        String lastName=input.nextLine();
        CandidateNode temp=electionList.findElection(typeOfElection,location).getCandidateList().head;
        while(temp!=null){
            if (lastName.equals(temp.getCandidate().getPolitician().getLastName())){
                electionList.findElection(typeOfElection,location).getCandidateList().deleteCandidate(lastName);
            }
            temp=temp.getNextNode();
        }
        System.out.println("Enter new information");
        System.out.println("Enter the last name of candidate");
        lastName=input.nextLine();
        Politician politician=politicianList.findPolitician(lastName);
        System.out.println("Enter the num of votes candidate has ");
        int numOfVotes=input.nextInt();
        Candidate candidate = new Candidate(politician,numOfVotes);
        CandidateNode candidateNode = new CandidateNode (candidate);
        electionList.findElection(typeOfElection,location).getCandidateList().addCandidate(candidateNode);
    }
    /**
     * Opens the Edit Election Menu
     */
    private void editElection() {
        System.out.println("Enter the type of election you wish to edit");
        String typeOfElection = input.nextLine();
        System.out.println("Enter the location of election you wish to edit");
        String location = input.nextLine();
        CandidateList savedCandidateList = electionList.findElection(typeOfElection, location).getCandidateList();  //to save deleted candidate list from election to add to new updated version
        electionList.deleteElection(typeOfElection, location);
        System.out.println("Enter the new election type");
        String upTypeOfElection = input.nextLine();
        System.out.println("Enter new location");
        String upLocation = input.nextLine();
        System.out.println("Enter new date of election");
        int date = input.nextInt();
        System.out.println("Enter num of seats");
        int numOfSeats = input.nextInt();
        Election election = new Election(upTypeOfElection, upLocation, date, numOfSeats, savedCandidateList);
        ElectionNode electionNode = new ElectionNode(election);
        electionList.addElection(electionNode);
    }
    //Fills up hashtable
    public void populateHash(){
        politicianListHashTable.add(politicianList0,0);
        politicianListHashTable.add(politicianList1,1);
        politicianListHashTable.add(politicianList2,2);
        politicianListHashTable.add(politicianList3,3);
        politicianListHashTable.add(politicianList4,4);
        politicianListHashTable.add(politicianList5,5);
        politicianListHashTable.add(politicianList6,6);
        politicianListHashTable.add(politicianList7,7);
        politicianListHashTable.add(politicianList8,8);
        politicianListHashTable.add(politicianList9,9);
    }
   private void searchForPoliticianLastName() {
        System.out.println("Enter second name of the person you want to search");
        input.nextLine();
        String lastName=input.nextLine();
        if (!lastName.isBlank()) {
            int key = lastName.length() % politicianListHashTable.hashTable.length;
            Politician foundPolitician = politicianListHashTable.hashTable[key].value.findPolitician(lastName);
             String foundName = foundPolitician.getLastName();
            if (foundName != null) {
                System.out.println("Found Politician");
                System.out.println(foundPolitician.getFirstName()+" "+foundPolitician.getLastName());
                System.out.println(foundPolitician.getPoliticalParty());
                System.out.println(foundPolitician.getHomeCounty());
                System.out.println(foundPolitician.getImgURL());
            } else {
                System.out.println("Politician Doesnt Exist");
            }
        }
        else{
            System.out.println("NOT WORKING!!");
        }
   }


    private void deletePolitician() {
        System.out.println("Enter last name of politician you wish to delete");
        String lastName = input.nextLine();
        int polKey= lastName.length()% politicianListHashTable.hashTable.length;
        politicianListHashTable.hashTable[polKey].value.deletePolitician(lastName);
    }

    private void deleteElection() {
        System.out.println("Enter the type of election for deletion");
        String typeOfElection = input.nextLine();
        System.out.println("Enter the location of election for deletion");
        String location = input.nextLine();
        electionList.deleteElection(typeOfElection, location);
        System.out.println("Deleted");
    }


    private void deleteCandidate() {
        System.out.println("Enter election type candidate belongs to");
        String electionType = input.nextLine();
        System.out.println("Enter location of election candidate belongs to");
        String location =input.nextLine();
        System.out.println("Enter last name of candidate");
        String lastName=input.nextLine();
        electionList.findElection(electionType,location).getCandidateList().deleteCandidate(lastName);
    }

    /*Generic code refactored from CA1*/
    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream electionListOut = xstream.createObjectOutputStream(new FileWriter("ElectionList.xml"));
        ObjectOutputStream politicianListOut =xstream.createObjectOutputStream(new FileWriter("PoliticianListHash.xml"));
        electionListOut.writeObject(electionList);
        politicianListOut.writeObject(politicianListHashTable);
        electionListOut.close();
        politicianListOut.close();
    }
    public void load() throws Exception {
        XStream xStream = new XStream(new DomDriver());
        //Taken from stack overflow. Security Issue. https://stackoverflow.com/questions/44698296/security-framework-of-xstream-not-initialized-xstream-is-probably-vulnerable
        Class<?>[] classes = new Class[]{electionList.getClass(),politicianListHashTable.getClass()};
        XStream.setupDefaultSecurity(xStream);
        xStream.allowTypes(classes);
        //end of stack overflow code
        ObjectInputStream electionListIn = xStream.createObjectInputStream(new FileReader("ElectionList.xml"));
        ObjectInputStream politicianListIn= xStream.createObjectInputStream(new FileReader("PoliticianListHash.xml"));
        electionList = (ElectionList) electionListIn.readObject();
        politicianListHashTable = (HashTable<PoliticianList>) politicianListIn.readObject();
        electionListIn.close();
        politicianListIn.close();
        runMenu();
    }

    /**
     *Formats the user generated political party, if it is a non recognised party
     * the politician is set to be an independant.
     * @param politicalParty - User generated political party
     *
     * @return - formatted political party
     */
    private String checkPoliticalParty(String politicalParty){
        politicalParty.toUpperCase();
        if (politicalParty.contains("FIANNA FAIL")){
            politicalParty=("Fianna Fail");
        }
        else if (politicalParty.contains("SINN FEIN")) {
            politicalParty=("Sinn Fein");
        }
        else if (politicalParty.contains("FIANNA GAIL")){
            politicalParty=("Fianna Gail");
        }
        else if(politicalParty.contains("GREEN PARTY")){
            politicalParty=("Green Party");
        }
        else {
            politicalParty=("Independant");
        }
        return politicalParty;
    }
    private void sortElectionsByElectionType(){
        System.out.println("Sorting Elections By ElectionType");
        electionList.mergeSort(electionList.head);
        System.out.println("New Election List");
        ElectionNode temp=electionList.head;
        while(temp!=null){
            System.out.println(temp.getElection().getElectionType());
            temp=temp.getNextNode();
        }

    }
    private void sortPoliticiansByLastName(){
        System.out.println("Sorting Politicians by last name");
        for (int i=0;i<politicianListHashTable.hashTable.length;i++){
            politicianListHashTable.hashTable[i].value.mergeSort(politicianListHashTable.hashTable[i].value.getHead());
        }
        System.out.println("Politician Lists sorted in each hash table");
        for(int i=0;i<politicianListHashTable.hashTable.length;i++){
            PoliticianNode temp=politicianListHashTable.hashTable[i].value.getHead();

            System.out.println("Politicians in index " + i);
            if(temp==null){System.out.println("There exists no politicians at index "+i);}
            while(temp!=null){
                System.out.println(temp.politician.getLastName());
                System.out.println(temp.politician.getFirstName());
                temp=temp.getNextNode();
            }

        }

    }
}
