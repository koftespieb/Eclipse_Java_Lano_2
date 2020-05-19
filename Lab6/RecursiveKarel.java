import java.awt.Color;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class RecursiveKarel extends GraphicsProgram {
	private final int SIZE = 500;

	public void init() {
		setSize(SIZE, SIZE);
	}

	public void run() {
		drawKarel(4.0, 10, -40);
	}

	private void drawKarel(double scale, int x, int y) {
		GImage karel = new GImage("Lab6/Karel0.png");
		karel.scale(scale);

		add(karel, (SIZE - karel.getWidth()) / 2 + x, (SIZE - karel.getHeight()) / 2 + y);
		if (karel.getWidth() < 2) {// base case
			return;
		} else { //recursive case
			drawKarel(scale / 2.0, x += (5 * scale), y -= (2.5 * scale));
		}
	}
}
