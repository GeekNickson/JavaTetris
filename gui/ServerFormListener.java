package gui;

import java.awt.event.*;

public class ServerFormListener implements ActionListener {

	ServerForm sf;
	public ServerFormListener(ServerForm sf) {
		this.sf = sf;
		sf.getConnectButton().addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == sf.getConnectButton()) {
			String username = sf.getUsernameTextField().getText();
			String ip = sf.getIpAddressTextField().getText();
			String port = sf.getPortTextField().getText();
			//TODO Send these strings to the server so it can check them
			//System.out.println(username + " " + ip + " " + port);
			
		}
	}
}
