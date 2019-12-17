package shape;

import command.Command;
import command.Redo;
import command.Undo;

public class HW1Controller {
   private final int INIT = 0, BOX = 1, CIR = 2, HLO = 3;
   private int state = INIT;
   HW1Shape shapes;

   public HW1Controller() {
      shapes = new Shapes();
   }

   public HW1Shape getShapes() {
      return shapes;
   }

   public void boxClicked() {
      state = BOX;
   }

   public void cirClicked() {
      state = CIR;
   }
   // Hello World button, save state to value of 3
   public void hloClicked(){
      state = HLO;
   }
   /////// C O M M A N D    P A T T E R N ///////
   public void redoClicked(){
      Command redo = new Redo(shapes);
      redo.execute();
      state = INIT;
   }
   public void undoClicked(){
      Command undo = new Undo(shapes);
      undo.execute();
      state = INIT;
   }
   /////////////////////////////////////////////
   public void canvasClicked(int x, int y) {
      switch(state) {
         case INIT:
            return;
         case BOX:
            HW1Shape shape = new Box(x, y);
            shapes.add(shape);
            return;
         case CIR:
            shape = new Circle(x, y);
            shapes.add(shape);
            return;
         case HLO:
            shape = new Hello(x, y);
            shapes.add(shape);
      }
   }
}
