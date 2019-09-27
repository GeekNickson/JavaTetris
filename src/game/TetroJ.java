package game;

public class TetroJ extends Tetromino {

	public TetroJ() {
		int[][][] shapeInit ={
					{{1, 1, 1},
					 {0, 0, 1}}
					,
					{{0, 1}, 
				 	 {0, 1},
				 	 {1, 1}}
					,
					{{1, 0, 0}, 
					 {1, 1, 1}}
					,
					{{1, 1}, 
					 {1, 0},
					 {1, 0}}
					};
		shape = shapeInit;
	}
}
