package gui;

import java.awt.*;
import javax.swing.*;

public class ConnectToServerForm extends JFrame {
	private static final long serialVersionUID = 1L;

	private JLabel usernameLabel;
	private JLabel ipLabel;
	private JLabel portLabel;
	private JLabel passwordLabel;
	private JTextField usernameTextField;
	private JTextField ipAddressTextField;
	private JTextField portTextField;
	private JTextField passwordTextField;
	private JButton connectButton;
	private JButton disconnectButton;
	private JButton registerButton;
	private Font mainFont = new Font("Comic Sans MS", Font.PLAIN, 24);

	public ConnectToServerForm() {
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(50, 50, 130, 30);
		usernameLabel.setFont(mainFont);
		add(usernameLabel);
		usernameTextField = new JTextField("enter your name");
		usernameTextField.setBounds(200, 50, 200, 30);
		add(usernameTextField);
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(50,120,130,30);
		passwordLabel.setFont(mainFont);
		add(passwordLabel);
		passwordTextField = new JTextField("enter your password");
		passwordTextField.setBounds(200, 120, 200, 30);
		add(passwordTextField);
		ipLabel = new JLabel("Ip address:");
		ipLabel.setBounds(50, 190, 130, 30);
		ipLabel.setFont(mainFont);
		add(ipLabel);
		ipAddressTextField = new JTextField("enter server's ip");
		ipAddressTextField.setBounds(200, 190, 200, 30);
		add(ipAddressTextField);
		portLabel = new JLabel("Used port:");
		portLabel.setBounds(50, 260, 130, 30);
		portLabel.setFont(mainFont);
		add(portLabel);
		portTextField = new JTextField("5050");
		portTextField.setBounds(200, 260, 200, 30);
		add(portTextField);
		connectButton = new JButton("Connect");
		connectButton.setBounds(30, 330, 200, 30);
		connectButton.setFont(mainFont);
		connectButton.setBackground(new Color(247, 170, 232));
		add(connectButton);
		disconnectButton = new JButton("Disconnect");
		disconnectButton.setBounds(255, 330, 200, 30);
		disconnectButton.setFont(mainFont);
		disconnectButton.setBackground(new Color(247, 170, 232));
		disconnectButton.setEnabled(false);
		add(disconnectButton);
		registerButton = new JButton("Register");
		registerButton.setBounds(150, 400, 200, 30);
		registerButton.setFont(mainFont);
		registerButton.setBackground(new Color(247, 170, 232));
		add(registerButton);
		getContentPane().setBackground(new Color(240, 240, 240));
		setSize(500, 500);
		setVisible(true);
	}
	
	void startServer() {
		usernameTextField.setEnabled(false);
		passwordTextField.setEnabled(false);
		ipAddressTextField.setEnabled(false);
		portTextField.setEnabled(false);
		connectButton.setEnabled(false);
		disconnectButton.setEnabled(true);
	}
	
	void stopServer() {
		usernameTextField.setEnabled(true);
		passwordTextField.setEnabled(true);
		ipAddressTextField.setEnabled(true);
		portTextField.setEnabled(true);
		connectButton.setEnabled(true);
		disconnectButton.setEnabled(false);
	}
	
	public JButton getDisconnectButton() {
		return disconnectButton;
	}

	public void setDisconnectButton(JButton disconnectButton) {
		this.disconnectButton = disconnectButton;
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
