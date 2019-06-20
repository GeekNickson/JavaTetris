package game;

import java.util.ArrayList;
import java.util.Random;

import gui.TetrisGrid;
import timestuff.TimeManager;

public class GameField{
	private static GameField gameField = new GameField();

    public static GameField getInstance() {
        if (gameField == null)
        	gameField = new GameField();

        return gameField;
    }
    private TetrisGrid grid;
    
    boolean falling = false;
	private static final int W = 10;
	private static final int H = 21;
	int level = 1;
	//int figColor = 255;
	
	int rotCount = 0;
	
	PosXY spawnPos = new PosXY(5,1);
	PosXY figCenter = new PosXY(1,1);
	PosXY currentFigPos = spawnPos;
	
	Tetromino fallingTetromino;
	
	int score=0;
	
	TimeManager time;
	
	// consists only of 0 and 1
	// x counts from left to right
	// y counts from top to bottom
	int field[][] = new int[W][H];
	
	boolean gameLasts = true;
	
	public GameField() {
		// fill with zeros
		time = new TimeManager((int)(1000/level));
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
	
	private PosXY[] getFigCoordinates(int[][] fig,PosXY posField) {
		PosXY[] res = new PosXY[4];
		PosXY offsetField = new PosXY(posField.x - figCenter.x, posField.y - figCenter.y);
		int count = 0;
		for(int y = 0; y < (fig.length); y++) {
			for(int x = 0; x < (fig[0].length); x++) {
				if(fig[y][x]>0) res[count++]=new PosXY(x+offsetField.x, y+offsetField.y);
			}
		}
		return res;
	}
	
	private ArrayList<PosXY> getFigBotCoordinates(int[][] fig,PosXY posField) {
		ArrayList<PosXY> res = new ArrayList<PosXY>();
		PosXY offsetField = new PosXY(posField.x - figCenter.x, posField.y - figCenter.y);
		int count = 0;
		for(int x = 0; x < (fig[0].length); x++) {
			for(int y = (fig.length)-1; y >= 0; y--) {
				if(fig[y][x]>0) {
					res.add(new PosXY(x+offsetField.x, y+offsetField.y));
					break;
				}
			}
		}
		return res;
	}
	
	//
	private boolean spawnTetromino() {
		boolean result = false;
		fallingTetromino = generateTetromino();
		currentFigPos = new PosXY(spawnPos.x,spawnPos.y);
		// if there's a collision with already placed figures, the game is over
		matrixSum(fallingTetromino.getShape(),spawnPos,false);
		return result;
	}
	
	
	//moving methods
	public void moveDown() {
		eraseFig();
		currentFigPos.y+=1;
		drawFig();
	}
	
	public void moveLeft() {
		eraseFig();
		currentFigPos.x-=1;
		drawFig();
	}
	public void moveRight() {
		eraseFig();
		currentFigPos.x+=1;
		drawFig();
	}
	
	public void rotateCW(){
		eraseFig();
		fallingTetromino.rotateCW();
		drawFig();
	}
	
	public void rotateCCW(){
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
				field[y][x] = field[y-1][x];
			}
		}
		
		//place zeros at the upper row
		for (int x = 0; x < W; x++) {
			field[x][0] = 0;
		}
	}
	
	
	private void burnFullRows() {
		int burned = 0;
		for(int y = 0; y < H; y++) {
			int t = 1;
			for(int x = 0; x < W; x++) {
				t = t * field[y][x];
			}
			if(t > 0) {
				descendRow(y);
				burned += 1;
			}
		}
		score+=burned;
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
		System.out.println("---------------------");
		for(int y = 0; y < H ;y++) {
			for (int x = 0; x < W; x++) {
				String square = field[x][y]>0 ? "1" : "0"; 
				System.out.print(square);
			}
			System.out.println();
		}
	}
	
	private boolean canFallDown() {
		ArrayList<PosXY> coords = getFigBotCoordinates(fallingTetromino.getShape(), currentFigPos);
		
		for(PosXY pos: coords) {
			//hit the ground
			if(pos.y>=20) {
				System.out.println("hit");
				return false;
			}
			
			//hit other figures
			if((field[pos.x][pos.y+1]>0)) {
				System.out.println("hit");
				return false;
			}
		}
		return true;
	}
	
	public int[][] getField(){
		return field;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setGrid(TetrisGrid grid) {
		this.grid = grid;
	}
	
	public void startGame() {
		falling = false;
		currentFigPos = spawnPos;
		field = new int[W][H];
		gameLasts = true;
	}
	
	public void stopGame() {
		gameLasts = false;
	}
	

	
	public void triggerUpdate() {
		//System.out.println("triggered");
		if(gameLasts){
			
			//no active figure
			if(!falling) {
				spawnTetromino();
				falling = true;
			}
			
			
			if(time.nextTick()){
				if(canFallDown()) {
					moveDown();
				}else {
					//if hit bottom or other figure below
					burnFullRows();
					falling = false;
				}
			}
		}
	}
}
