package shape;

import java.awt.Graphics;

public class Hello extends HW1Shape {

        public Hello(int x, int y){
            super(x,y);
        }

        //@Override
	public void draw(Graphics graphics) {
		graphics .drawString("Hello world", this.x, this.y);
	}

}