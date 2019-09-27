package gui;

import java.awt.*;
import java.awt.event.*;
import tttp.*;
import general_controller.*;

public class MainFrameListener implements ActionListener {

	MainFrame mainFrame;

	public MainFrameListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		mainFrame.getConnectButton().addActionListener(this);
		mainFrame.getDisconnectButton().addActionListener(this);
		mainFrame.getRegisterButton().addActionListener(this);
		mainFrame.getLoginButton().addActionListener(this);
		mainFrame.getPlayButton().addActionListener(this);
		mainFrame.getLevelOneButton().addActionListener(this);
		mainFrame.getLevelFiveButton().addActionListener(this);
		mainFrame.getLevelTenButton().addActionListener(this);
		mainFrame.getLevelFifteenButton().addActionListener(this);
		mainFrame.getLevelTwentyButton().addActionListener(this);
		mainFrame.getLevelTwentyFiveButton().addActionListener(this);
		mainFrame.getSurrenderButton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == mainFrame.getConnectButton()) {
			// TODO send username and password to the server
			
			String ip = mainFrame.getIpAddressTextField().getText();
			int port = Integer.parseInt(mainFrame.getPortTextField().getText());
			GeneralController.connect(ip, port);
			mainFrame.updateLeaders();
			//RequestAuth a = new RequestAuth(username, password);
			//System.out.println(a.getName()+ a.getPass());

		}
		if(event.getSource() == mainFrame.getLoginButton()) {
			System.out.println("login button pressed");
			mainFrame.login();
			String username = mainFrame.getUsernameTextField().getText();
			String password = mainFrame.getPasswordTextField().getText();
			GeneralController.login(new RequestAuth(username, password));
		}
		if (event.getSource() == mainFrame.getDisconnectButton()) {
			GeneralController.disconnect();
			mainFrame.disconnectFromServer();
		}
		if (event.getSource() == mainFrame.getRegisterButton()) {
			RegisterFrame regFrame = new RegisterFrame();
			RegisterFrameListener regFrameListener = new RegisterFrameListener(regFrame, mainFrame);
			mainFrame.setEnabled(false);
		}
		if (event.getSource() == mainFrame.getPlayButton()) {
			mainFrame.playTetris();
			// TODO send chosen level to the server
			GeneralController.play();
		}
		if (event.getSource() == mainFrame.getLevelOneButton()) {
			mainFrame.setChosenLevel(1);
		}
		if (event.getSource() == mainFrame.getLevelFiveButton()) {
			mainFrame.setChosenLevel(5);
		}
		if (event.getSource() == mainFrame.getLevelTenButton()) {
			mainFrame.setChosenLevel(10);
		}
		if (event.getSource() == mainFrame.getLevelFifteenButton()) {
			mainFrame.setChosenLevel(15);
		}
		if (event.getSource() == mainFrame.getLevelTwentyButton()) {
			mainFrame.setChosenLevel(20);
		}
		if (event.getSource() == mainFrame.getLevelTwentyFiveButton()) {
			mainFrame.setChosenLevel(25);
		}
		if(event.getSource() == mainFrame.getSurrenderButton()) {
			//TODO create endgame frame
			EndFrame endFrame = new EndFrame();
			endFrame.getActualScoreLabel().setText(mainFrame.getCurrentScoreLabel().getText());
			EndFrameListener endFrameListener = new EndFrameListener(endFrame, mainFrame);
			GeneralController.surrender(Integer.parseInt(mainFrame.getCurrentScoreLabel().getText()));
			mainFrame.updateLeaders();
			mainFrame.setEnabled(false);
		}
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}
}
