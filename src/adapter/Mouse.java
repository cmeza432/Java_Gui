package adapter;

import java.awt.event.*;
import gui.Canvas;
import shape.HW1Controller;

public class Mouse extends Adapter{
    Canvas canvas;
    HW1Controller controller;

    public Mouse(Canvas canvas, HW1Controller controller){
        this.canvas = canvas;
        this.controller = controller;
        mousePressed();
    }

    public void mousePressed(){
        canvas.addMouseListener(new MouseAdapter() {
         //@Override
         public void mousePressed(MouseEvent e) {
            controller.canvasClicked( (int) e.getPoint().getX(),
               (int) e.getPoint().getY());
            canvas.shapes = controller.getShapes();
            canvas.repaint();
         }
      });
    }
}