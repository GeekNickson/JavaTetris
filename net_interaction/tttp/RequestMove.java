package tttp;

enum Moves{
		LEFT,
		RIGHT,
		DOWN,
		CW,		//rotate clockwise 
		CCW		//rotate counterclockwise
	};

public class RequestMove extends Protocol {
	Moves msg;
	public RequestMove(Moves msg) {
		this.msg = msg;
	}
	
	Moves getMsg(){
		//TODO Auto-degenerated method stub
		return msg;
	}
}

