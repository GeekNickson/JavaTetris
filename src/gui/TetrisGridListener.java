package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
			System.out.println("down was pressed");
			//TODO move down
			break;
		case KeyEvent.VK_UP:
			System.out.println("up was pressed");
			//TODO move up
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left was pressed");
			//TODO move left
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right was pressed");
			//TODO move right
			break;
		case KeyEvent.VK_Z:
			//TODO rotate cw
			System.out.println("Z was pressed");
			break;
		case KeyEvent.VK_C:
			System.out.println("C was pressed");
			//TODO rotate ccw
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
