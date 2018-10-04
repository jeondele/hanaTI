package kr.or.kosta.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.CellEditor;

import kr.or.kosta.chat.common.Protocol;

/**
 * Chatting Server
 * 
 * @author 김기정
 */
public class ChatServer {
	public static final int PORT = 7777;
	private boolean running;
	private ServerSocket serverSocket;
	private int RoomNum = 1;

	private Hashtable<String, Client> clients;
	private Hashtable<Integer, Room> roomList;

	public ChatServer() {
		roomList = new Hashtable<Integer, Room>();
	}

	public Hashtable<Integer, Room> getRoomList() {
		return roomList;
	}

	public int getRoomNum() {
		return RoomNum;
	}

	public void setRoomNum(int roomNum) {
		RoomNum = roomNum;
	}

	public boolean isRunning() {
		return running;
	}

	public Hashtable<String, Client> getClients() {
		return clients;
	}

	public Hashtable<Integer, Room> getRooms() {
		return roomList;
	}

	public void startUp() throws IOException {
		try {
			serverSocket = new ServerSocket(PORT);

		} catch (Exception e) {
			throw new IOException("[" + PORT + "] 포트 충돌로 ChatServer를 구동할 수 없습니다.");
		}

		running = true;
		clients = new Hashtable<String, Client>();
		System.out.println("BTS[" + PORT + "] ChatServer Start....");

		while (running) {
			try {
				Socket socket = serverSocket.accept();
				Client client = new Client(socket, this);
				System.out.println(socket.getInetAddress() + " - 클라이언트가 연결해옴.");
				client.start();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 서버 다운
	 */
	public void shutDown() {
	}

	/**
	 * 클라이언트 추가
	 * 
	 * @param client
	 */
	public void addClient(Client client) {
		clients.put(client.getNickName(), client);
	}

	/**
	 * 클라이언트 수
	 * 
	 * @return 접속자 수
	 */
	public int getClientCount() {
		return clients.size();
	}

	/**
	 * 닉네임 고유 설정
	 * 
	 * @param nickName
	 * @return
	 */
	public boolean isExistNickName(String nickName) {
		return clients.containsKey(nickName);
	}

	public boolean isExistRoomName(String title) {
		return roomList.containsKey(title);
	}

	/**
	 * Hash tabled에서 value값 제거
	 * 
	 * @param client
	 * @param message
	 */
	public void removeClient(Client client, String message) {
		clients.remove(client.getNickName());
		sendAllMessage(message);
	}

	/**
	 * 접속 중인 모든 클라이언트에게 메시지 발송
	 * 
	 * @param message
	 */
	public void sendAllMessage(String message) {
		Enumeration<Client> e = clients.elements();
		while (e.hasMoreElements()) {
			Client client = e.nextElement();
			client.sendMessage(message);
		}
	}

	public void sendPartialMessage(Room room, String message) {
		Enumeration<Client> e = room.getClientList().elements();
		while(e.hasMoreElements()) {
			Client client = e.nextElement();
			client.sendMessage(message);
		}
	}

	public int roomCount() {
		if (roomList.size() == 0) {
			return 0;
		} else {
			return roomList.size();
		}
	}

	public void removeRoom(Room room) {
		if (room.getClientList().size() == 0)
			roomList.remove(room);
		String message = String.valueOf(Protocol.ROOM_DELETE);
		for (int i = 0; i < roomList.size(); i++) {
			int idx = i + 1;
			String title = roomList.get(idx).getRoomTitle();
			String owner = roomList.get(idx).getClientList().get(0).getNickName();
			int userLimit = roomList.get(idx).getUserLimit();
			message += (Protocol.DELEMETER + /**owner +*/ Protocol.DELEMETER + idx + Protocol.DELEMETER + title
					+ Protocol.DELEMETER + userLimit);
		}
		sendAllMessage(message);
	}

	public void addRoomList() {
		if (roomList.size() == 0)
			return;
		String message = String.valueOf(Protocol.ROOM_ADD);
		for (int i = 0; i < roomList.size(); i++) {
			int idx = i + 1;
			String title = roomList.get(idx).getRoomTitle();
			String owner = roomList.get(idx).getClientList().get(0).getNickName();
			int userLimit = roomList.get(idx).getUserLimit();
			message += (Protocol.DELEMETER + owner + Protocol.DELEMETER + idx + Protocol.DELEMETER + title
					+ Protocol.DELEMETER + userLimit);
		}
		System.out.println(message);
		sendAllMessage(message);
	}

	public void searchRoom() {
		String message = String.valueOf(Protocol.ROOM_SEARCH);
		for (int i = 0; i < roomList.size(); i++) {
			int idx = i + 1;
			String title = roomList.get(idx).getRoomTitle();
//			String owner = roomList.get(idx).getOwnerName();
			int userLimit = roomList.get(idx).getUserLimit();
			message += (Protocol.DELEMETER + /**owner +*/ Protocol.DELEMETER + idx + Protocol.DELEMETER + title
					+ Protocol.DELEMETER + userLimit);
		}
		System.out.println(message);
		sendAllMessage(message);
	}
}