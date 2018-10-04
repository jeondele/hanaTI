package kr.or.kosta.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Iterator;

import javax.swing.JOptionPane;

import kr.or.kosta.chat.common.Protocol;
import kr.or.kosta.chat.server.Client;
import kr.or.kosta.chat.server.Room;

/**
 * 서버와의 통신 대행자
 * 
 * @author 김기정
 */
public class ChatClient {
	public static final String SERVER = "192.168.0.120";
	public static final int PORT = 7777;

	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;

	private boolean running;

	private RoomFrame chatFrame;

	public ChatClient(RoomFrame chatFrame) {
		this.chatFrame = chatFrame;
	}

	public void connectServer() throws Exception {
		try {
			socket = new Socket(SERVER, PORT);
			System.out.println("서버와 연결됨");
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
		case Protocol.CONNECT:
			String result = tokens[2];
			if (result.equalsIgnoreCase("SUCCESS")) {
				chatFrame.appendMessage("###" + nickName + "님이 연결하였습니다. ###");
				chatFrame.connectEnable(false);
			} else {
				JOptionPane.showMessageDialog(null, "이미 사용중인 대화명입니다.\n다른 대화명을 사용하세요.", "경고", JOptionPane.ERROR_MESSAGE);
			}
			break;

		case Protocol.MULTI_CHAT:
			String chatMsg = tokens[2];
			chatFrame.appendMessage("[" + nickName + "] : " + chatMsg);
			break;

		case Protocol.DISCONNECT:
			chatFrame.appendMessage("###" + nickName + "님이 퇴장하였습니다. ###");
			break;

		case Protocol.PRIVATE_CHAT_ONOFF:
			String mode = tokens[2];
			if (mode.equalsIgnoreCase("ON")) {
				System.out.println("귓속말 모드 ON");
			} else {
				System.out.println("귓속말 모드 OFF");
			}

		case Protocol.ROOM_SEARCH:
			break;

		case Protocol.ROOM_ADD:
			break;

		case Protocol.modal_ROOM_ADD:
			break;

		case Protocol.ROOM_DELETE:
			break;

		case Protocol.ROOM_INFORM:
			break;

		case Protocol.CHAT_USER_LIST:
			break;

		case Protocol.modal_CHAT_INVITATION:
			break;

		case Protocol.modal_CHAT_EXIT:
			break;

		default:
			break;
		}
	}
}
