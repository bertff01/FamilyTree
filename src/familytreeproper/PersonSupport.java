package familytreeproper;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

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
public class PersonSupport {

    private static Person person;

    /**
     * create a new person with each of the persons details some of them can be blank with no issue throws an exception if incorrect data given
     * @param name
     * @param surname
     * @param maiden
     * @param gender
     * @param life
     * @param streetno
     * @param streetname
     * @param suburb
     * @param postcode
     * @throws Exception
     */
    public static void createPerson(String name, String surname, String maiden, String gender, String life, String streetno, String streetname, String suburb, String postcode) throws Exception {
        if (person == null) {
            person = new Person();
        }
        person.setType("Root");
        person.setName(name);
        person.setSurname(surname);
        person.setMaidenName(maiden);
        person.setGender(gender);
        person.setLifeDescription(life);

        person.setStreetNumber(streetno);
        person.setStreetName(streetname);
        person.setSuburb(suburb);
        person.setPostcode(postcode);

        System.out.println(person.toString());
    }

    /**
     * creates a person with given details some of them can be blank gives off an exception if some of the data is incorrect.
     * @param relative
     * @param name
     * @param surname
     * @param maiden
     * @param gender
     * @param life
     * @param streetno
     * @param streetname
     * @param suburb
     * @param postcode
     * @throws Exception
     */
    public static void createPerson(String relative, String name, String surname, String maiden, String gender, String life, String streetno, String streetname, String suburb, String postcode) throws Exception {
        Person p = new Person();
        if (relative.equals("Mother")) {
            p.setChild1(person);
            person.setMother(p);
            p.setType("Mother");
        }
        if (relative.equals("Father")) {
            p.setChild1(person);
            person.setFather(p);
            p.setType("Father");
        }
        if (relative.equals("Spouse")) {
            p.setSpouse(person);
            person.setSpouse(p);
            p.setType("Spouse");
        }
        if (relative.equals("Child1")) {
            if (person.getGender().equals("Male")) {
                p.setFather(person);
                p.setMother(person.getSpouse());
            } else {
                p.setFather(person.getSpouse());
                p.setMother(person);
            }
            person.setChild1(p);
            p.setType("Child1");
        }
        if (relative.equals("Child2")) {
            if (person.getGender().equals("Male")) {
                p.setFather(person);
                p.setMother(person.getSpouse());
            } else {
                p.setFather(person.getSpouse());
                p.setMother(person);
            }
            person.setChild2(p);
            p.setType("Child2");
        }
        if (relative.equals("Grandchild1")) {
            p.setType("Grandchild1");
            person.setGrandchild1(p);
        }
        if (relative.equals("Grandchild2")) {
            person.setGrandchild2(p);
            p.setType("Grandchild2");
        }
        p.setName(name);
        p.setSurname(surname);
        p.setMaidenName(maiden);
        p.setGender(gender);
        p.setLifeDescription(life);

        p.setStreetNumber(streetno);
        p.setStreetName(streetname);
        p.setSuburb(suburb);
        p.setPostcode(postcode);

        System.out.println(p.toString());
    }

    /**
     *
     * @return gets the Person in static variable person
     */
    public static Person getPerson() {
        return person;
    }

    /**
     * saves the person and his relatives to a file for later viewing
     * @param file
     */
    public static void save(String file) {
        System.out.println(file);
        Path path = FileSystems.getDefault().getPath(file);
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(path)))) {
            if (person != null) {
                out.writeObject(person);
            }
            if (person.getMother() != null) {
                out.writeObject(person.getMother());
            }
            if (person.getFather() != null) {
                out.writeObject(person.getFather());
            }
            if (person.getSpouse() != null) {
                out.writeObject(person.getSpouse());
            }
            if (person.getChild1() != null) {
                out.writeObject(person.getChild1());
            }
            if (person.getChild2() != null) {
                out.writeObject(person.getChild2());
            }
            if (person.getGrandchild1() != null) {
                out.writeObject(person.getGrandchild1());
            }
            if (person.getGrandchild2() != null) {
                out.writeObject(person.getGrandchild2());
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

    /**
     * makes the person null to start fresh
     */
    public static void makeNull() {
        person = null;
    }

    /**
     * loads a person and his relatives from a file
     * @param file
     */
    public static void load(String file) {
        person = null;
        Path path = FileSystems.getDefault().getPath(file);
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            boolean eof = false;
            while (!eof) {
                try {

                    Person p = (Person) in.readObject();
                    if (p.getType().equals("Root")) {
                        person = p;
                    }
                    if (p.getType().equals("Mother")) {
                        person.setMother(p);
                    }
                    if (p.getType().equals("Father")) {
                        person.setFather(p);
                    }
                    if (p.getType().equals("Spouse")) {
                        person.setSpouse(p);
                    }
                    if (p.getType().equals("Child1")) {
                        person.setChild1(p);
                    }
                    if (p.getType().equals("Child2")) {
                        person.setChild2(p);
                    }
                    if (p.getType().equals("Grandchild1")) {
                        person.setGrandchild1(p);
                    }
                    if (p.getType().equals("Grandchild2")) {
                        person.setGrandchild2(p);
                    }
                } catch (EOFException e) {
                    eof = true;
                } catch (ClassNotFoundException e) {
                    System.out.println("Class not found");
                    return;
                }
            }
        } catch (IOException e) {

        }
    }

}
