package gui;

import java.awt.*;
import javax.swing.*;

public class ServerForm extends JFrame {
	private static final long serialVersionUID = 1L;

	JLabel usernameLabel;
	JLabel ipLabel;
	JLabel portLabel;
	JTextField usernameTextField;
	JTextField ipAddressTextField;
	JTextField portTextField;
	JButton connectButton;
	Font mainFont = new Font("Comic Sans MS", Font.PLAIN, 24);

	public ServerForm() {
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(50, 50, 130, 30);
		usernameLabel.setFont(mainFont);
		add(usernameLabel);
		usernameTextField = new JTextField("enter your name");
		usernameTextField.setBounds(200, 50, 200, 30);
		add(usernameTextField);
		ipLabel = new JLabel("Ip address:");
		ipLabel.setBounds(50, 120, 130, 30);
		ipLabel.setFont(mainFont);
		add(ipLabel);
		ipAddressTextField = new JTextField("enter server's ip");
		ipAddressTextField.setBounds(200, 120, 200, 30);
		add(ipAddressTextField);
		portLabel = new JLabel("Used port:");
		portLabel.setBounds(50, 190, 130, 30);
		portLabel.setFont(mainFont);
		add(portLabel);
		portTextField = new JTextField("5050");
		portTextField.setBounds(200, 190, 200, 30);
		add(portTextField);
		connectButton = new JButton("Connect");
		connectButton.setBounds(150, 260, 200, 30);
		connectButton.setFont(mainFont);
		connectButton.setBackground(new Color(247, 170, 232));
		add(connectButton);
		getContentPane().setBackground(new Color(240, 240, 240));
		setSize(500, 400);
		setVisible(true);
	}

	public JLabel getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}

	public JLabel getIpLabel() {
		return ipLabel;
	}

	public void setIpLabel(JLabel ipLabel) {
		this.ipLabel = ipLabel;
	}

	public JLabel getPortLabel() {
		return portLabel;
	}

	public void setPortLabel(JLabel portLabel) {
		this.portLabel = portLabel;
	}

	public JTextField getUsernameTextField() {
		return usernameTextField;
	}

	public void setUsernameTextField(JTextField usernameTextField) {
		this.usernameTextField = usernameTextField;
	}

	public JTextField getIpAddressTextField() {
		return ipAddressTextField;
	}

	public void setIpAddressTextField(JTextField ipAddressTextField) {
		this.ipAddressTextField = ipAddressTextField;
	}

	public JTextField getPortTextField() {
		return portTextField;
	}

	public void setPortTextField(JTextField portTextField) {
		this.portTextField = portTextField;
	}

	public JButton getConnectButton() {
		return connectButton;
	}

	public void setConnectButton(JButton connectButton) {
		this.connectButton = connectButton;
	}

}
