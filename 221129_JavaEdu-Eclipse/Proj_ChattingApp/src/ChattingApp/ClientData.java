package ChattingApp;

import java.io.PrintWriter;
import java.net.Socket;

public class ClientData {

	Socket socket;
	PrintWriter pr;
	String clientName;
	
	// Constructors
	public ClientData() {
	}
	public ClientData(Socket socket, PrintWriter pr, String clientName) {
		this.socket = socket;
		this.pr = pr;
		this.clientName = clientName;
	}
	
	// getter & setter
	public Socket getSocket() {
		return socket;
	}
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	public PrintWriter getPr() {
		return pr;
	}
	public void setPr(PrintWriter pr) {
		this.pr = pr;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
}
