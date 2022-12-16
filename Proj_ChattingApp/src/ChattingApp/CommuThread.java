package ChattingApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javafx.application.Platform;

class CommuThread implements Runnable {

	Socket socket;
	PrintWriter pr;
	BufferedReader br;
	String clientName;
	
	// Shared Instance
	SharedInfo sharedIns;
	
	// Constructors
	public CommuThread() {
	}
	public CommuThread(Socket socket, SharedInfo sharedIns) {
		this.socket = socket;
		this.sharedIns = sharedIns;
		try {
			pr = new PrintWriter(socket.getOutputStream());
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Methods
	void printMsg(String msg) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				sharedIns.serverLogArea.appendText(msg + "\n");
			}
		});
	}

	@Override
	public void run() {
		// set Client data
		try {
			clientName = br.readLine();
			sharedIns.addClient(new ClientData(socket, pr, clientName));
			printMsg("Sys> New Client '" + clientName + "' access!");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		// communicate with Client
		while (true) {
			try {
				// receive message
				String msg = br.readLine();
				String[] msgToken = msg.split(":");
				String msgTo = msgToken[0];
				String msgContents;;
				if (msgToken.length != 2) {
					msgContents = "";
				} else {
					msgContents = msgToken[1];
				}
				printMsg(clientName + " -> " + msgTo + ",   Message:" + msgContents);
				
				// send message via shared instance
				sharedIns.sendMsg(clientName, msgTo, msgContents);

			} catch (IOException e) {
				// 소켓 끊어졌을 때 쓰레드 강제 종료
				e.printStackTrace();
			}
		}
		
	}
	
}
