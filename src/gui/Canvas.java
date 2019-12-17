package gui;

import javax.swing.*;
import java.awt.*;
import shape.*;

public class Canvas extends JPanel {
   public HW1Shape shapes;
   
   public Canvas() {
      super();
   }

   public void setShapes(HW1Shape shapes) {
      this.shapes=shapes;
   }

   //@Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (shapes!=null) shapes.draw(g);
   }
}
