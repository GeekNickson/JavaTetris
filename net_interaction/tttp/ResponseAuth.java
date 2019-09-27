package tttp;

public class ResponseAuth extends Protocol {
	private boolean status;
	private String message;
	public ResponseAuth(boolean status, String message) {
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
