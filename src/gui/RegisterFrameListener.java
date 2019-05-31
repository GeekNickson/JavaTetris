package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import tttp.*;
import general_controller.*;
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
			regFrame.dispose();
			mainFrame.setEnabled(true);
		}
		if (event.getSource() == regFrame.getExitButton()) {
			regFrame.dispose();
			mainFrame.setEnabled(true);
		}
	}
}
