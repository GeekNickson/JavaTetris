package general_controller;

import java.io.IOException;
import java.net.UnknownHostException;
import tttp.*;
import communication_logic.*;

public class GeneralController {
	static NetController netController = null;

	public static void connect() {
		try {
			netController = new NetController();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void login(RequestAuth namePass) {
		try {
			netController.login(namePass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void register(RequestReg namePass) {
		try {
			netController.register(namePass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void play(RequestStart level) {
		try {
			netController.sendLevel(level);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
