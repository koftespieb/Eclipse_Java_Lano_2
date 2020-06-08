import java.awt.Color;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Tree extends GraphicsProgram {
	RandomGenerator rgen = new RandomGenerator();
	private static final int SIZE = 500;
	private static final double X_START = SIZE / 2;
	private static final double Y_START = SIZE - 24;
	private static final double STAMM_LAENGE = 100;

	public void init() {
		setSize(SIZE, SIZE);
	}

	public void run() {
		drawAst(X_START, Y_START, 1.5708, STAMM_LAENGE);
	}

	private void drawAst(double x, double y, double angle, double length) {
		double x1 = x - Math.cos(angle) * length;
		double y1 = y - Math.sin(angle) * length;

		drawLine(x, y, x1, y1,length);

		// base case
		if (length < 10) {
			return;
		}
		// recursive case
		double bendAngle = Math.toRadians(rgen.nextDouble(-10, 10));
		double branchAngle = Math.toRadians(rgen.nextDouble(-30, 30));
		drawAst(x1, y1, angle + bendAngle - branchAngle, length * rgen.nextDouble(0.6, 0.8));
		drawAst(x1, y1, angle + bendAngle + branchAngle, length * rgen.nextDouble(0.6, 0.8));
	}

	private void drawLine(double x, double y, double x1, double y1,double length) {
		GLine line = new GLine(x, y, x1, y1);
		if(length < 15) {
			line.setColor(Color.GREEN);
		}
		else {
			line.setColor(Color.black);
		}
		add(line);

	}
}
