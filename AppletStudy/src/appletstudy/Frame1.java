package appletstudy;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.borland.jbcl.layout.*;

public class Frame1 extends JFrame {
  JPanel contentPane;
  XYLayout xYLayout1 = new XYLayout();
  JButton jButton1 = new JButton();
  JTextField jTextField1 = new JTextField();

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
    jButton1.setText("jButton1");
    contentPane.setLayout(xYLayout1);
    this.setSize(new Dimension(400, 300));
    this.setTitle("フレーム タイトル");
    jTextField1.setText("jTextField1");
    contentPane.add(jButton1, new XYConstraints(150, 146, 84, 26));
    contentPane.add(jTextField1, new XYConstraints(74, 92, 237, 23));
  }
  /**ウィンドウが閉じられたときに終了するようにオーバーライド*/
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }
}