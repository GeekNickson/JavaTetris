package communication_logic;

import tttp.*;
import java.net.*;
import java.io.*;

public class NetController {
	static Socket clientSocket;

	public NetController() throws UnknownHostException, IOException {
		clientSocket = new Socket("localhost", 5050);
		//System.out.println("Connection has benn established");
	}

	public void login(RequestAuth namePass) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
		oos.writeObject(namePass);
		oos.close();
	}

	public void register(RequestReg namePass) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
		oos.writeObject(namePass);
		oos.close();
	}

	public void sendLevel(RequestStart level) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
		oos.writeObject(level);
		oos.close();
	}
}
