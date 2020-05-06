import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("deprecation")
public class ACMGraphics extends Applet {
	private ArrayList<GRect> gObjects = new ArrayList<GRect>();

	public void init() {

	}

	public void run() {

	}

	public void paint(Graphics g) {
		for (GRect rect : gObjects) {
			rect.draw(g);
			
		}
	}

	public void add(GRect r) {
		gObjects.add(r);
	}
}
