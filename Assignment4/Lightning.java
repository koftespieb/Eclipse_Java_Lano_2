import java.awt.Color;

import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;

public class Lightning extends GraphicsProgram {
	private static final int SIZE = 500;
	private static final int X_P1 = 60;
	private static final int X_P2 = 440;
	private static final int Y_P1 = SIZE / 2;
	private static final int Y_P2 = SIZE / 2 - 70;

	boolean start = false;
	public double displacement = 240;

	public void init() {
		setSize(SIZE, SIZE);
		setBackground(Color.DARK_GRAY);
	}

	public void run() {
		drawPoint(X_P1, Y_P1);
		drawPoint(X_P2, Y_P2);
		while (true) {
			drawLightning(X_P1 + 15, Y_P1 + 15, X_P2 + 15, Y_P2 + 15, displacement);
			pause(140);
		}

	}

	private void drawLightning(double x1, double y1, double x2, double y2, double displacement) {
		// base case
		if (displacement < 2) {
			drawLine(x1, y1, x2, y2);
		} else {
			double mid_x = (x1 + x2) / 2.0;
			double mid_y = (y1 + y2) / 2.0;
			mid_x += (Math.random() - 0.5) * displacement;
			mid_y += (Math.random() - 0.5) * displacement;
			drawLightning(x1, y1, mid_x, mid_y, displacement / 2);
			drawLightning(x2, y2, mid_x, mid_y, displacement / 2);

		}
	}

	private void drawLine(double x1, double y1, double x2, double y2) {
		GLine line = new GLine(x1, y1, x2, y2);
		line.setColor(Color.white);
		add(line);
		line.sendToBack();

	}

	private void drawPoint(int x, int y) {
		GOval p = new GOval(30, 30);
		p.setColor(Color.white);
		p.setFilled(true);
		p.setFillColor(Color.white);
		add(p, x, y);

	}
}
