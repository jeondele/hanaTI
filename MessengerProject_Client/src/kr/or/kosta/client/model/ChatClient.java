package kr.or.kosta.client.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JOptionPane;

import kr.or.kosta.client.common.Protocol;
import kr.or.kosta.client.view.TalkFrame;

/**
 * 서버와 실질적인 송수신하는 역할을 담당하는 클래스
 * 
 * @author 전상일
 *
 */
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

	public Vector<String> getClients() {
		return clients;
	}
	
	//들어온 유저의 이름을 키값으로, 방번호를 value값으로 가짐
	public Hashtable<String, String> getUserInfo() {
		return userInfo;
	}
	
	/**
	 * TCP/IP통신을 위한 서버 연결
	 * 
	 * @throws Exception	서버 연결이 안될 시 예외 발생
	 */
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

	/**
	 * 	클라이언트 측의 연결을 끝을 때 사용하는 메소드
	 */
	public void stopClient() {
		if (socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}

	/**
	 * 서버측에 메세지를 송신하는 메소드
	 * @param message	전달해줄 메세지
	 */
	public void sendMessage(String message) {
		if (out != null)
			out.println(message);
	}

	/**
	 * 서버에서 전송된 메시지를 수신 및 파싱 메서드 호출
	 */
	public void receiveMessage() {
		new Thread() {
			@Override
			public void run() {
				while (running) {
					String serverMessage = null;
					try {
						serverMessage = in.readLine();
						process(serverMessage);

					} catch (IOException e) {
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

	/**
	 * 서버에서 수신한 메시지를 프로토콜에 맞게 파싱
	 * 
	 * @param message 서버에서 수신한 메시지
	 */
	public void process(String message) {
		String[] tokens = message.split(Protocol.DELEMETER);
		int protocol = Integer.parseInt(tokens[0]);
		String nickName = tokens[1];

		switch (protocol) {
		// 연결 결과를 송신했을 때
		case Protocol.CONNECT_RESULT:
			String result = tokens[2];
			if (result.equalsIgnoreCase("SUCCESS")) {
				talkFrame.changeCard("WAIT");
			} else if (result.equalsIgnoreCase("FAIL")) {
				talkFrame.setBlock(true);
				JOptionPane.showMessageDialog(null, "다른 닉네임을 입력하세요", "채팅방 입장 불가", JOptionPane.ERROR_MESSAGE);
			}
			break;
		// 채팅방의 메세지를 해당 방안의 유저에게 뿌려줄 때	
		case Protocol.MULTI_CHAT:
			String chatMessage = tokens[2];
			talkFrame.appendMessage("[" + nickName + "] : " + chatMessage);
			break;
		//	클라이언트가 퇴장했을 때
		case Protocol.DISCONNECT:
			talkFrame.removeAllUserList();
			talkFrame.updateAllUserList();
			talkFrame.updateSameRoomUserList();
			break;
		//	연결된 모든 클라이언트 값 저장, 화면에 뿌려줄 때
		case Protocol.ALL_USER_LIST:
			talkFrame.removeAllUserList();
			userInfo = new Hashtable<String, String>();
			int tmpCnt = 1;
			for (int i = 0; i < (tokens.length - 1) / 2; i++) {
				String[] tmp = new String[2];
				tmp[0] = tokens[tmpCnt++];
				tmp[1] = tokens[tmpCnt++];
				userInfo.put(tmp[0], tmp[1]); 
				talkFrame.updateSameRoomUserList();
				talkFrame.appendAllList(tmp);
			}
			break;
		// 특정 클라이언트에게 보내는 메세지를 수신했을 때
		case Protocol.PRIVATE_CHAT:
			talkFrame.addPrivateMessage(tokens[3]);
		// 생성된 방의 정보를 수신했을 때	
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
		// 생성된방에 들어갔을 때 결과 여부를 수신 했을 때
		case Protocol.ROOM_ENTER_RESULT:
			
			String msg = String.valueOf(Protocol.MULTI_CHAT);
			for (int i = 1; i < tokens.length-1; i++) {
				clients.addElement(tokens[i]);
			}
			this.talkFrame.setTitle(tokens[tokens.length-1]);
			this.talkFrame.updateRoomName();
			break;
			 
		// 생성된방에 들어갔을 때 받을 내용들을 수신 했을 때
		case Protocol.ROOM_IN:
			talkFrame.appendMessage(nickName, true);
		
		// 방 검색 후 방정보를 수신하여 화면에 전달할 대	
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
			break;
		// 초대메세지를 수신했을 때
		case Protocol.CHAT_INVITATION:
			talkFrame.addInviteMessage(nickName);
		default:
			break;
		}
	}
}
