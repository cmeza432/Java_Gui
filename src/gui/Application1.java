package gui;

import java.awt.Toolkit;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Dimension;

public class Application1 {
   boolean packFrame = false;
   Frame1 frame;
   public Application1() {
      frame = new Frame1();
      if(packFrame) {
         frame.pack();
      } else {
         frame.validate();
      }

      // Center the window
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      Dimension frameSize = frame.getSize();
      if(frameSize.height > screenSize.height) {
         frameSize.height = screenSize.height;
      }
      if(frameSize.width > screenSize.width) {
         frameSize.width = screenSize.width;
      }
      frame.setLocation( (screenSize.width - frameSize.width) / 2,
         (screenSize.height - frameSize.height) / 2);
      frame.setVisible(true);
   }
   
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            try {
               UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch(Exception exception) {
               exception.printStackTrace();
            }
            Application1 app=new Application1();
            app.frame.canvas.repaint();
         }
      });
   }
}
