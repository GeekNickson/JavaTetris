package gui;

import java.awt.event.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.io.*;
//TODO REDO from scratch
public class ConnectToServerFormListener implements ActionListener {

	ConnectToServerForm sf;

	public ConnectToServerFormListener(ConnectToServerForm sf) {
		this.sf = sf;
		sf.getConnectButton().addActionListener(this);
		sf.getDisconnectButton().addActionListener(this);
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == sf.getConnectButton()) {
			sf.startServer();
			String username = sf.getUsernameTextField().getText();
			String ip = sf.getIpAddressTextField().getText();
			String port = sf.getPortTextField().getText();
			// TODO Send these strings to the server so it can check them
			// System.out.println(username + " " + ip + " " + port);
			try {
				// Socket clientSocket = new Socket("localhost", 5050);
				// TODO Handle situations when a client can't connect to the server
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				Socket clientSocket = new Socket(); //TODO MAKE THIS ITS OWN CLASS
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				try {
					clientSocket.connect(new InetSocketAddress("localhost", 5050), 1000);
				} catch (SocketTimeoutException e) {
					ConnectionFailedForm cf = new ConnectionFailedForm();
					ConnectionFailedFormListener cfListener = new ConnectionFailedFormListener(cf);
				}
				
				// Sending the message
				// System.out.println(clientSocket.isConnected());
				// OutputStream os = clientSocket.getOutputStream();
				// OutputStreamWriter osw = new OutputStreamWriter(os);
				// BufferedWriter bw = new BufferedWriter(osw);
				// String sendMessage = username + " " + ip + " " + port;
				// bw.write(sendMessage);
				// bw.flush();
				// BufferedReader br = new BufferedReader(new
				// InputStreamReader(clientSocket.getInputStream()));
				// String receivedText = br.readLine();
				// System.out.println(receivedText);
				clientSocket.close();
				// The message has been sent
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (event.getSource() == sf.getDisconnectButton()) {
			sf.stopServer();
		}
	}
}
