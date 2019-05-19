package logic;

import java.net.*;
import java.io.*;

public class User {
	private Socket clientSocket;
	private BufferedWriter out;
	private BufferedReader in;
	
	public User() {
		clientSocket = new Socket();
	}
	
	//Establishing connection with the server
	public void connect(String ip, int port) throws IOException, SocketTimeoutException {
		clientSocket.connect(new InetSocketAddress("ip", port), 1000);
	}
	//Closing connection with the server
	public void disconnect() throws IOException {
		clientSocket.close();
	}
	//This method enables users to send various messages to the server
	public void sendMessage(String message) throws IOException {
		out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
		out.write(message);
	}
	//This method allows users to receive messages coming from the server
	public String readMessage() throws IOException {
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String receivedMessage = in.readLine();
		return receivedMessage;
	}
	
	
}
