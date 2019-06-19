package game;

public class TetroT extends Tetromino {
	//T

	public TetroT() {
		int[][][] shapeInit = {
				{{1, 1, 1},
			 	 {0, 1, 0}}
				,
				{{0, 1},
		 	 	 {1, 1},
			 	 {0, 1}}
				,
				{{0, 1, 0},
			 	 {1, 1, 1}}
				,
				{{1, 0},
			 	 {1, 1},
			 	 {1, 0}}
				};
		shape = shapeInit;
	}
}
