package tttp;

public class RequestStart extends Protocol {
	private int level;
	public RequestStart(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
}
