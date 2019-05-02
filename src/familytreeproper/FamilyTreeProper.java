/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytreeproper;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

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
public class FamilyTreeProper extends JFrame {

    private TopPanel top;
    private TreeLabels label;
    private Display info;
    public JLabel footer;

    /**
     * gets the labels panel
     * @return TreeLabels panel
     */
    public TreeLabels getLabel() {
        return label;
    }

    /**
     * gets the display panel
     * @return Display panel
     */
    public Display getInfo() {
        return info;
    }

    /**
     * displays a person of type Person
     * @param p The Person to display
     */
    public void displayPerson(Person p) {
        info.display(p);
        System.out.println("displaying person");
    }
/*
    constructs everything
    */
    FamilyTreeProper(String title) {
        super(title);
        getContentPane().setLayout(new BorderLayout());
        top = new TopPanel();
        top.setRoot(this);
        getContentPane().add(BorderLayout.NORTH, top);
        label = new TreeLabels();
        label.setRoot(this);
        info = new Display();
        info.setRoot(this);
        footer = new JLabel("");
        getContentPane().add(BorderLayout.EAST, info);
        getContentPane().add(BorderLayout.WEST, label);
        footer.setText("No person loaded");
        getContentPane().add(BorderLayout.SOUTH, footer);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            } // end of windowClosing()
        });
    }
/*
    private function to get save location for the save file
    */
    private String getSaveLocation() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = chooser.showSaveDialog(this);

        if (result == chooser.APPROVE_OPTION) {
            File folder = chooser.getCurrentDirectory();

            return folder.getPath() + folder.separatorChar + chooser.getSelectedFile().getName();
        } else {
            chooser.hide();
        }
        return null;
    }

    /**
     * gets the open location for when it wants to open a previously saved file
     * @return the save file location directory and file
     */
    public String getOpenLocation() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.CANCEL_OPTION) {
            fileChooser.hide();
        }
        File folder = fileChooser.getCurrentDirectory();
        return folder.getPath() + folder.separatorChar + fileChooser.getSelectedFile().getName();
    }

    /**
     * function that executes if save button clicked
     * @param evt the evt it is not used 
     */
    public void saveMouseClicked(java.awt.event.MouseEvent evt) {
        PersonSupport.save(getSaveLocation()); // TODO add your handling code here:
    }

    /**
     * loads a saved file
     * @param evt the event but is not used
     */
    public void loadMouseClicked(java.awt.event.MouseEvent evt) {
        PersonSupport.load(getOpenLocation());// TODO add your handling code here:
        label.addTree();
        info.hideAddRoot();
        info.hide();
        footer.setText(PersonSupport.getPerson().getName() + " loaded");
    }

    /**
     * creates a new tree removing current root person letting them start fresh
     */
    public void createTree() {
        PersonSupport.makeNull();
        label.hideTree();
        info.showAddRoot();
        info.hide();
        footer.setText("No person loaded");
    }

    /**
     * main method contains the resolution
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FamilyTreeProper app = new FamilyTreeProper("Family Tree App");

        app.setSize(820, 800);
        app.setVisible(true);
    }

}
