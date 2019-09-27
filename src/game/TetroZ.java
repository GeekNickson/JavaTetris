package game;

public class TetroZ extends Tetromino {
	//Z
	
	public TetroZ() {
		int[][][] shapeInit = {
				{{1, 1, 0},
				 {0, 1, 1}}
				,
				{{0, 1},
				 {1, 1},
				 {1, 0}}
				,
				{{1, 1, 0},
				 {0, 1, 1}}
				,
				{{0, 1},
				 {1, 1},
				 {1, 0}}
				};
		shape = shapeInit;
	}
}
