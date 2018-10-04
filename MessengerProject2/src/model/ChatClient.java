package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JOptionPane;

import common.Protocol;
import view.TalkFrame;

public class ChatClient {
	public static final String SERVER = "127.0.0.1";
	public static final int PORT = 7777;

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private Vector<String> clients;
	private Hashtable<String, String> userInfo;
	private boolean running;

	private TalkFrame talkFrame;

	public ChatClient(TalkFrame talkFrame) {
		this.talkFrame = talkFrame;
		clients = new Vector<String>();
	}

	public Hashtable<String, String> getUserInfo() {
		return userInfo;
	}

	public void connectServer() throws Exception {
		try {
			socket = new Socket(SERVER, PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			running = true;
		} catch (Exception e) {
			throw new Exception("서버를 찾을 수 없습니다..");
		}
	}

	public void stopClient() {
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}

	public void sendMessage(String message) {
		if (out != null)
			out.println(message);
	}

	public void receiveMessage() {
		new Thread() {
			@Override
			public void run() {
				while (running) {
					String serverMessage = null;
					try {
						serverMessage = in.readLine();
						System.out.println("[Debug] : Server Receive Message: " + serverMessage);
						process(serverMessage);

					} catch (IOException e) {
						System.out.println("네트워크가 단절되었습니다..");
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

		}.start();
	}

	public void process(String message) {
		String[] tokens = message.split(Protocol.DELEMETER);

		int protocol = Integer.parseInt(tokens[0]);
		String nickName = tokens[1];

		switch (protocol) {
		case Protocol.CONNECT_RESULT:
			String result = tokens[2];
			if (result.equalsIgnoreCase("SUCCESS")) {
				System.out.println("통신 양호");
//				talkFrame.appendMessage("###" + nickName + "님이 연결하였습니다. ###");
				talkFrame.changeCard("WAIT");
			} else if (result.equalsIgnoreCase("FAIL")) {
				talkFrame.setBlock(true);
				JOptionPane.showMessageDialog(null, "다른 닉네임을 입력하세요", "채팅방 입장 불가", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case Protocol.MULTI_CHAT:
			String chatMessage = tokens[2];
			talkFrame.appendMessage("[" + nickName + "] : " + chatMessage);
			break;
		case Protocol.DISCONNECT:
			talkFrame.removeAllUserList();
			talkFrame.updateAllUserList();
			talkFrame.updateSameRoomUserList();
			System.out.println("--퇴장완료---");
//			talkFrame.appendMessage("###" + nickName + "님이 퇴장하였습니다. ###");
//			talkFrame.userList.remove(nickName);
			break;
		case Protocol.ALL_USER_LIST:
			talkFrame.removeAllUserList();
			userInfo = new Hashtable<String, String>();
			System.out.println("리스트");
			int tmpCnt = 1;
			System.out.println(tokens.length);
			for (int i = 0; i < (tokens.length - 1) / 2; i++) {
				String[] tmp = new String[2];
				tmp[0] = tokens[tmpCnt++];
				tmp[1] = tokens[tmpCnt++];
				userInfo.put(tmp[0], tmp[1]); 
				System.out.println(tmp[0]+"------------"+ tmp[1]);
				talkFrame.updateSameRoomUserList();
				talkFrame.appendAllList(tmp);
			}
			break;

		case Protocol.ROOM_ADD:
			talkFrame.removeRoomList();
			int cnt = 1;
			for (int j = 0; j < (tokens.length - 1) / 4; j++) {
				String[] roomInfo = new String[4];
				for (int i = 0; i < (roomInfo.length); i++) {
					roomInfo[i] = tokens[cnt];
					cnt++;
				}
				talkFrame.appendMessage(roomInfo);
			}
			break;
		case Protocol.ROOM_ENTER_RESULT:
			
			String msg = String.valueOf(Protocol.MULTI_CHAT);
			for (int i = 1; i < tokens.length-1; i++) {
				clients.addElement(tokens[i]);
			}
			System.out.println("chatClient room enter result에서 " + tokens[tokens.length-1]);
			this.talkFrame.setTitle(tokens[tokens.length-1]);
			this.talkFrame.updateRoomName();
			break;

		case Protocol.ROOM_IN:
			talkFrame.appendMessage(nickName, true);
			
		case Protocol.ROOM_SEARCH:
			int searchCnt = 1;
			String flag = tokens[tokens.length-1];
			if (flag.equalsIgnoreCase("SUCCESS")) {
				for (int j = 0; j < (tokens.length - 1) / 4; j++) {
					String[] roomInfo = new String[4];
					for (int i = 0; i < (roomInfo.length); i++) {
						roomInfo[i] = tokens[searchCnt];
						searchCnt++;
					}
					talkFrame.appendRows(roomInfo);
				}
			} else if(flag.equalsIgnoreCase("FAIL")) {
				JOptionPane.showMessageDialog(null, "해당 제목이 없습니다.", "주의", JOptionPane.ERROR_MESSAGE);
			}
		case Protocol.ROOM_USER_LIST:
			talkFrame.removeRoomUserList();
			int countNum = 1;
			for (int i = 0; i < (tokens.length - 1) / 2; i++) {
				String[] tmp = new String[2];
				tmp[0] = tokens[countNum++];
				tmp[1] = tokens[countNum++];
				System.out.println(tmp[0]+"------------"+ tmp[1]);
				talkFrame.appendRoomUserList(tmp);
			}
//		case Protocol.MULTI_LIST:
//			talkFrame.userList.removeAll();
//			Arrays.sort(tokens);
//			for (int i = 1; i < tokens.length; i++) {
//				talkFrame.userList.add(tokens[i]);
//			}
		default:
			break;
		}
	}
}
