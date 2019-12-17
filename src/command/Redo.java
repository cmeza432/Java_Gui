package command;

import shape.HW1Shape;

public class Redo implements Command {
    private HW1Shape shapes;

    public Redo(HW1Shape shapes){
        this.shapes = shapes;
    }

    public void execute() {
        shapes.redo();
    }
}