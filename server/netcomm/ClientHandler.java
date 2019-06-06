package netcomm;

import java.io.*;
import java.net.*;

import idstuff.*;
import tttp.*;

public class ClientHandler implements Runnable{
	private Socket socket;
	private Player player = null;
	private boolean auth;
	private IdOperator idOperator;
	//Protocol messageIncoming;
	Protocol messageOutgoing;
	
	public ClientHandler(Socket clientSocket,IdOperator idOperator) {
		socket = clientSocket;
		this.idOperator = idOperator;
		auth = false;
	}
	
	@Override
	public void run() {
		//connection established
		// now it's time to listen for the commands
		//and send a responses, triggered by client and by timer
		while(true) {
			try {
				InputStream fromClientIS =  socket.getInputStream();
				ObjectInputStream incomingObjectStream = new ObjectInputStream(fromClientIS);
				if(incomingObjectStream.available()>0) {
					Protocol messageIncoming = (Protocol)incomingObjectStream.readObject();
					processIncomingMessage(messageIncoming);
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void processIncomingMessage(Protocol msg){
		if(msg instanceof RequestAuth) {
			authenticate((RequestAuth) msg);
		}
		if(msg instanceof RequestEnd) {
			endGame((RequestEnd)msg);
		}
		if(msg instanceof RequestMove) {
			move((RequestMove)msg);
		}
		if(msg instanceof RequestReg) {
			register((RequestReg)msg);
		}
		if(msg instanceof RequestStart) {
			start((RequestStart)msg);
		}
	}
	
	private void authenticate(RequestAuth authRequest) {
		player = idOperator.authenticate(authRequest);
		switch (player.getId()){
			case Player.WRONG_NAME:
				//TODO wrong name message
				break;
			case Player.WRONG_PASS:
				//TODO wrong pass message
				break;
			default:
				//authentication successful
				auth = true;
				break;
		}
	}
	
	private void register(RequestReg regRequest) {
		int res = idOperator.register(regRequest);
		switch (res){
			case IdOperator.PLAYER_ALREADY_EXISTS:
				//TODO player already exists message
				break;
			case IdOperator.REGISTER_SUCCESS:
				//TODO register success message
				break;
			default:
				//TODO unknown error
				auth = true;
				break;
		}
	}
	
	private void endGame(RequestEnd endRequest) {
		
	}
	
	private void move(RequestMove moveRequest) {
		
	}
	
	private void start(RequestStart startRequest) {
		
	}
}
