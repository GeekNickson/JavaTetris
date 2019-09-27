package timestuff;

import java.util.Date;

import game.GameField;
import gui.TetrisGrid;

public class FpsControl implements Runnable{
	private int fps = 30;
	private Date time = new Date(); // time provider
	private long prevTime;
	private long tickDuration;
	private TetrisGrid grid;
	
	public FpsControl(TetrisGrid grid, int fps) {
		this.fps = fps;
		tickDuration = (long)(1000/fps);
		prevTime = time.getTime();
		this.grid = grid;
	}
	
	
	public boolean nextTick() {
		time = new Date();
		long nowTime = time.getTime();
		boolean res = (nowTime - prevTime) >= tickDuration;
		if (res) prevTime = time.getTime();
		//System.out.println("nowTime:" + nowTime + "---- prevTime:"+prevTime);
		return res;
	}


	@Override
	public void run() {
		//triggering grid to repaint
		while(true) {
			if(nextTick()) {
				grid.updateField(GameField.getInstance().getField());
				//GameField.getInstance().printField();
				GameField.getInstance().triggerUpdate();
				grid.repaint();
			}
		}
	}

}
