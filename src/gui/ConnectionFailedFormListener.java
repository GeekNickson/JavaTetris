package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//TODO REDO from scratch
public class ConnectionFailedFormListener implements ActionListener {

	ConnectionFailedForm cf;

	public ConnectionFailedFormListener(ConnectionFailedForm cf) {
		this.cf = cf;
		cf.getTryAgainButton().addActionListener(this);
	}
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == cf.getTryAgainButton()) {
			cf.dispose();
		}
		
	}

}
