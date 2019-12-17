package gui;

import java.awt.*;
import javax.swing.*;
import shape.HW1Controller;
import adapter.Adapter;
import adapter.buttonAdapter;
import adapter.Mouse;

public class Frame1 extends JFrame {
   JPanel contentPane;           // The Conten panel where all frames will be appended too
   BorderLayout borderLayout1 = new BorderLayout();
   Canvas canvas=new Canvas();      // Canvas where the drawing will be done
   JPanel jPanel1 = new JPanel();   // Panel for buttons to be displayed
   // Create all 5 button instances
   JButton boxButton = new JButton();
   JButton circleButton = new JButton();
   JButton helloButton = new JButton();
   JButton redoButton = new JButton();
   JButton undoButton = new JButton();
   // Create the controller for all the button instances
   private HW1Controller controller;

   public Frame1() {
      super();
      try {
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         jbInit();
      } catch(Exception exception) {
         exception.printStackTrace();
      }
   }

   public HW1Controller getController() {
      return controller;
   }

   private void jbInit() throws Exception {
      contentPane = (JPanel) getContentPane();
      contentPane.setLayout(borderLayout1);
      canvas.setBackground(Color.white);
      canvas.setVisible(true);
      setSize(new Dimension(650, 500));
      setTitle("HW1 GUI");
      jPanel1.setPreferredSize(new Dimension(100, 200));
      boxButton.setText(" Box  ");
      circleButton.setText("Circle");
      helloButton.setText("Hello-world");
      redoButton.setText(" Redo ");
      undoButton.setText(" Undo ");
      contentPane.add(canvas, java.awt.BorderLayout.CENTER);
      contentPane.add(jPanel1, java.awt.BorderLayout.WEST);
      jPanel1.add(circleButton);
      jPanel1.add(boxButton);
      jPanel1.add(helloButton);
      jPanel1.add(redoButton);
      jPanel1.add(undoButton);

      controller=new HW1Controller();
      
      //////// A D A P T E R    P A T T E R N ////////
      // Create instance of the adapter class for the mouse
      Adapter mouse = new Mouse(canvas, controller);
      // Create instances of the adapter classes for each button
      Adapter circle = new buttonAdapter(circleButton, "Circle", controller, canvas);
      Adapter box = new buttonAdapter(boxButton, "Box", controller, canvas);
      Adapter hello = new buttonAdapter(helloButton, "Hello", controller, canvas);
      Adapter undo = new buttonAdapter(undoButton, "Undo", controller, canvas);
      Adapter redo = new buttonAdapter(redoButton, "Redo", controller, canvas);
   }
}