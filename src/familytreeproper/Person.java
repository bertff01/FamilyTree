package familytreeproper;

import java.io.Serializable;
/**
 * title FamilyTree
 * Author Frederick Bertram
 * date 16/05/2018
 * file name FamilyTreeProper.java
 * Purpose this displays a family tree for a given root person and the relatives and details of each.
 * Assumptions the user is responsible for entering correct data
 * If the user enters a grandchild it won't worry who the parent is of that grandchild seeing it could be either child 1 or 2 i wasn't able to code around this in time.
 * For name and other data the user can enter any value they want if they want to call someone a banana that is ok.
 
 */
public class Person implements Serializable {

    private Person spouse;
    private Person child1;
    private Person child2;
    private Person mother;
    private Person father;
    private Person grandchild1;
    private Person grandchild2;

    private String name;
    private String surname;
    private String maidenName;
    private String gender;
    private String lifeDescription;

    private String streetNumber;
    private String streetName;
    private String suburb;
    private String postcode;

    private String type;

    /**
     * gets the spouse of the  person
     *
     * @return Person type spouse
     */
    public Person getSpouse() {
        return spouse;
    }

    /**
     * sets the spouse of  person
     * @param spouse Person type
     */
    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    /**
     * gets child1 of the  person
     * @return child1 of the root person
     */
    public Person getChild1() {
        return child1;
    }

    /**
     * sets the child1 ofperson
     * @param child1 Person type
     */
    public void setChild1(Person child1) {
        this.child1 = child1;
    }

    /**
     * gets child2 of person
     * @return person type child2
     */
    public Person getChild2() {
        return child2;
    }

    /**
     * sets child2 of  person
     * @param child2
     */
    public void setChild2(Person child2) {
        this.child2 = child2;
    }

    /**
     * gets mother of person
     * @return
     */
    public Person getMother() {
        return mother;
    }

    /**
     * sets mother of person
     * @param mother
     */
    public void setMother(Person mother) {
        this.mother = mother;
    }

    /**
     * gets father of  person
     * @return
     */
    public Person getFather() {
        return father;
    }

    /**
     * sets type of the Person either root mother father, spouse , child1, child2, grandchild1, grandchild2
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * gets the type of the Person either root mother father, spouse , child1, child2, grandchild1, grandchild2
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * sets the father of theperson
     * @param father
     */
    public void setFather(Person father) {
        this.father = father;
    }

    /**
     * gets grandchild1 of person
     * @return
     */
    public Person getGrandchild1() {
        return grandchild1;
    }

    /**
     * sets grandchild1 of the  person
     * @param grandchild1
     */
    public void setGrandchild1(Person grandchild1) {
        this.grandchild1 = grandchild1;
    }

    /**
     * gets grandchild2 of the person
     * @return
     */
    public Person getGrandchild2() {
        return grandchild2;
    }

    /**
     * sets grandchild2 of the person
     * @param grandchild2
     */
    public void setGrandchild2(Person grandchild2) {
        this.grandchild2 = grandchild2;
    }

    /**
     * gets the name of the person
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the person
     * @param name
     * @throws Exception
     */
    public void setName(String name) throws Exception {
        if (name.equals("")) {
            throw new Exception("name cannot be empty");
        }
        this.name = name;
    }

    /**
     * gets surname of the person
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     * sets the surname of the person cannot be empty
     * @param surname surname of the person
     * @throws Exception
     */
    public void setSurname(String surname) throws Exception {
        if (surname.equals("")) {
            throw new Exception("surname cannot be empty");
        }
        this.surname = surname;
    }

    /**
     * maiden name of the person
     * @return
     */
    public String getMaidenName() {
        return maidenName;
    }

    /**
     * sets maidenname of the person
     * @param maidenName
     */
    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    /**
     * gets gender of the person
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * sets gender of the person
     * @param gender
     * @throws Exception if gender isn't right for some reason
     */
    public void setGender(String gender) throws Exception {
        if (!gender.equals("Male") && !gender.equals("Female")) {
            throw new Exception("invalid gender");
        }
        this.gender = gender;
    }

    /**
     * get life description of person, warning long description might not display properly
     * @return
     */
    public String getLifeDescription() {
        return lifeDescription;
    }

    /**
     * sets life description of person
     * @param lifeDescription
     */
    public void setLifeDescription(String lifeDescription) {
        this.lifeDescription = lifeDescription;
    }

    /**
     * gets street number of person
     * @return
     */
    public String getStreetNumber() {
        return streetNumber;
    }

    /**
     * sets street number of person
     * @param streetNumber
     */
    public void setStreetNumber(String streetNumber) {

        this.streetNumber = streetNumber;
    }

    /**
     * gets street name of person
     * @return
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * sets street name of person
     * @param streetName
     */
    public void setStreetName(String streetName) {

        this.streetName = streetName;
    }

    /**
     * gets suburb of person
     * @return
     */
    public String getSuburb() {
        return suburb;
    }

    /**
     * sets suburb of person
     * @param suburb
     */
    public void setSuburb(String suburb) {

        this.suburb = suburb;
    }

    /**
     * gets postcode of the person
     * @return
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * sets postcode of the person
     * @param postcode
     * @throws Exception
     */
    public void setPostcode(String postcode) throws Exception {

        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Person{type=" + type + ", name=" + name + ", surname=" + surname + ", maidenName=" + maidenName + ", gender=" + gender + ", lifeDescription=" + lifeDescription + ", streetNumber=" + streetNumber + ", streetName=" + streetName + ", suburb=" + suburb + ", postcode=" + postcode + '}';
    }

}
