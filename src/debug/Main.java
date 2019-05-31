package debug;
import gui.*;
import general_controller.*;
public class Main {

	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		MainFrameListener mfl = new MainFrameListener(mf);
		//GeneralController.connect();
	}

}
