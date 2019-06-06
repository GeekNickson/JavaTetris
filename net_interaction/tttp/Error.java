package tttp;

public class Error extends Protocol {
	private String text;
	public Error(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
}
