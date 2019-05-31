package game;

public class TetroL extends Tetromino {
	public TetroL() {
		int[][][]shapeInit ={		
							{{1, 1, 1},
					 	 	 {1, 0, 0}}
							,
							{{1, 1},
						 	 {0, 1},
						 	 {0, 1}}
							,
							{{0, 0, 1},
						 	 {1, 1, 1}}
							,
							{{1, 0},
					 	 	 {1, 0},
					 	 	 {1, 1}}
							,
							};
		shape = shapeInit;
	}
}
