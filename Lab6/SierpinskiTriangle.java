import java.awt.Color;

import acm.graphics.GPolygon;
import acm.program.GraphicsProgram;

public class SierpinskiTriangle extends GraphicsProgram {
	private final int SIZE = 1000;
	private final int Y_OFFSET = 24;

	public void init() {
		setSize(SIZE, SIZE);
		setBackground(Color.DARK_GRAY);
	}

	public void run() {
		// drawTriangle(0,0,SIZE,SIZE);
		drawSierpTri(0, 0, SIZE, SIZE - Y_OFFSET);
		
	}

	public void drawSierpTri(double x, double y, double w, double h) {
		drawTriangle(x, y, w, h);

		// base case
		if (w < 2.0 || h < 2.0) {
			return;
		}
		// recursive case
		double w2 = w / 2.0;
		double h2 = h / 2.0;

		drawSierpTri(x, y, w2, h2);
		drawSierpTri(x + (w2 / 2.0), y + h2, w2, h2);
		drawSierpTri(x + w2, y, w2, h2);
		pause(1);
	}

	private void drawTriangle(double x, double y, double w, double h) {
		GPolygon tri = new GPolygon();
		tri.addVertex(x, y);
		tri.addVertex(x + w, y);
		tri.addVertex(x + w / 2.0, y + h);

		tri.setColor(Color.yellow);
		add(tri);

	}
}
