package appletstudy;

import javax.swing.UIManager;
import java.awt.*;

public class Application1 {
  boolean packFrame = false;

  /**アプリケーションの構築*/
  public Application1() {
    Frame1 frame = new Frame1();
    //validate() はサイズを調整する
    //pack() は有効なサイズ情報をレイアウトなどから取得する
    if (packFrame) {
      frame.pack();
    }
    else {
      frame.validate();
    }
    //ウィンドウを中央に配置
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    frame.setVisible(true);
  }
  /**Main メソッド*/
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new Application1();
  }
}