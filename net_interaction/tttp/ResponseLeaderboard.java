package tttp;

import idstuff.IdOperator;
import idstuff.Player;

public class ResponseLeaderboard extends Protocol {
	private Player[] leaders;
	public ResponseLeaderboard() {
		leaders = IdOperator.getInstance().getLeaders(5);
	}
	
	public Player[] getLeaders() {
		return leaders;
	}
}
