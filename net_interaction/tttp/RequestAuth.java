package tttp;

public class RequestAuth extends Protocol {
	private String name;
	private String pass;
	
	public RequestAuth(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public String getPass() {
		return pass;
	}
	
}
