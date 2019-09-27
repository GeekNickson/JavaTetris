package game;

public class TetroS extends Tetromino {
	//S
	
	public TetroS() {
		int[][][] shapeInit ={ 
				{{0, 1, 1}, 
			 	 {1, 1, 0}}
				,
				{{1, 0}, 
			 	 {1, 1},
			 	 {0, 1}}
				,
				{{0, 1, 1},
			 	 {1, 1, 0}}
				,
				{{1, 0}, 
			 	 {1, 1},
			 	 {0, 1}}	
				};
		shape = shapeInit;
	}
}
