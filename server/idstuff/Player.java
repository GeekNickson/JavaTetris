package idstuff;

public class Player {
	public static final int WRONG_PASS = -2;
	public static final int WRONG_NAME = -3;
	
	private String name = "name";
	private String password = "pass";
	private int maxScore = -1;
	private int id = -1;
	
	public Player(int id) {
		this.id = id;
	}
	
	public Player(String name,String password) {
		this.name = name;
		this.password = password;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Player)) {
			return false;
		}
		Player objPl = (Player) obj;
		// equality provided by matching name and p|assword
		return (objPl.name == name)&&(objPl.password == password);
	}
	public String getName() {
		return name;
	}
	
	// 
	public boolean match(String name, String password) {
		return (this.name == name)&&(this.password == password);
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	
}
