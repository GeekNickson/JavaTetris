package communication_logic;

import tttp.*;
import java.net.*;
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

	
	public ResponseReg receiveRegResponse() throws ClassNotFoundException, IOException {
		ResponseReg responseReg = (ResponseReg) in.readObject();
		return responseReg;
	}
	public ResponseAuth receiveAuthResponce() throws ClassNotFoundException, IOException {
		ResponseAuth responseAuth = (ResponseAuth) in.readObject();
		return responseAuth;
	}
}
