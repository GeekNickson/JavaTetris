package netcomm;

import java.io.IOException;
import java.net.*;

import idstuff.*;

public class TetrisServer implements Runnable{
	private ServerSocket serverSocket;
	private IdOperator idOperator;
	boolean serverActive;
	
	
	public TetrisServer(ServerSocket socket) {
		serverSocket = socket;
		// loading id-password base
		IdOperator.getInstance().create("Players.txt");
		// activating the server
		serverActive = true;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//listening for client to connect
		while(serverActive) {
			try {
				Socket client = serverSocket.accept();
				Thread clientHandlerThread = new Thread(new ClientHandler(client));
				clientHandlerThread.run();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
