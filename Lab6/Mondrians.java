import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class Mondrians extends GraphicsProgram {
	private final int SIZE = 500;
	private final int MIN_SIZE = 50;
	RandomGenerator rgen = new RandomGenerator();

	public void init() {
		setSize(SIZE, SIZE);

	}

	public void run() {
		drawMondrian(0, 0, SIZE, SIZE);
	}

	private void drawMondrian(int x, int y, int w, int h) {
		// base case
		if (w < MIN_SIZE || h < MIN_SIZE) {
			return;
		}

		// recursive case
		int choice = rgen.nextInt(0, 2);

		switch (choice) {
		case 0: // divide canvas verticaly
			drawMondrian(x, y, w / 2, h);
			drawMondrian(x + w / 2, y, w / 2, h);
			break;
		case 1: // divide canvas horrizontaly
			drawMondrian(x, y, w, h / 2);
			drawMondrian(x, y + h / 2, w / 2, h);
			break;
		default: // do nothiing
			draweRect(x, y, w, h);
			break;
		}

	}

	private void draweRect(int x, int y, int w, int h) {
		GRect rect = new GRect(x, y, w, h);
		rect.setFilled(true);
		rect.setFillColor(rgen.nextColor());
		add(rect);

	}
}
