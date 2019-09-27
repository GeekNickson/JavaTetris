package communication_logic;

import tttp.*;
import java.net.*;

import idstuff.Player;

import java.io.*;

public class NetController {
	private Socket clientSocket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	public NetController(String ip, int port) throws UnknownHostException, IOException {
		clientSocket = new Socket(ip, port);
		out = new ObjectOutputStream(clientSocket.getOutputStream());
		in = new ObjectInputStream(clientSocket.getInputStream());
	}

	public void login(RequestAuth namePass) throws IOException {
		out.writeObject(namePass);
	}

	public void register(RequestReg namePass) throws IOException {
		out.writeObject(namePass);
	}

	public void surrender(int score) {
		try {
			out.writeObject(new RequestEnd(score));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void disconnect() throws IOException{
		try {
			RequestDisconnect rd = new RequestDisconnect();
			out.writeObject(rd);
			out.close();
			in.close();
			clientSocket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public Player[] askForLeaders() {
		Player[] leaders = null;
		RequestLeaderboard rl = new RequestLeaderboard();
		try {
			out.writeObject(rl);
			ResponseLeaderboard response = (ResponseLeaderboard)in.readObject();
			leaders = response.getLeaders();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaders;
	}
	
	public ResponseReg receiveRegResponse() throws ClassNotFoundException, IOException {
		ResponseReg responseReg = (ResponseReg) in.readObject();
		return responseReg;
	}
	public ResponseAuth receiveAuthResponce() throws ClassNotFoundException, IOException {
		ResponseAuth responseAuth = (ResponseAuth) in.readObject();
		return responseAuth;
	}
}
