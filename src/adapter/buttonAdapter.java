package adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import shape.HW1Controller;

import javax.swing.Action;
import javax.swing.JButton;

import gui.Canvas;

public class buttonAdapter extends Adapter {
    private JButton button;
    private String button_type;
    private HW1Controller controller;
    private Canvas canvas;

    public buttonAdapter(JButton button, String button_type, HW1Controller controller, Canvas canvas) {
        this.button = button;
        this.button_type = button_type;
        this.controller = controller;
        this.canvas = canvas;
        actionPerformed();
    }

    public void actionPerformed() {
        button.addActionListener(new ActionListener() {
            //@Override
            public void actionPerformed(ActionEvent e) {
                if(button_type == "Circle"){
                    controller.cirClicked();
                }
                else if(button_type == "Box"){
                    controller.boxClicked();
                }
                else if(button_type == "Hello"){
                    controller.hloClicked();
                }
                else if(button_type == "Redo"){
                    controller.redoClicked();
                    canvas.repaint();
                }
                else if(button_type == "Undo"){
                    controller.undoClicked();
                    canvas.repaint();
                }
            }
        });
    }
}