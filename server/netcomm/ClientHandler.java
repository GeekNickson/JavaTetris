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
	ObjectOutputStream output;
	ObjectInputStream input;
	
	//Protocol messageIncoming;
	Protocol messageOutgoing;
	
	public ClientHandler(Socket clientSocket,IdOperator idOperator) {
		socket = clientSocket;
		this.idOperator = idOperator;
		try {
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		auth = false;
	}
	
	@Override
	public void run() {
		//connection established
		// now it's time to listen for the commands
		//and send a responses
		while(true) {
			try {
				//listen for messages
				Protocol messageIncoming = (Protocol)input.readObject();
				processIncomingMessage(messageIncoming);				
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
		if(msg instanceof RequestReg) {
			register((RequestReg)msg);
		}
	}
	
	private void sendResponse() {
		
	}
	
	private void authenticate(RequestAuth authRequest) {
		player = idOperator.authenticate(authRequest);
		Protocol response;
		switch (player.getId()){
			case Player.WRONG_NAME:
				//TODO wrong name message
				//sending a response
				response = new ResponseAuth(false, "There's no user with such name");
				break;
			case Player.WRONG_PASS:
				//TODO wrong pass message
				response = new ResponseAuth(false, "Wrong password");
				break;
			default:
				//authentication successful
				auth = true;
				response = new ResponseAuth(true, "Authentication successfull");
				break;
		}
	}
	
	private void register(RequestReg regRequest) {
		int res = idOperator.register(regRequest);
		Protocol response;
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
	
}
