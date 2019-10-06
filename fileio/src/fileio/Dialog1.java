package fileio;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.borland.jbcl.layout.*;
import java.util.Vector;

/**
 * タイトル:  File IO study
 * 説明:
 * 著作権:   Copyright (c) 2002
 * 会社名:   Cool Family
 * @author Peng Zhao
 * @version 1.0
 */

public class Dialog1 extends JDialog {
  JPanel panel1 = new JPanel();
  XYLayout xYLayout1 = new XYLayout();
  JTextField jTextField1 = new JTextField();
  JButton jButton1 = new JButton();
  JTextField jTextField2 = new JTextField();

  public Dialog1(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      //pack();
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }

  public Dialog1() {
    this(null, "", false);
  }
  void jbInit() throws Exception {
    panel1.setLayout(xYLayout1);
    jButton1.setText("通信");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    getContentPane().add(panel1);
    panel1.add(jTextField1,      new XYConstraints(26, 69, 362, -1));
    panel1.add(jTextField2,  new XYConstraints(30, 186, 357, 26));
    panel1.add(jButton1, new XYConstraints(166, 125, -1, -1));
  }

  void jButton1_actionPerformed(ActionEvent e) {
    pspakszj00_001 comm = pspakszj00_001.ksz_Get_Instance();
    Vector v = new Vector();
    v.add(jTextField1.getText());
    StringBuffer out = new StringBuffer();
    comm.ksz_Send_Request("1","001","123",v,out);
    jTextField2.setText(new String(out));

  }
}