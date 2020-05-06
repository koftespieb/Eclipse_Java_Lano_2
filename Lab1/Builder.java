import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Builder extends GraphicsProgram {
	private int BLOCK_SIZE = 40;

	public void run() {
		addMouseListeners();
	}

	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		x = x / BLOCK_SIZE * BLOCK_SIZE;
		y = y / BLOCK_SIZE * BLOCK_SIZE;

		GRect block = new GRect(BLOCK_SIZE, BLOCK_SIZE);
		block.setFilled(true);
		block.setFillColor(Color.red);
		add(block, x, y);
	}
}
