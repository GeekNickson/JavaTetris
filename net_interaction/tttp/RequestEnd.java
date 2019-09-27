package tttp;

public class RequestEnd extends Protocol {
	private int score;
	public RequestEnd(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
}
