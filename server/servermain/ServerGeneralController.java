package servermain;

import idstuff.*;
import netcomm.*;

public class ServerGeneralController {
	IdOperator idOperator;
	public static void main(String args[]) {
		Thread serverMainThread = new Thread(new TetrisServer());
		serverMainThread.run();
	}
}
