package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import game.GameField;

public class TetrisGrid extends Canvas implements ActionListener{
	Timer timer = new Timer(150,this);
	private int columns = 10;
	private int rows = 21;
	private int gridLineThiccness = 3;
	private int cellSize = 25;
	private int offset = (int) Math.ceil(gridLineThiccness / 2.0);
	private int leftOffset = offset;
	private int rightOffset = leftOffset + gridLineThiccness;
	private int width = columns * cellSize;
	private int height = rows * cellSize;
	private Color figColor = new Color(144, 144, 255);
	private Color frameWhite = new Color(100, 100, 100);
	
	MainFrame mainFrame;
	
	int field[][] = new int[rows][columns];

	public TetrisGrid() {
		//updateSize();
	}

	public TetrisGrid(MainFrame mainFrame ,int rows, int columns) {
		this.mainFrame = mainFrame;
		this.columns = columns;
		this.rows = rows;
		//updateSize();
	}

	public void paint(Graphics g) {
		super.paint(g);
		paintField(g);
		//paintGrid(g);
	}

	public void update(Graphics g) {
		super.update(g);
	}
	
	public void updateField(int [][] field) {
		this.field = field;
	}
	
	public void paintField(Graphics g) {
		//Random ran = new Random();
		for(int y = 0; y < rows ;y++) {
			for (int x = 0; x < columns; x++) {
				Color color = (field[y][x]>0)? figColor:frameWhite;
				g.setColor(color);
				g.fillRect(x*cellSize,y*cellSize,cellSize,cellSize);
			}
		}
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
	
	public void startGame() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
	    if(ae.getSource()==timer){
	    	GameField.getInstance().triggerUpdate();
	    	field = GameField.getInstance().getField();
	    	mainFrame.getCurrentScoreLabel().setText(Integer.toString(GameField.getInstance().getScore()));
	    	repaint();
	    }
	}
	
	
}