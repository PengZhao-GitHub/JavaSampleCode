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
  /**引数値の取得*/
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  /**アプレットの構築*/
  public Applet1() {
  }
  /**アプレットの初期化*/
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
  /**コンポーネントの初期化*/
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
  /**アプレットの情報取得*/
  public String getAppletInfo() {
    return "Applet Information";
  }
  /**引数情報の取得*/
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