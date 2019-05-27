package game;

import java.util.Random;

import timestuff.TimeManager;

public class GameField {
	private static final int W = 10;
	private static final int H = 21;
	
	int rotCount = 0;
	
	PosXY spawnPos = new PosXY(5,1);
	PosXY figCenter = new PosXY(1,1);
	PosXY currentFigPos = spawnPos;
	
	Tetromino fallingTetromino;
	
	// consists only of 0 and 1
	// x counts from left to right
	// y counts from top to bottom
	int field[][] = new int[W][H];
	
	public GameField() {
		// fill with zeros
		for(int x = 0; x < W; x++) {
			for(int y = 0; y < H; y++) {
				field[x][y] = 0;
			}
		}
		fallingTetromino = generateTetromino();
	}
	
	//
	private void matrixSum(int[][] fig,PosXY posField,boolean negative) {
		int coef = 1;
		if(negative) coef =-1;
		
		PosXY offsetFig = new PosXY(0,0);
		PosXY offsetField = new PosXY(posField.x - figCenter.x, posField.y - figCenter.y);
		for(int y = 0; y < (fig.length); y++) {
			for(int x = 0; x < (fig[0].length); x++) {
				field[x+offsetField.x][y+offsetField.y] =
						field[x+offsetField.x][y+offsetField.y]+ coef*fig[y][x];
			}
		}
	}
	
	public void game() {
		spawnTetromino();
		TimeManager time = new TimeManager(250);
		while(true) {
			if(time.nextTick()){
				moveDown();
				rotateCW();
				printField();
			}
		}
	}
	
	//
	private boolean spawnTetromino() {
		boolean result = false;
		fallingTetromino = generateTetromino();
		currentFigPos = spawnPos;
		// if there's a collision with already placed figures, the game is over
		matrixSum(fallingTetromino.getShape(),spawnPos,false);
		
		
		return result;
	}
	
	
	private boolean moveTetromino() {
		boolean result = false;
		
		
		
		return result;
	}
	
	//moving methods
	private void moveDown() {
		matrixSum(fallingTetromino.getShape(),currentFigPos,true);
		currentFigPos.y+=1;
		
		matrixSum(fallingTetromino.getShape(),currentFigPos,false);
	}
	
	private void moveLeft() {
		eraseFig();
		currentFigPos.x-=1;
		drawFig();
	}
	private void moveRight() {
		eraseFig();
		currentFigPos.x+=1;
		drawFig();
	}
	
	private void rotateCW(){
		eraseFig();
		fallingTetromino.rotateCW();
		drawFig();
	}
	
	private void rotateCCW(){
		eraseFig();
		fallingTetromino.rotateCCW();
		drawFig();
	}
	
	private void eraseFig() {
		matrixSum(fallingTetromino.getShape(),currentFigPos,true);
	}
	
	private void drawFig() {
		matrixSum(fallingTetromino.getShape(),currentFigPos,false);
	}
	
	
	private void descendRow(int row) {
		for(int y = row; y < 1 ;y--) {
			for (int x = 0; x < W; x++) {
				field[x][y] = field[x][y-1];
			}
		}
		
		//place zeros at the upper row
		for (int x = 0; x < W; x++) {
			field[x][0] = 0;
		}
	}
	
	
	private int burnFullRows() {
		int burned = 0;
		for(int y = 0; y < H; y++) {
			int t = 1;
			for(int x = 0; x < W; x++) {
				t = t * field[x][y];
			}
			if(t > 0) {
				descendRow(y);
				burned += 1;
			}
		}
		return burned;
	}
	
	//choosing the next Tetromino
	private Tetromino generateTetromino() {
		Tetromino res = null;
		Random r = new Random();
		int random = r.nextInt(7);
		
		switch(random) {
			case 0:
				res = new TetroI();
				break;
			case 1:
				res = new TetroJ();
				break;
			case 2:
				res = new TetroL();
				break;
			case 3:
				res = new TetroO();
				break;
			case 4:
				res = new TetroS();
				break;
			case 5:
				res = new TetroZ();
				break;
			case 6:
				res = new TetroT();
				break;
		}
		return res;
	}
	
	public void printField() {
		for(int y = 0; y < H ;y++) {
			for (int x = 0; x < W; x++) {
				String square = field[x][y]>0 ? "1" : "0"; 
				System.out.print(square);
			}
			System.out.println();
		}
	}
	
}
