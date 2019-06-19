package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import tttp.*;
import general_controller.*;
import java.awt.*;

public class RegisterFrameListener implements ActionListener {
	RegisterFrame regFrame;
	MainFrame mainFrame;

	public RegisterFrameListener(RegisterFrame regFrame, MainFrame mainFrame) {
		this.regFrame = regFrame;
		this.mainFrame = mainFrame;
		regFrame.getRegisterButton().addActionListener(this);
		regFrame.getExitButton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == regFrame.getRegisterButton()) {
			String username = regFrame.getUsernameTextField().getText();
			String password = regFrame.getPasswordTextField().getText();
			// TODO do all the registration stuff
			GeneralController.register(new RequestReg(username, password));
			mainFrame.setEnabled(true);
			regFrame.dispose();
		}
		if (event.getSource() == regFrame.getExitButton()) {
			mainFrame.setEnabled(true);
			regFrame.dispose();
		}
			
	}
}
