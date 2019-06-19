package game;

public class TetroI extends Tetromino {
	//I
	public TetroI() {
		int[][][] shapeInit ={
				  {{1, 1, 1, 1}}
				  ,
				  {{1},
				   {1},
				   {1},
				   {1}}
				  ,
				  {{1, 1, 1, 1}}
				  ,
				  {{1},
				   {1},
				   {1},
				   {1}}
				  };
		shape = shapeInit;
		int[] emptyBotInit = {2,0,1,0};
		//botto
	}
}
