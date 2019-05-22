package gui;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

public class RegisterForm extends JFrame {
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameTextField;
	private JTextField passwordTextField;
	private JButton registerButton;
	private JButton exitButton;
	private Font mainFont = new Font("Comic Sans MS", Font.PLAIN, 24);

	public RegisterForm() {
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(50, 50, 130, 30);
		usernameLabel.setFont(mainFont);
		add(usernameLabel);
		usernameTextField = new JTextField("think of your name");
		usernameTextField.setBounds(200, 50, 200, 30);
		add(usernameTextField);
		passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(50, 120, 130, 30);
		passwordLabel.setFont(mainFont);
		add(passwordLabel);
		passwordTextField = new JTextField("make your password");
		passwordTextField.setBounds(200, 120, 200, 30);
		add(passwordTextField);
		registerButton = new JButton("Register");
		registerButton.setBounds(30, 190, 200, 30);
		registerButton.setFont(mainFont);
		registerButton.setBackground(new Color(247, 170, 232));
		add(registerButton);
		exitButton = new JButton("Exit");
		exitButton.setBounds(255, 190, 200, 30);
		exitButton.setFont(mainFont);
		exitButton.setBackground(new Color(247, 170, 232));
		add(exitButton);
		getContentPane().setBackground(new Color(240, 240, 240));
		setSize(500, 300);
		setVisible(true);
	}

	public JLabel getUsernameLabel() {
		return usernameLabel;
	}

	public void setUsernameLabel(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}

	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	public JTextField getUsernameTextField() {
		return usernameTextField;
	}

	public void setUsernameTextField(JTextField usernameTextField) {
		this.usernameTextField = usernameTextField;
	}

	public JTextField getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(JTextField passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

	public JButton getRegisterButton() {
		return registerButton;
	}

	public void setRegisterButton(JButton registerButton) {
		this.registerButton = registerButton;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

}
