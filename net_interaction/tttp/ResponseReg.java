package tttp;

public class ResponseReg extends Protocol {
	private boolean status;
	public ResponseReg(boolean status) {
		this.status = status;
	}
	
	boolean getStatus() {
		return status;
	}
}
