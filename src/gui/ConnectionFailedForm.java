package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class ConnectionFailedForm extends JFrame {
	private Font mainFont = new Font("Comic Sans MS", Font.PLAIN, 18);
	private JLabel errorMessageLabel;
	private JButton tryAgainButton;

	public ConnectionFailedForm() {
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		errorMessageLabel = new JLabel("<html>Connection failed!<br>"
				+ "\n  &nbsp;&nbsp;Wrong port or &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ip-address<html>");
		errorMessageLabel.setFont(mainFont);
		errorMessageLabel.setBounds(75, 20, 150, 100);
		add(errorMessageLabel);
		tryAgainButton = new JButton("Try again");
		tryAgainButton.setBounds(75, 150, 150, 30);
		tryAgainButton.setFont(mainFont);
		tryAgainButton.setBackground(new Color(247, 170, 232));
		add(tryAgainButton);
		setSize(300, 300);
		setVisible(true);
	}

	public JLabel getErrorMessageLabel() {
		return errorMessageLabel;
	}

	public void setErrorMessageLabel(JLabel errorMessageLabel) {
		this.errorMessageLabel = errorMessageLabel;
	}

	public JButton getTryAgainButton() {
		return tryAgainButton;
	}

	public void setTryAgainButton(JButton tryAgainButton) {
		this.tryAgainButton = tryAgainButton;
	}
	
}
