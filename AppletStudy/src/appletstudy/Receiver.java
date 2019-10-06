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
  /**引数値の取得*/
  public String getParameter(String key, String def) {
    return isStandalone ? System.getProperty(key, def) :
      (getParameter(key) != null ? getParameter(key) : def);
  }

  /**アプレットの構築*/
  public Receiver() {
  }
  /**アプレットの初期化*/
  public void init() {
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
  /**コンポーネントの初期化*/
  private void jbInit() throws Exception {
    jTextField1.setText("jTextField1");
    this.setLayout(xYLayout1);
    this.add(jTextField1, new XYConstraints(54, 85, 290, -1));
  }
  /**アプレットの情報取得*/
  public String getAppletInfo() {
    return "Applet Information";
  }
  /**引数情報の取得*/
  public String[][] getParameterInfo() {
    return null;
  }

  public void receive(String str){

        jTextField1.setText(str);
  }
}