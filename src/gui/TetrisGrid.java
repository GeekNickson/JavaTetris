package gui;

import java.awt.*;

public class TetrisGrid extends Canvas {
	private int columns = 10;
	private int rows = 21;
	private int gridLineThiccness = 3;
	private int cellSize = 25;
	private int offset = (int) Math.ceil(gridLineThiccness / 2.0);
	private int leftOffset = offset;
	private int rightOffset = leftOffset + gridLineThiccness;
	private int width = columns * cellSize;
	private int height = rows * cellSize;

	public TetrisGrid() {
		updateSize();
	}

	public TetrisGrid(int rows, int columns) {
		this.columns = columns;
		this.rows = rows;
		updateSize();
	}

	public void paint(Graphics g) {
		super.paint(g);
		paintGrid(g);
	}

	public void update(Graphics g) {
		super.update(g);
	}

	void paintGrid(Graphics g) {
		for (int x = leftOffset; x <= width - rightOffset; x += cellSize) {
			g.setColor(new Color(0, 0, 0));
			g.fillRect(x, 0, gridLineThiccness, height);

		}
		for (int y = leftOffset; y <= height - rightOffset; y += cellSize) {
			g.setColor(new Color(0, 0, 0));
			g.fillRect(0, y, width, gridLineThiccness);
		}
	}

	void updateSize() {
		this.setSize(width + (offset * 2), height + (offset * 2));
		offset = 0;
		leftOffset = offset;
		rightOffset = leftOffset;
		width = columns * cellSize;
		height = rows * cellSize;
	}
	
	
}