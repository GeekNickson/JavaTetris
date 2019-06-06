package idstuff;

import tttp.*;

public class IdOperator {
	public static final int PLAYER_ALREADY_EXISTS = -4;
	public static final int REGISTER_SUCCESS = -5;
	
	private IdStorage storage;
	
	
	public IdOperator(String storagePath) {
		storage = new IdStorage(storagePath);
	}
	
	public int register(RequestReg request) {
		Player newPlayer = new Player(request.getName(),request.getPass());
		if(storage.contains(newPlayer)) {
			return IdOperator.PLAYER_ALREADY_EXISTS;
		}
		//TODO send message: register fine
		storage.add(newPlayer);
		return IdOperator.REGISTER_SUCCESS;
	}
	
	public Player authenticate(RequestAuth request) {
		Player result = new Player(request.getName(),request.getPass());
		if(!storage.contains(result)) {
			// name match failed
			// there's no player with this name
			// TODO send message: there's no such user
			result.setId(Player.WRONG_NAME);
			return result;
		}
		// we have player with same name so far

		// now we trying to match name-password
		Player authenticatedPlayer = storage.get(result);
		
		if(authenticatedPlayer==null) {
			//password is incorrect
			//TODO send message: password is incorrect
			result.setId(Player.WRONG_PASS);
			return result;
		}
		// TODO send message: auth successful
		return authenticatedPlayer;
	}
}
