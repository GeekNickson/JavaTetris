package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.GameField;

public class TetrisGridListener implements KeyListener {
	private TetrisGrid tetrisGrid;
	public TetrisGridListener(TetrisGrid tetrisGrid) {
		this.tetrisGrid = tetrisGrid;
		this.tetrisGrid.addKeyListener(this);
	}
	@Override
	public void keyPressed(KeyEvent event) {
	
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		int keyCode = event.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_DOWN:
			//System.out.println("down was pressed");
			//TODO move down
			GameField.getInstance().moveDown();
			break;
		case KeyEvent.VK_UP:
			System.out.println("up was pressed");
			//TODO move up
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left was pressed");
			//TODO move left
			GameField.getInstance().moveLeft();
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right was pressed");
			//TODO move right
			GameField.getInstance().moveRight();
			break;
		case KeyEvent.VK_Z:
			//TODO rotate ccw
			System.out.println("Z was pressed");
			GameField.getInstance().rotateCCW();
			break;
		case KeyEvent.VK_C:
			System.out.println("C was pressed");
			//TODO rotate cw
			GameField.getInstance().rotateCW();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent event) {
		// TODO Auto-generated method stub
		
	}

}
