/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package familytreeproper;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
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
public class TopPanel extends JPanel implements ActionListener {

    private JMenuBar bar;
    private JMenu menu;
    private JButton load;
    private JButton save;
    private JButton create;
    private FamilyTreeProper root;

    /**
     * sets the root panel so this panel can call it later
     * @param p
     */
    public void setRoot(FamilyTreeProper p) {
        root = p;
    }
/*
    constructor uses a gridview
    */
    TopPanel() {
        this.setLayout(new BorderLayout());

        bar = new JMenuBar();
        menu = new JMenu("File");
        bar.add(menu);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this);
        menu.add(exit);
        this.add(bar);
        load = new JButton("Load Tree");
        load.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                root.loadMouseClicked(evt);
            }
        });
        save = new JButton("Save Tree");
        save.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                root.saveMouseClicked(evt);
            }
        });
        create = new JButton("Create Tree");
        create.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                root.createTree();
            }
        });
        int i = 2;
        int j = 7;
        JPanel[][] panelHolder = new JPanel[i][j];
        setLayout(new GridLayout(i, j, 2, 2));

        for (int m = 0; m < i; m++) {
            for (int n = 0; n < j; n++) {
                panelHolder[m][n] = new JPanel();
                add(panelHolder[m][n]);
            }
        }
        panelHolder[1][0].add(load);
        panelHolder[1][1].add(save);
        panelHolder[1][2].add(create);

    }

    public void actionPerformed(ActionEvent e) {
        System.exit(0);
        //...Get information from the action event...
        //...Display it in the text area...
    }

}
