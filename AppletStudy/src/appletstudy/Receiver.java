package appletstudy;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;

public class Receiver extends Applet {
  boolean isStandalone = false;
  JTextField jTextField1 = new JTextField();
  XYLayout xYLayout1 = new XYLayout();
  /**�����l�̎擾*/
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  /**�A�v���b�g�̍\�z*/
  public Receiver() {
  }
  /**�A�v���b�g�̏�����*/
  public void init() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  /**�R���|�[�l���g�̏�����*/
  private void jbInit() throws Exception {
    jTextField1.setText("jTextField1");
    this.setLayout(xYLayout1);
    this.add(jTextField1, new XYConstraints(54, 85, 290, -1));
  }
  /**�A�v���b�g�̏��擾*/
  public String getAppletInfo() {
    return "Applet Information";
  }
  /**�������̎擾*/
  public String[][] getParameterInfo() {
    return null;
  }

  public void receive(String str){

        jTextField1.setText(str);
  }
}