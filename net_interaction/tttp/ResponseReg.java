package tttp;

public class ResponseReg extends Protocol {
	private boolean status;
	private String message;
	public ResponseReg(boolean status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public boolean getStatus() {
		return status;
	}
	
	public String getMessage() {
		return message;
	}
}
