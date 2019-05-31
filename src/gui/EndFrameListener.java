package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndFrameListener implements ActionListener {
	EndFrame endFrame;
	MainFrame mainFrame;

	public EndFrameListener(EndFrame endFrame, MainFrame mainFrame) {
		this.endFrame = endFrame;
		this.mainFrame = mainFrame;
		endFrame.getPlayAgainButton().addActionListener(this);
		endFrame.getReturnToMainMenuButton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if (event.getSource() == endFrame.getPlayAgainButton()) {
			// TODO open game field and start the game
			mainFrame.setEnabled(true);
			mainFrame.playTetris();
			endFrame.dispose();
		}
		if (event.getSource() == endFrame.getReturnToMainMenuButton()) {
			mainFrame.setEnabled(true);
			mainFrame.connectToServer();
			endFrame.dispose();
		}
	}

}
