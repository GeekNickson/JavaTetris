package tttp;

public class ResponseEnd extends Protocol {
	private int score;
	public ResponseEnd(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
}
