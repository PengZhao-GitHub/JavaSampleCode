package appletstudy;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;

public class Applet1 extends Applet {
  boolean isStandalone = false;
  String var0;
  JButton jButton1 = new JButton();
  XYLayout xYLayout1 = new XYLayout();
  JTextField jTextField1 = new JTextField();
  JTextField nameField = new JTextField();
  JLabel jLabel1 = new JLabel();
  JTextField status = new JTextField();
  /**�����l�̎擾*/
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  /**�A�v���b�g�̍\�z*/
  public Applet1() {
  }
  /**�A�v���b�g�̏�����*/
  public void init() {
    try {
      var0 = this.getParameter("param0", "");
      jTextField1.setText(var0);
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  /**�R���|�[�l���g�̏�����*/
  private void jbInit() throws Exception {
    jButton1.setText("jButton1");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jButton1_actionPerformed(e);
      }
    });
    this.setLayout(xYLayout1);
    nameField.setText("jTextField2");
    jLabel1.setText("otherApplet\'s Name");
    status.setText("jTextField2");
    this.add(jLabel1, new XYConstraints(48, 56, 120, 20));
    this.add(nameField,  new XYConstraints(163, 57, 157, 19));
    this.add(jTextField1, new XYConstraints(46, 92, 234, 17));
    this.add(jButton1, new XYConstraints(291, 87, -1, -1));
    this.add(status,    new XYConstraints(7, 189, 379, 98));
  }
  /**�A�v���b�g�̏��擾*/
  public String getAppletInfo() {
    return "Applet Information";
  }
  /**�������̎擾*/
  public String[][] getParameterInfo() {
    String[][] pinfo =
      {
      {"param0", "String", ""},
      };
    return pinfo;
  }

  void jButton1_actionPerformed(ActionEvent e) {
        Applet receiver = null;
        String receiverName = nameField.getText(); //Get name to search for.
        receiver = getAppletContext().getApplet(receiverName);
        if (receiver != null) {
	    //Use the instanceof operator to make sure the applet
	    //we found is a Receiver object.
            if (!(receiver instanceof Receiver)) {
                 status.setText("Found applet named "
                                  + receiverName + ", "
                                  + "but it's not a Receiver object.\n");
            } else {
                status.setText("Found applet named "
                                  + receiverName + ".\n"
                                  + "  Sending message to it.\n");
		//Cast the receiver to be a Receiver object
		//(instead of just an Applet object) so that the
		//compiler will let us call a Receiver method.
                ((Receiver)receiver).receive(jTextField1.getText());
            }
        } else {
            status.setText("Couldn't find any applet named "
                              + receiverName + ".\n");
        }
  }
}