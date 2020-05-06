import java.awt.Graphics;

public class GRect {
	public int x, y, w, h;

	public GRect(int x, int y, int w, int h) {
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	public void draw(Graphics g) {
		g.drawRect(x, y, w, h);
	}
}
