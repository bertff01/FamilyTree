/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytreeproper;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
public class TreeLabels extends JPanel {

    private JLabel child1label;
    private JLabel child2label;
    private JLabel childrentag;
    private JLabel fatherlabel;
    private JLabel grandchild1label;
    private JLabel grandchild2label;
    private JLabel grandchildrentag;
    private JLabel motherlabel;
    private JLabel parentstag;
    private JLabel rootlabel;
    private JLabel spouselabel;
    private JLabel spousetag;

    TreeLabels() {
        int i = 14;
        int j = 7;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j));

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                add(panelHolder[m][n]);
            }

        }
        rootlabel = new JLabel("root");
        parentstag = new JLabel("Parents");
        motherlabel = new JLabel("Mother");
        fatherlabel = new JLabel("Father");
        spousetag = new JLabel("Spouse");
        spouselabel = new JLabel("Spouselabel");
        childrentag = new JLabel("Children");
        child1label = new JLabel("Child1");
        child2label = new JLabel("Child2");
        grandchildrentag = new JLabel("Grandchildren");
        grandchild1label = new JLabel("Grandchild1");
        grandchild2label = new JLabel("Grandchild2");
        panelHolder[0][0].add(rootlabel);
        panelHolder[2][1].add(parentstag);
        panelHolder[3][2].add(motherlabel);
        panelHolder[4][2].add(fatherlabel);
        panelHolder[5][1].add(spousetag);
        panelHolder[6][2].add(spouselabel);
        panelHolder[7][1].add(childrentag);
        panelHolder[8][2].add(child1label);
        panelHolder[9][2].add(child2label);
        panelHolder[10][1].add(grandchildrentag);
        panelHolder[11][2].add(grandchild1label);
        panelHolder[12][2].add(grandchild2label);
        addListeners();
        hideTree();
    }
    private FamilyTreeProper root;

    /**
     * this sets the root class to the variable root
     * @param root the root panel
     */
    public void setRoot(FamilyTreeProper root) {
        this.root = root;
    }

    /**
     * this gets the root person and their relatives and adds them to the tree on the left then displays it
     */
    public void addTree() {
        Person p = PersonSupport.getPerson();
        rootlabel.setText(p.getName() + " " + p.getSurname());
        if (p.getFather() != null) {
            parentstag.show();
            fatherlabel.setText(p.getFather().getName() + " " + p.getFather().getSurname());
            fatherlabel.show();
        }
        if (p.getMother() != null) {
            parentstag.show();
            motherlabel.setText(p.getMother().getName() + " " + p.getMother().getSurname());
            motherlabel.show();
        }
        if (p.getSpouse() != null) {
            spousetag.show();
            spouselabel.setText(p.getSpouse().getName() + " " + p.getSpouse().getSurname());
            spouselabel.show();

        }
        if (p.getChild1() != null) {
            childrentag.show();
            child1label.setText(p.getChild1().getName() + " " + p.getChild1().getSurname());
            child1label.show();
        }
        if (p.getChild2() != null) {
            childrentag.show();
            child2label.setText(p.getChild2().getName() + " " + p.getChild2().getSurname());
            child2label.show();
        }
        if (p.getGrandchild1() != null) {
            grandchildrentag.show();
            grandchild1label.setText(p.getGrandchild1().getName() + " " + p.getGrandchild1().getSurname());
            grandchild1label.show();
        }
        if (p.getGrandchild2() != null) {
            grandchildrentag.show();
            grandchild2label.setText(p.getGrandchild2().getName() + " " + p.getGrandchild2().getSurname());
            grandchild2label.show();
        }
        //root.setFooter();
        //root.hideAddRoot();

    }

    private void rootlabelMouseClicked(java.awt.event.MouseEvent evt) {
        root.displayPerson(PersonSupport.getPerson());


    }

    private void motherlabelMouseClicked(java.awt.event.MouseEvent evt) {
        root.displayPerson(PersonSupport.getPerson().getMother());
    }

    private void fatherlabelMouseClicked(java.awt.event.MouseEvent evt) {
        root.displayPerson(PersonSupport.getPerson().getFather()); // TODO add your handling code here:
    }

    private void spouselabelMouseClicked(java.awt.event.MouseEvent evt) {
        root.displayPerson(PersonSupport.getPerson().getSpouse());// TODO add your handling code here:
    }

    private void child1labelMouseClicked(java.awt.event.MouseEvent evt) {
        root.displayPerson(PersonSupport.getPerson().getChild1());  // TODO add your handling code here:
    }

    private void child2labelMouseClicked(java.awt.event.MouseEvent evt) {
        root.displayPerson(PersonSupport.getPerson().getChild2()); // TODO add your handling code here:
    }

    private void grandchild1labelMouseClicked(java.awt.event.MouseEvent evt) {
        root.displayPerson(PersonSupport.getPerson().getGrandchild1()); // TODO add your handling code here:
    }

    private void grandchild2labelMouseClicked(java.awt.event.MouseEvent evt) {
        root.displayPerson(PersonSupport.getPerson().getGrandchild2());  // TODO add your handling code here:
    }

    /**
     * this adds listeners to the buttons in the tree panel
     */
    public void addListeners() {
        rootlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (!rootlabel.getText().equals("no tree data found")) {
                    rootlabelMouseClicked(evt);
                }
            }
        });

        motherlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                motherlabelMouseClicked(evt);
            }
        });

        fatherlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fatherlabelMouseClicked(evt);
            }
        });

        spouselabel.setText("Spouse");
        spouselabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spouselabelMouseClicked(evt);
            }
        });

        child1label.setText("Child1");
        child1label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                child1labelMouseClicked(evt);
            }
        });

        child2label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                child2labelMouseClicked(evt);
            }
        });

        grandchild1label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grandchild1labelMouseClicked(evt);
            }
        });

        grandchild2label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grandchild2labelMouseClicked(evt);
            }
        });
    }

    /**
     * this hides the trees if there is no root person
     */
    public void hideTree() {
        rootlabel.setText("no tree data found");
        parentstag.hide();
        motherlabel.hide();
        fatherlabel.hide();
        spousetag.hide();
        spouselabel.hide();
        childrentag.hide();
        child1label.hide();
        child2label.hide();
        grandchildrentag.hide();
        grandchild1label.hide();
        grandchild2label.hide();

    }
}
