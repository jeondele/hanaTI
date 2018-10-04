package kr.or.kosta.chat.server;

import java.util.Enumeration;
import java.util.Vector;
import kr.or.kosta.chat.common.Protocol;

// 여긴 채팅방의 클래스임ㅏㅣ 
public class Room {
	private Client client;
	private String roomTitle;
	private int userLimit;
	private Vector<Client> clients;

	ChatServer chatServer;

	public Room(Client client, String roomTitle, int userLimit) {
		this.client = client;
		this.roomTitle = roomTitle;
		this.userLimit = userLimit;
		clients = new Vector<Client>();
		clients.add(client);
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getRoomTitle() {
		return roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public int getUserLimit() {
		return userLimit;
	}

	public void setUserLimit(int userLimit) {
		this.userLimit = userLimit;
	}

	public Vector<Client> getClientList() {
		return clients;
	}

	public void setClientList(Vector<Client> clientList) {
		this.clients = clientList;
	}

	public void getUserList(Vector clientList) {
		String message = String.valueOf(Protocol.CHAT_USER_LIST);
		Enumeration<Client> e = clientList.elements();
		while (e.hasMoreElements()) {
			String chatUser = e.nextElement().getNickName();
			message += (Protocol.DELEMETER + chatUser);
		}
		chatServer.sendAllMessage(message);
	}

	public boolean sendPrivateMessage(String message) {
		return false;
	}

	public void sendInvitationMessage(String message) {
	}

	public void enterRoom(Client client) {
//		clients.addElement(client);
		getUserList(getClientList());
	}

	public void exitRoom(Client client) {

	}

	public String infoRoom() {
		return toString();
	}

//	@Override
//	public String toString() {
//		String userList = clients.elements().nextElement().getNickName();
//		Enumeration<Client> e = clients.elements();
//		while (e.hasMoreElements()) {
//			userList += ":" + e.nextElement().getNickName();
//			System.out.println("어떻게 찍히나요?------------" +userList);
//		}
//		return userLimit + "," + clients.size() + "," + userList;
//	}

}
