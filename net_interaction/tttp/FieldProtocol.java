package tttp;

public class FieldProtocol extends Protocol {
	private int[][] field;
	public FieldProtocol(int[][] field) {
		this.field = field;
	}
	
	public int[][] getField(){
		return field;
	}
}
