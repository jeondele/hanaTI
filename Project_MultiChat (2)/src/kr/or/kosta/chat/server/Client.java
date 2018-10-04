package kr.or.kosta.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Vector;

import kr.or.kosta.chat.common.Protocol;

/**
 * 클라언트의 데이터 수신 및 처리
 * 
 * @author 김기정
 *
 */
public class Client extends Thread {

	private boolean running;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	/** 클라이언트 식별자 */
	private String nickName = "";

	ChatServer chatServer;
	Room room;

	public Client(Socket socket, ChatServer chatServer) throws IOException {
		this.socket = socket;
		this.chatServer = chatServer;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		running = true;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Socket getSocket() {
		return socket;
	}

	public void recieveMessage() {
		while (running) {
			String clientMessage = null;
			try {
				clientMessage = in.readLine();
				System.out.println("[Debug] : 클라이언트 수신 데이터: " + clientMessage);
				process(clientMessage);

			} catch (IOException e) {
				System.out.println("단절");
				break;
			}
		}

		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 클라이언트의 메시지를 파싱하여 서비스 제공
	 * 
	 * @param message
	 */
	public void process(String message) {
		String[] tokens = message.split(Protocol.DELEMETER);
		int protocol = Integer.parseInt(tokens[0]);
		nickName = tokens[1];
		switch (protocol) {

		// 1. 로그인 입장 패널
		case Protocol.CONNECT:
			// 대화명 중복 여부 체크
			if (chatServer.isExistNickName(nickName)) {
				sendMessage(Protocol.CONNECT_RESULT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + "FAIL");

			} else {
				chatServer.addClient(this);
				System.out.println("[Debug] : 접속 클라이언트 수 : " + chatServer.getClientCount());
				sendMessage(Protocol.CONNECT_RESULT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + "SUCCESS");
				// sendAllUserList();
				chatServer.addRoomList();
			}
			break;

		case Protocol.DISCONNECT:
			chatServer.removeClient(this, message);
			System.out.println("[Debug] : 퇴장 클라이언트 : " + chatServer.getClients().containsKey(nickName));
			System.out.println("[Debug] : 접속 클라이언트 수 : " + chatServer.getClientCount());
			sendMessage(Protocol.DISCONNECT + Protocol.DELEMETER + nickName);
			setRunning(false);
			break;

		/** 대기실 화면 관련 데이터 통신 */
		case Protocol.ROOM_SEARCH:
			if (chatServer.isExistRoomName(room.getRoomTitle())) {
				sendMessage(Protocol.ROOM_SEARCH + Protocol.DELEMETER + room.getRoomTitle());
			} else {

			}
			System.out.println("[Debug] : 이름으로 검색한 방 : " + room.getRoomTitle());
			break;

		case Protocol.ROOM_ADD:
			String roomTitle = tokens[2];
			int memberLimit = Integer.parseInt(tokens[3]);
			createRoom(this, roomTitle, memberLimit);
			break;

		case Protocol.ROOM_DELETE:
			chatServer.removeRoom(room);
			break;

		case Protocol.ROOM_INFORM:
			int roomInfoNum = Integer.parseInt(tokens[2]);
			Room InfoRoom = chatServer.getRoomList().get(roomInfoNum);
			sendMessage(Protocol.ROOM_INFORM + Protocol.DELEMETER + InfoRoom.toString());
			break;

		case Protocol.ROOM_ENTER:
			String msg_result = String.valueOf(Protocol.ROOM_ENTER_RESULT);
			String msg_roomIn = String.valueOf(Protocol.ROOM_IN +  Protocol.DELEMETER +nickName);
			int idx = Integer.parseInt(tokens[2]);
			
			Enumeration<Client> ec = chatServer.getClients().elements();
			while(ec.hasMoreElements()) {
				Client toBeContained = ec.nextElement();
				if(toBeContained.getNickName().equals(nickName)) {
					chatServer.getRoomList().get(idx).getClientList().addElement(toBeContained);
				}
			}
			
			Room room = chatServer.getRoomList().get(idx);
			Enumeration<Client> e = room.getClientList().elements();
			while (e.hasMoreElements()) {
				String nickName = e.nextElement().getNickName();
				msg_result += Protocol.DELEMETER + nickName;
			}
			chatServer.sendPartialMessage(room, msg_result);
			chatServer.sendPartialMessage(room, msg_roomIn);
			System.out.println(msg_result);
			System.out.println(msg_roomIn);
/*			if (room.getClientList().size() == room.getUserLimit()) {
				sendMessage(Protocol.ROOM_ENTER_RESULT + Protocol.DELEMETER + "FAIL");
			} else {
				sendMessage(Protocol.ROOM_ENTER_RESULT + Protocol.DELEMETER + "SUCCESS");
			}
*/
			
			
			
	/*	case Protocol.ROOM_IN:
			int idx2 = Integer.parseInt(tokens[2]);
			String msg_roomIn = String.valueOf(Protocol.ROOM_IN);
			Room room2 = chatServer.getRoomList().get(idx2);
			Enumeration<Client> e2 = room2.getClientList().elements();
			while (e2.hasMoreElements()) {
				String nickName = e2.nextElement().getNickName();
				msg_roomIn += Protocol.DELEMETER + nickName;
			}
			chatServer.sendPartialMessage(room2, msg_roomIn);
			break;*/
			
		case Protocol.ROOM_OUT:
			break;

		case Protocol.SESSION_OUT:
			break;

		case Protocol.MULTI_CHAT:
			String userMsg = tokens[2];
			String msg_multi = String.valueOf(Protocol.MULTI_CHAT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + userMsg);
			
			Enumeration<Room> chatRoom = chatServer.getRoomList().elements();
			
//			Room chatRoom = chatServer.getRoomList().get(roomNum);
//			chatRoom.getClientList().addElement(this);
//			Enumeration<Client> e1 = chatRoom.getClientList().elements();
			while (chatRoom.hasMoreElements()) {
				Room thisRoom = chatRoom.nextElement();
				System.out.println(thisRoom.toString());
				Vector<Client> thisClient = thisRoom.getClientList();
				for (Client client : thisClient) {
					System.out.println("1." + client.nickName);
					if(client.getNickName().equals(nickName)) {
						System.out.println("\"1.\" + 닉네임이랑 같은거");
						chatServer.sendPartialMessage(thisRoom, msg_multi);
						return;
					}
				}
			}
			break;

		case Protocol.PRIVATE_CHAT_ONOFF:
			sendMessage(Protocol.PRIVATE_CHAT_ONOFF + Protocol.DELEMETER + nickName + Protocol.DELEMETER + "ON");
			sendMessage(Protocol.PRIVATE_CHAT_ONOFF + Protocol.DELEMETER + nickName + Protocol.DELEMETER + "OFF");
			break;

		case Protocol.CHAT_USER_LIST:
			// sendUserList();
			break;

		case Protocol.CHAT_INVITATION:
			chatServer.sendAllMessage(message);
			break;

		case Protocol.CHAT_EXIT:
			chatServer.sendAllMessage(message);
			break;

		default:
			break;
		}
	}

	public void sendMessage(String message) {
		out.println(message);
	}

	/*
	 * public void sendAllUserList() { Enumeration<Client> e =
	 * chatServer.getClients().elements(); String message =
	 * String.valueOf(Protocol.ALL_USER_LIST); while (e.hasMoreElements()) { String
	 * user = e.nextElement().nickName; message += (Protocol.DELEMETER + user); }
	 * 
	 * chatServer.sendAllMessage(message); }
	 */

	public void createRoom(Client client, String title, int UserLimit) {
		Room newRoom = new Room(client, title, UserLimit);
		chatServer.getRoomList().put(chatServer.getRoomNum(), newRoom);
		chatServer.setRoomNum(chatServer.getRoomNum() + 1);
		chatServer.addRoomList();

	}

	@Override
	public void run() {
		recieveMessage();
	}

}
