import java.awt.Color;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Randomness extends GraphicsProgram {
	private final int SIZE = 500;

	private long m = 2147483647L;
	private long a = 7 * 7;
	// 16807;
	private long x = System.currentTimeMillis();

	public void run() {
		setSize(SIZE, SIZE);
		for (int i = 0; i < 10000; i++) {
			int x = nextInt(SIZE);
			int y = nextInt(SIZE);
			setPixel(x, y);
		}
	}

	private void setPixel(int x, int y) {
		GRect pixel = new GRect(x, y, 5, 5);
		pixel.setFilled(true);
		pixel.setFillColor(Color.yellow);
		add(pixel);
	}

	public int nextInt() {
		x = a * x % m;
		return (int) x;
	}

	public int nextInt(int n) {
		int z = nextInt();
		return (int) (z % n);
	}
}
