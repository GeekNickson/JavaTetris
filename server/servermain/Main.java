package servermain;

import game.*;
import netcomm.TetrisServer;

public class Main {
	public static void main(String args[]) {
		Thread serverMainThread = new Thread(new TetrisServer(1500));
		serverMainThread.run();
		
		GameField field = new GameField();
		field.game();
	}
}
