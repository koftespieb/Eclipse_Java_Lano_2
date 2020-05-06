import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class EuclidGraphic extends GraphicsProgram {
	private RandomGenerator rgen = new RandomGenerator();

	public void run() {
		IODialog dialog = getDialog();
		int w = dialog.readInt("Enter Width: ");
		int h = dialog.readInt("Enter Height: ");
		int gcd = gcd(w, h);
		dialog.println("GCD is: " + gcd);
	}

	private int gcd(int w, int h) {
		while (h != 0) {
			if (w > h) {
				w = w - h;
				drawRect(w, 0, h, h);
			} else {
				h = h - w;
				drawRect(0, h, w, w);
			}
			pause(500);
		}
		return w;

	}

	public void drawRect(int a, int b, int w, int h) {
		GRect rect = new GRect(a, b, w, h);
		rect.setFilled(true);
		rect.setFillColor(rgen.nextColor());
		add(rect);
	}
}
