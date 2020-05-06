import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Pi extends GraphicsProgram {
	private int SIZE = 500;
	private RandomGenerator rgen = new RandomGenerator();
	private int totalPoints = 0;
	private int insidePoints = 0;

	public void init() {
		setSize(SIZE, SIZE);
	}

	public void run() {
		double pi;
		while (true) {
			drawRandomPoint();
			pi = 4.0 * insidePoints / totalPoints;
			println(pi);
		}
	}

	private void drawRandomPoint() {
		double x = rgen.nextDouble();
		double y = rgen.nextDouble();
		GOval point = new GOval(x * SIZE, SIZE - y * SIZE, 3, 3);
		totalPoints++;
		if ((x * x + y * y) > 1.0) {
			point.setFilled(true);
			point.setFillColor(Color.CYAN);
			add(point);
		} else {
			insidePoints++;
			point.setFilled(true);
			point.setColor(Color.yellow);
			add(point);
		}

	}

}
