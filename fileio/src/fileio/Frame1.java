

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;
import javax.swing.border.*;
import java.io.*;


public class Frame1 extends JFrame {
  JPanel contentPane;
  XYLayout xYLayout1 = new XYLayout();
  JTextField jTextField1 = new JTextField();
  JTextArea jTextArea1 = new JTextArea();
  TitledBorder titledBorder1;
  JButton jButton1 = new JButton();
  JButton jButton2 = new JButton();
  JButton jButton3 = new JButton();
  JFileChooser jFileChooser1 = new JFileChooser();
  JButton jButton4 = new JButton();
  JButton jButton5 = new JButton();
  JButton jButton6 = new JButton();

  /**フレームの構築*/
  public Frame1() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  /**コンポーネントの初期化*/
  private void jbInit() throws Exception  {
    //setIconImage(Toolkit.getDefaultToolkit().createImage(Frame1.class.getResource("[Your Icon]")));
    contentPane = (JPanel) this.getContentPane();
    titledBorder1 = new TitledBorder("");
    contentPane.setLayout(xYLayout1);
    this.setSize(new Dimension(403, 357));
    this.setTitle("フレーム タイトル");
    jTextArea1.setBorder(BorderFactory.createLoweredBevelBorder());
    jButton1.setText("Read");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    jButton2.setText("Write");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton2_actionPerformed(e);
      }
    });
    jButton3.setText("Refresh");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton3_actionPerformed(e);
      }
    });
    jButton4.setToolTipText("");
    jButton4.setText("参照");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton4_actionPerformed(e);
      }
    });
    jButton5.setText("System");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton5_actionPerformed(e);
      }
    });
    jButton6.setText("電文テスト");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton6_actionPerformed(e);
      }
    });
    contentPane.add(jTextArea1,   new XYConstraints(10, 16, 371, 168));
    contentPane.add(jButton3,  new XYConstraints(298, 244, 85, 25));
    contentPane.add(jTextField1,     new XYConstraints(10, 201, 303, -1));
    contentPane.add(jButton4, new XYConstraints(317, 201, 65, 21));
    contentPane.add(jButton1,  new XYConstraints(10, 244, 85, 25));
    contentPane.add(jButton2,  new XYConstraints(99, 244, 85, 25));
    contentPane.add(jButton5,       new XYConstraints(10, 283, 86, 24));
    contentPane.add(jButton6,   new XYConstraints(191, 282, 98, 24));
  }
  /**ウィンドウが閉じられたときに終了するようにオーバーライド*/
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  void jButton1_actionPerformed(ActionEvent e) {
          try{
              int i=0;
              char[] buffer = new char[1024];
              int c;
              File inputFile = new File(jTextField1.getText());
              FileReader in = new FileReader(inputFile);

              while((c=in.read())!= -1){
                   buffer[i++] = (char)c;

              }
              System.out.println(i);
              String str = String.valueOf(buffer,0,i);
              jTextArea1.setText(str);
              System.out.println("Length:" + str.getBytes().length);

              in.close();
          } catch(java.io.IOException ex){
              System.out.println(ex);
          }
  }

  void jButton2_actionPerformed(ActionEvent e) {
          try{
              File outputFile = new File(jTextField1.getText());
              FileWriter out = new FileWriter(outputFile);
              out.write(jTextArea1.getText());
              out.close();
          } catch(java.io.IOException ex){
              System.out.println(ex);
          }
  }

  void jButton3_actionPerformed(ActionEvent e) {
          jTextArea1.setText("");
  }

  void jButton4_actionPerformed(ActionEvent e) {
         if (jFileChooser1.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
             jTextField1.setText(jFileChooser1.getSelectedFile().getPath());
         }
  }

  void jButton5_actionPerformed(ActionEvent e) {
      System.out.println(System.getProperty("file.encoding"));
  }

  void jButton6_actionPerformed(ActionEvent e) {
      Dialog1 dlg = new Dialog1(this,"Hello",true);
      dlg.show();

      Object o = dlg.clone();
  }
}