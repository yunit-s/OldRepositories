package ChattingApp;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.control.TextArea;

class SharedInfo {
	
	TextArea serverLogArea; // link to GUI chatArea
	ArrayList<ClientData> clientList;
	HashMap<String, ClientData> clientMap;

	// Constructors
	public SharedInfo(TextArea chatArea) {
		this.serverLogArea = chatArea;
		clientList = new ArrayList<ClientData>();
		clientMap = new HashMap<String, ClientData>();
	}
	
	// Methods
	public void addClient(ClientData newClient) {
		clientList.add(newClient);
		clientMap.put(newClient.getClientName(), newClient);
	}
	public synchronized void sendMsg(String clientName, String msgTo, String msgContents) {
		// msgTo에 맞는 clientData 찾아서, 그 pr로 clientName + msgContents 전송
		try {
			if (msgTo.equals("everyone")) {
				// 보낸 사람을 제외한 모두에게 전송
				for (ClientData clist: clientList) {
					if (!(clist.getClientName().equals(clientName))) {
						clist.getPr().println(clientName + ":(everyone)" + msgContents);
						clist.getPr().flush();
					}
				}
			} else {
				clientMap.get(msgTo).getPr().println(clientName + ":" + msgContents);
				clientMap.get(msgTo).getPr().flush();
			}
		} catch (Exception e) {
			// 받을 사람이 리스트에 없는 경우 오류메시지 출력
			serverLogArea.appendText("Sys> client 정보 오류" + "\n");
			clientMap.get(clientName).getPr().println("Sys: " + msgTo + " is offline.");
			clientMap.get(clientName).getPr().flush();
		}
		
	}
}
