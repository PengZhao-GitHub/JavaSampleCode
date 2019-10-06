/*
 * Copyright (c) 1996-2001 Borland Software Corporation. All Rights Reserved.
 * 
 * This SOURCE CODE FILE, which has been provided by Borland Software as part
 * of an Borland Software product for use ONLY by licensed users of the product,
 * includes CONFIDENTIAL and PROPRIETARY information of Borland Software.  
 *
 * USE OF THIS SOFTWARE IS GOVERNED BY THE TERMS AND CONDITIONS 
 * OF THE LICENSE STATEMENT AND LIMITED WARRANTY FURNISHED WITH
 * THE PRODUCT.
 *
 * IN PARTICULAR, YOU WILL INDEMNIFY AND HOLD BORLAND SOFTWARE, ITS
 * RELATED COMPANIES AND ITS SUPPLIERS, HARMLESS FROM AND AGAINST ANY
 * CLAIMS OR LIABILITIES ARISING OUT OF THE USE, REPRODUCTION, OR
 * DISTRIBUTION OF YOUR PROGRAMS, INCLUDING ANY CLAIMS OR LIABILITIES
 * ARISING OUT OF OR RESULTING FROM THE USE, MODIFICATION, OR
 * DISTRIBUTION OF PROGRAMS OR FILES CREATED FROM, BASED ON, AND/OR
 * DERIVED FROM THIS SOURCE CODE FILE.
 */
//------------------------------------------------------------------------------
// Copyright (c) 1996-2001 Borland Software Corporation.  All Rights Reserved.
//------------------------------------------------------------------------------

package com.borland.samples.swing.treecontrol;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import javax.swing.border.*;

public class Frame1 extends JFrame {

  //create the UI container
  JPanel contentPane;

  //create the tree
  DefaultMutableTreeNode top =  new DefaultMutableTreeNode("Root of tree");
  JTree jTree1 = new JTree(top);
  JScrollPane treeView = new JScrollPane(jTree1);
  DefaultTreeCellRenderer treeRenderer = new DefaultTreeCellRenderer();

  //create the items in the tree
  DefaultMutableTreeNode node1 = null;
  DefaultMutableTreeNode child1 = null;
  DefaultMutableTreeNode child1_level1 = null;
  DefaultMutableTreeNode node2 = null;
  DefaultMutableTreeNode child2 = null;
  DefaultMutableTreeNode child2_level1 = null;

  //create the menu bar and menu items
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu menuFile = new JMenu();
  JMenuItem menuFileExit = new JMenuItem();
  JMenu jMenu1 = new JMenu();
  JMenu jMenu2 = new JMenu();
  JMenuItem jMenuItem1 = new JMenuItem();

  //create the button to display the "powered by jbuilder" gif

  //create the editor pane
  JEditorPane jEditorPane1 = new JEditorPane();
  JButton jButton1 = new JButton();


  //Construct the frame
  public Frame1() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Component initialization
  public void jbInit() throws Exception  {

    //UI container
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(null);
    this.setSize(new Dimension(400, 300));
    this.setTitle("Tree Control Sample");
    this.setJMenuBar(jMenuBar1);

    //initializes tree and creates tree selection event listener
    createNodes(top);
    jTree1.setEditable(true);
    jTree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    jTree1.setShowsRootHandles(true);
    jTree1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
      public void valueChanged(TreeSelectionEvent e) {
        jTree1_valueChanged(e);
      }
    });
    treeView.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    treeView.setViewportBorder(BorderFactory.createEtchedBorder());
    treeView.setBounds(new Rectangle(7, 14, 239, 139));

    //initializes menu items and creates event listeners
    menuFile.setText("File");
    menuFileExit.setText("Exit");
    menuFileExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        menuFileExit_actionPerformed(e);
      }
    });
    jMenu1.setText("Change Icon");
    jMenu2.setText("Change Leaf Icon");
    jMenuItem1.setText("Sample");
    jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuItem1_actionPerformed(e);
      }
    });

    //initializes button and display icon on button

    //initializes editor pane
    jEditorPane1.setBackground(Color.cyan);
    jEditorPane1.setBorder(BorderFactory.createEtchedBorder());
    jEditorPane1.setFont(new java.awt.Font("SansSerif", 1, 12));
    jEditorPane1.setBounds(new Rectangle(251, 41, 137, 79));

    //adds components to content pane
    jButton1.setIcon(new ImageIcon(Frame1.class.getResource("jbpower.gif")));
    jButton1.setBounds(new Rectangle(125, 203, 126, 35));
    jMenuBar1.add(menuFile);
    jMenuBar1.add(jMenu1);
    jMenu1.add(jMenu2);
    jMenu2.add(jMenuItem1);
    menuFile.add(menuFileExit);
    contentPane.add(treeView, null);
    contentPane.add(jEditorPane1, null);
    contentPane.add(jButton1, null);
}



  //Overridden so we can exit when window is closed
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  //method createNodes to add nodes to the tree
  public void createNodes(DefaultMutableTreeNode top) {

      node1 = new DefaultMutableTreeNode("First child");
      top.add(node1);

      child1 = new DefaultMutableTreeNode("First child item 1");
      node1.add(child1);
      child1 = new DefaultMutableTreeNode("First child item 2");
      node1.add(child1);

      child1_level1 = new DefaultMutableTreeNode("Item 2 - child 1");
      child1.add(child1_level1);
      node2 = new DefaultMutableTreeNode("Second child");
      top.add(node2);

      child2 = new DefaultMutableTreeNode("Second child item 1");
      node2.add(child2);
      child2 = new DefaultMutableTreeNode("Second child item 2");
      node2.add(child2);
      child2 = new DefaultMutableTreeNode("Second child item 3");
      node2.add(child2);
   }

  //File|Exit event
  void menuFileExit_actionPerformed(ActionEvent e) {
   System.exit(0);
  }

  //Change Icon|Change Leaf Icon|Sample event
  void jMenuItem1_actionPerformed(ActionEvent e) {
    treeRenderer.setIcon(new ImageIcon(Frame1.class.getResource("Sample.gif")));
    treeRenderer.setLeafIcon(new ImageIcon(Frame1.class.getResource("Sample.gif")));
    jTree1.setCellRenderer(treeRenderer);
  }

  //tree selection event
  void jTree1_valueChanged(TreeSelectionEvent e) {
     String nodeRoot = new String("The root is selected");
     String nodeText = new String("A node is selected");
     String nodeLeaf = new String("A leaf node is selected");
     DefaultMutableTreeNode node = (DefaultMutableTreeNode)jTree1.getLastSelectedPathComponent();

     TreePath pathnode = (TreePath)jTree1.getLeadSelectionPath();
     if (jTree1.isVisible(pathnode)) {

      if (node.isRoot()) {
          jEditorPane1.setText(nodeRoot);
        }
        else if (node.isLeaf()) {
            jEditorPane1.setText(nodeLeaf);
        }
        else if (node.isNodeAncestor(top)) {
          jEditorPane1.setText(nodeText);
        }
     }
   }
 }