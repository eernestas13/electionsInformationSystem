public class Politician {
    private String firstName;
    private String lastName;
    private String politicalParty;
    private String homeCounty;
    private String imgURL;


    /**
     * Constructor
     */
    public Politician(){}
    public Politician(String firstName, String lastName,String politicalParty, String homeCounty,String imgURL){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPoliticalParty(politicalParty);
        this.setHomeCounty(homeCounty);
        this.setImgURL(imgURL);
    }
    /*Setters*/
    /**
     * Sets FirstName for this Politician
     * @param firstName - User Specified First Name for Politician
     */
    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    /**
     * Sets LastName of this Politician
     * @param lastName - User Specified Last Name for Politician
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets PoliticalParty of this Politician
     * @param politicalParty - User Specified Political Party for Politician
     */
    public void setPoliticalParty(String politicalParty) {
        this.politicalParty = politicalParty;
    }

    /**
     * Sets HomeCounty for this Politician
     * @param homeCounty - User Specified Home County of Politican
     */
    public void setHomeCounty(String homeCounty){
        this.homeCounty=homeCounty;
    }
    public void setImgURL(String imgURL){
        this.imgURL=imgURL;
    }

    /*Getters*/

    /**
     * Gets FirstName of Politician
     * @return firstName - First name of Politician
     */
    public String getFirstName() {
        return firstName;
    }


    /**
     * Gets LastName of Politician
     * @return lastName - Last Name of Politician
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets Political Party of Politician
     * @return politicialParty - Political Party of Politician
     */
    public String getPoliticalParty() {
        return politicalParty;
    }

    /**
     * Gets HomeCounty of Politician
     * @return homeCounty - Politician's Home County
     */
    public String getHomeCounty() {
        return homeCounty;
    }

    public String getImgURL() {
        return imgURL;
    }

    @Override
    public String toString() {
        return "Politician{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", politicalParty='" + politicalParty + '\'' +
                ", homeCounty='" + homeCounty + '\'' +
                ", imgURL='" + imgURL + '\'' +
                '}';
    }
}
