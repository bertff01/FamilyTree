/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytreeproper;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
public class Display extends JPanel {

    private FamilyTreeProper root;

    Person current;
        private javax.swing.JButton addrelativebutton;
    private javax.swing.JLabel addressinfotag;
    private javax.swing.JLabel childrentag;
    private JTextField childrentxt;
    private javax.swing.JButton editbutton;
    private javax.swing.JLabel fathertag;
    private JTextField fathertxt;
    private javax.swing.JLabel gendertag;
    private JComboBox gendertxt;
    private javax.swing.JLabel grandchildrentag;
    private JTextField grandchildrentxt;

    private JTextArea lifedescriptiontxt;
    private javax.swing.JLabel lifetag;
    private javax.swing.JLabel maidennametag;
    private JTextField maidentxt;
    private javax.swing.JLabel mothertag;
    private JTextField mothertxt;
    private javax.swing.JLabel nametag;
    private JTextField nametxt;
    private javax.swing.JLabel postcodetag;
    private JTextField postcodetxt;
    private javax.swing.JLabel relativeinfotag;
    private javax.swing.JLabel spousetag;
    private JTextField spousetxt;
    private javax.swing.JLabel streetnametag;
    private JTextField streetnametxt;
    private javax.swing.JLabel streetnumbertag;
    private JTextField streetnumbertxt;
    private javax.swing.JLabel suburbtag;
    private JTextField suburbtxt;
    private javax.swing.JLabel surnametag;
    private JTextField surnametxt;
    private JLabel rootlabel;
    private JButton addrootbutton;
    private JLabel relativelabel;
    private JComboBox relativeList;
    private JComboBox grandchildparent;
    private JLabel grandchildparentlabel;
    JScrollPane scroll;

    /**
     * this sets the root for the display window where the information is kept
     * @param ui this gives the base panel incase this class needs to call it
     */
    public void setRoot(FamilyTreeProper ui) {
        root = ui;
    }

    /**
     * returns the current person in the display
     * @return returns a Person who is in the display.
     */
    public Person getCurrent() {
        return current;
    }

    /**
     * this updates the display panel
     */
    public void update() {
        if (current != null) {
            switch (current.getType()) {
                case "Mother":
                    display(PersonSupport.getPerson().getMother());
                    break;
                case "Father":
                    display(PersonSupport.getPerson().getFather());
                    break;
                case "Spouse":
                    display(PersonSupport.getPerson().getSpouse());
                    break;
                case "Child1":
                    display(PersonSupport.getPerson().getChild1());
                    break;
            }
        }
        display(current);
    }


    Display() {
        rootlabel = new JLabel("");
        addrootbutton = new JButton();
        nametag = new JLabel("Name");
        surnametag = new JLabel("Surname");
        maidennametag = new JLabel("MaidenName");
        gendertag = new JLabel("Gender");
        lifetag = new JLabel("Life Description");
        addressinfotag = new JLabel("Address Info");
        streetnumbertag = new JLabel("Street Number");
        streetnametag = new JLabel("Street Name");
        suburbtag = new JLabel("Suburb");
        postcodetag = new JLabel("Postcode");
        fathertag = new JLabel("Father");
        mothertag = new JLabel("Mother");
        spousetag = new JLabel("Spouse");
        childrentag = new JLabel("Children");
        grandchildrentag = new JLabel("Grandchildren");
        grandchildparentlabel = new JLabel("Grandchilds parent");
        String[] options1 = {"Child1", "Child2"};
        grandchildparent = new JComboBox(options1);
        nametxt = new JTextField("", 14);
        surnametxt = new JTextField("", 14);
        maidentxt = new JTextField("", 14);
        String[] genders= {"Male","Female"};
        gendertxt = new JComboBox(genders);
        lifedescriptiontxt = new JTextArea(3, 14);
         scroll= new JScrollPane (lifedescriptiontxt, 
   JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        streetnumbertxt = new JTextField("", 14);
        streetnametxt = new JTextField("", 14);
        suburbtxt = new JTextField("", 14);
        postcodetxt = new JTextField("", 14);
        mothertxt = new JTextField("", 14);
        fathertxt = new JTextField("", 14);
        spousetxt = new JTextField("", 14);
        childrentxt = new JTextField("", 14);
        grandchildrentxt = new JTextField("", 14);
        addrelativebutton = new JButton("Add Relative");
        editbutton = new JButton("Edit Details");
        relativelabel = new JLabel("Select if making relative");
        String[] options = {"Mother", "Father", "Spouse", "Child1", "Child2", "Grandchild1", "Grandchild2"};
        relativeList = new JComboBox(options);
        int i = 21;
        int j = 2;
        // i use grid layout because not sure how to do it otherwise
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j));

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel(new FlowLayout(FlowLayout.LEFT));
                add(panelHolder[m][n]);
            }
            hide();
        }
        rootlabel.setText("Load a tree or add a root person");
        addrootbutton.setText("Add Root Person");
        panelHolder[0][0].add(rootlabel);
        panelHolder[0][1].add(addrootbutton);
        panelHolder[1][0].add(nametag);
        panelHolder[1][1].add(nametxt);
        panelHolder[2][0].add(surnametag);
        panelHolder[2][1].add(surnametxt);
        panelHolder[3][0].add(maidennametag);
        panelHolder[3][1].add(maidentxt);
        panelHolder[4][0].add(gendertag);
        panelHolder[4][1].add(gendertxt);
        panelHolder[5][0].add(lifetag);
        panelHolder[5][1].add(scroll);
        panelHolder[7][0].add(addressinfotag);
        panelHolder[8][0].add(streetnumbertag);
        panelHolder[8][1].add(streetnumbertxt);
        panelHolder[9][0].add(streetnametag);
        panelHolder[9][1].add(streetnametxt);
        panelHolder[10][0].add(suburbtag);
        panelHolder[10][1].add(suburbtxt);
        panelHolder[11][0].add(postcodetag);
        panelHolder[11][1].add(postcodetxt);
        panelHolder[13][0].add(mothertag);
        panelHolder[13][1].add(mothertxt);
        panelHolder[14][0].add(fathertag);
        panelHolder[14][1].add(fathertxt);
        panelHolder[15][0].add(spousetag);
        panelHolder[15][1].add(spousetxt);
        panelHolder[16][0].add(childrentag);
        panelHolder[16][1].add(childrentxt);
        panelHolder[17][0].add(grandchildrentag);
        panelHolder[17][1].add(grandchildrentxt);

        panelHolder[18][0].add(relativelabel);
        panelHolder[18][1].add(relativeList);
        panelHolder[19][0].add(grandchildparentlabel);
        panelHolder[19][1].add(grandchildparent);
        panelHolder[20][0].add(editbutton);
        panelHolder[20][1].add(addrelativebutton);
        addListeners();

    }

    /**
     * this adds the listeners to the class
     */
    public void addListeners() {
        addrootbutton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addrootMouseClicked(evt);
            }
        });
        editbutton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                editClicked();
            }
        });
        addrelativebutton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                addRelative();
            }
        });

    }

    private void addRelative() {
        try {
            PersonSupport.createPerson(String.valueOf(relativeList.getSelectedItem()), "Enter Name", " ", "",
                    "Male", "", "",
                    "", "", "");
            System.out.println("hi");
            root.getLabel().addTree();
            System.out.println(String.valueOf(relativeList.getSelectedItem()));
        } catch (Exception e) {

        }

    }
/*
    
    this edits the details if edit button clicked or save
    */
    private void editClicked() {
        if (editbutton.getText().equals("Edit Details")) {
            turnOnEditing();
        } else {

            try {
                if (current.getType().equals("Root")) {
                    PersonSupport.createPerson(nametxt.getText(), surnametxt.getText(), maidentxt.getText(),
                            String.valueOf(gendertxt.getSelectedItem()), lifedescriptiontxt.getText(), streetnumbertxt.getText(),
                            streetnametxt.getText(), suburbtxt.getText(), postcodetxt.getText());
                } else {

                    PersonSupport.createPerson(current.getType(), nametxt.getText(), surnametxt.getText(), maidentxt.getText(),
                            String.valueOf(gendertxt.getSelectedItem()), lifedescriptiontxt.getText(), streetnumbertxt.getText(),
                            streetnametxt.getText(), suburbtxt.getText(), postcodetxt.getText());

                }
                root.getLabel().addTree();
                hideAddRoot();
                if (getCurrent() != null) {
                    update();
                }
                turnOffEditing();
            } catch (Exception e) {

            }

        }
    }
/*
    hides the addroot button if it needs to.
    */
    public void hideAddRoot() {
        addrootbutton.hide();
    }

    /**
     * shows the addroot button if it needs to
     */
    public void showAddRoot() {
        addrootbutton.show();
    }
/*
    shows all buttons in the display window
    */
    public void show() {
        nametxt.show();
        nametag.show();
        surnametxt.show();
        surnametag.show();
        scroll.show();
        maidentxt.show();
        maidennametag.show();
        gendertxt.show();
        gendertag.show();
        lifedescriptiontxt.show();
        lifetag.show();
        addressinfotag.show();
        streetnumbertxt.show();
        streetnumbertag.show();
        streetnametxt.show();
        streetnametag.show();
        suburbtxt.show();
        suburbtag.show();
        postcodetxt.show();
        postcodetag.show();
        fathertxt.show();
        fathertag.show();

        mothertxt.show();
        mothertag.show();

        spousetxt.show();
        spousetag.show();

        childrentxt.show();
        childrentag.show();

        grandchildrentag.show();
//            if(current.getType().equals("Grandchild1") || current.getType().equals("Grandchild2")) {
//grandchildparentlabel.show();
//grandchildparent.show();
//            }
        grandchildrentxt.show();
        addrelativebutton.show();
        editbutton.show();
        relativelabel.show();
        relativeList.show();
        System.out.println("showing display");
        this.revalidate();
    }

    /**
     * enables editing of the text fields
     */
    public void turnOnEditing() {
        nametxt.setEditable(true);
        
        surnametxt.setEditable(true);

        maidentxt.setEditable(true);

        gendertxt.setEditable(true);

        lifedescriptiontxt.setEditable(true);

        streetnumbertxt.setEditable(true);

        streetnametxt.setEditable(true);

        suburbtxt.setEditable(true);

        postcodetxt.setEditable(true);

        fathertxt.setEditable(true);

        mothertxt.setEditable(true);

        spousetxt.setEditable(true);

        childrentxt.setEditable(true);

        grandchildrentxt.setEditable(true);
        editbutton.setText("Save Details");
    }

    /**
     * disables editing of the text fields
     */
    public void turnOffEditing() {
        nametxt.setEditable(false);

        surnametxt.setEditable(false);

        maidentxt.setEditable(false);

        gendertxt.setEditable(false);

        lifedescriptiontxt.setEditable(false);

        streetnumbertxt.setEditable(false);

        streetnametxt.setEditable(false);

        suburbtxt.setEditable(false);

        postcodetxt.setEditable(false);

        fathertxt.setEditable(false);

        mothertxt.setEditable(false);

        spousetxt.setEditable(false);

        childrentxt.setEditable(false);

        grandchildrentxt.setEditable(false);
        editbutton.setText("Edit Details");

    }
/*
    hides the fields and labels in display
    */
    public void hide() {
        if (PersonSupport.getPerson() == null) {
            rootlabel.setText("Load a tree or add a root person");
        } else {
            rootlabel.setText("Select a family member");
        }
        nametxt.hide();
        nametag.hide();
        surnametxt.hide();
        surnametag.hide();
        scroll.hide();
        maidentxt.hide();
        maidennametag.hide();
        gendertxt.hide();
        gendertag.hide();
        lifedescriptiontxt.hide();
        lifetag.hide();
        addressinfotag.hide();
        streetnumbertxt.hide();
        streetnumbertag.hide();
        streetnametxt.hide();
        streetnametag.hide();
        suburbtxt.hide();
        suburbtag.hide();
        postcodetxt.hide();
        postcodetag.hide();
        fathertxt.hide();
        fathertag.hide();

        mothertxt.hide();
        mothertag.hide();

        spousetxt.hide();
        spousetag.hide();
        grandchildparent.hide();
        grandchildparentlabel.hide();
        childrentxt.hide();
        childrentag.hide();

        grandchildrentag.hide();

        grandchildrentxt.hide();
        editbutton.hide();
        addrelativebutton.hide();
        relativeList.hide();
        relativelabel.hide();
    }

    /**
     * displays a certain person
     * @param p The person to display
     */
    public void display(Person p) {

        current = p;
        this.show();
        rootlabel.setText("Person Info");

        System.out.println(p.toString());
        nametxt.setText(p.getName());
        surnametxt.setText(p.getSurname());
        maidentxt.setText(p.getMaidenName());
        gendertxt.setSelectedItem(p.getGender());
        lifedescriptiontxt.setText(p.getLifeDescription());

        streetnumbertxt.setText(p.getStreetNumber());
        streetnametxt.setText(p.getStreetName());
        suburbtxt.setText(p.getSuburb());
        postcodetxt.setText(p.getPostcode());
        fathertxt.setText("");

        mothertxt.setText("");

        spousetxt.setText("");

        childrentxt.setText("");

        childrentxt.setText("");

        grandchildrentxt.setText("");

        grandchildrentxt.setText("");
        if (p.getFather() != null) {
            fathertxt.setText(p.getFather().getName() + " " + p.getFather().getSurname());
        }

        if (p.getMother() != null) {
            mothertxt.setText(p.getMother().getName() + " " + p.getMother().getSurname());
        }
        if (p.getSpouse() != null) {
            spousetxt.setText(p.getSpouse().getName() + " " + p.getSpouse().getSurname());
        }
        if (p.getChild1() != null) {
            childrentxt.setText(p.getChild1().getName() + " " + p.getChild1().getSurname());
        }
        if (p.getChild2() != null) {
            childrentxt.setText(childrentxt.getText() + "\n " + p.getChild2().getName() + " " + p.getChild2().getSurname());
        }
        if (p.getGrandchild1() != null) {
            grandchildrentxt.setText(p.getGrandchild1().getName() + " " + p.getGrandchild1().getSurname());
        }
        if (p.getGrandchild2() != null) {
            grandchildrentxt.setText(grandchildrentxt.getText() + "\n " + p.getGrandchild2().getName() + " " + p.getGrandchild2().getSurname());
        }
        turnOffEditing();
    }
/*
    function if add root was clicked
    */
    private void addrootMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        try {
            PersonSupport.createPerson("Click Me!", " ", "",
                    "Male", "", "",
                    "", "", "");
            hide();
            System.out.println("hi");
            root.getLabel().addTree();
            hideAddRoot();
            root.footer.setText(PersonSupport.getPerson().getName() + "loaded");
        } catch (Exception e) {

        }
    }
}
