package command;

import shape.HW1Shape;

public class Undo implements Command {
    private HW1Shape shapes;

    public Undo(HW1Shape shapes){
        this.shapes = shapes;
    }

    public void execute() {
        shapes.undo();
    }
}