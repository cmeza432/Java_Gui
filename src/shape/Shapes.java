package shape;

import java.awt.Graphics;
import java.util.*;

public class Shapes extends HW1Shape {
   ArrayList<HW1Shape> collection;
   ArrayList<HW1Shape> popped = new ArrayList<HW1Shape> ();

   public Shapes() {
        super(0, 0);
        collection = new ArrayList<HW1Shape> ();
   }
   public void add(HW1Shape s) {
        collection.add(s);
        popped.clear();
   }
   // Push into popped stack, then remove lasts shape from collection
   public void undo(){
        popped.add(collection.get(collection.size() - 1));
        collection.remove(collection.size() - 1);
   }
   // Pop from popped stack into collection, then remove from popped
   public void redo(){
        collection.add(popped.get(popped.size() - 1));
        popped.remove(popped.size() - 1);
   }

   public void draw(Graphics graphics) {
      Iterator it=collection.iterator();
      while (it.hasNext()) {
         ((HW1Shape)it.next()).draw(graphics);
      }
   }
}
