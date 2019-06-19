package game;

public class Tetromino {
	PosXY center = new PosXY(1,1);
	
	int[] emptyBottomRows;
	int[] emptyLeftRows;
	int[] emptyRightRows;
	int[][][] shape;
	
	//rotation counter
	int rotCount = 0;
	
	//clockwise
	void rotateCW() {
		rotCount = (rotCount+1)%4;
	}
	
	//counterclockwise
	void rotateCCW() {
		int res = rotCount - 1;
		rotCount = res < 0 ? 3 :res;
	}
	
	public int[][] getShape(){
		return shape[rotCount];
	}
}
