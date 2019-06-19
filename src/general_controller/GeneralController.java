package general_controller;

import java.io.IOException;
import java.net.UnknownHostException;
import tttp.*;
import communication_logic.*;
import gui.MainFrame;
import gui.MainFrameListener;

public class GeneralController {
	static NetController netController = null;
	static MainFrame mainFrame = null;
	static MainFrameListener mainFrameListener = null;

	public static void initialize() {
		mainFrame = new MainFrame();
		mainFrameListener = new MainFrameListener(mainFrame);
	}

	public static void login(RequestAuth namePass, String ip, int port) {
		try {
			netController = new NetController(ip, port);
			netController.login(namePass);
			ResponseAuth responseAuth = netController.receiveAuthResponce();
			//TODO display this
			if (!responseAuth.getStatus()) {
				System.out.println(responseAuth.getMessage());
				mainFrame.disconnectFromServer();
			} else {
				System.out.println(responseAuth.getMessage());
				mainFrame.connectToServer();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void register(RequestReg namePass) {
		try {
			netController.register(namePass);
			ResponseReg responseReg = netController.receiveRegResponse();
			if (!responseReg.getStatus()) {
				System.out.println(responseReg.getMessage());
			}
			else
				System.out.println(responseReg.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void play(int level) {
		mainFrame.playTetris();
	}
}
