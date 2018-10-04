package kr.or.kosta.client.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.swing.JOptionPane;

import kr.or.kosta.client.common.Protocol;
import kr.or.kosta.client.model.ChatClient;

/**
 * 메인어플리케이션의 모든 화면을 담는 프레임
 * 
 * @author 전상일
 *
 */
public class TalkFrame extends Frame {

	private ChatClient chatClient;
	private String nickName;
	private boolean block;
	private String title;

	LoginRoom loginRoom;
	WaitingRoom_Main waitingRoom;
	ChattingRoom_Main chattingRoom;
	BorderLayout borderLayout;
	Panel cardPanel;
	CardLayout cardLayout;

	public TalkFrame() {
		this(":::HTS:::");
	}

	public TalkFrame(String title) {
		super(title);
		borderLayout = new BorderLayout(20, 20);
		loginRoom = new LoginRoom(this);
		waitingRoom = new WaitingRoom_Main(this);
		chattingRoom = new ChattingRoom_Main(this);

		cardPanel = new Panel();
		cardLayout = new CardLayout();
		block = true;
		setContents();
		eventRegist();

	}

	public String getNickName() {
		return nickName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ChatClient getChatClient() {
		return chatClient;
	}

	public void setChatClient(ChatClient chatClient) {
		this.chatClient = chatClient;

	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	//카드 레이아웃 설정
	public void setContents() {
		cardPanel.setLayout(cardLayout);
		cardPanel.add("LOGIN", loginRoom);
		cardPanel.add("WAIT", waitingRoom);
		cardPanel.add("CHAT", chattingRoom);

		add(cardPanel, BorderLayout.CENTER);
	}
	
	//화면 위치 설정
	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}
	
	//화면 전환
	public void changeCard(String name) {
		cardLayout.show(cardPanel, name);
	}
	
	//연결기능
	public void connect() {
		nickName = loginRoom.nickNameTF.getText().trim();
		if (nickName.equals(""))
			return;
		try {
			chatClient.connectServer();
			chatClient.sendMessage(Protocol.CONNECT + Protocol.DELEMETER + nickName);
			chatClient.sendMessage(Protocol.ALL_USER_LIST + Protocol.DELEMETER + nickName);
			chatClient.receiveMessage();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "연결 실패", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	// 연결 가능 여부 확인 메소드
	public void connectEnable(boolean flag) {
		loginRoom.nickNameTF.setEnabled(flag);
		loginRoom.enterB.setEnabled(flag);
	}

	// 방에 있는 유저들에게 보내는 메세지 메소드
	public void sendMessage() {
		String message = chattingRoom.centerChattingRoom.chatTF.getText();
		if (message == null || message.trim().length() == 0) {
			return;
		}
		chattingRoom.centerChattingRoom.chatTF.setText("");
		chatClient.sendMessage(Protocol.MULTI_CHAT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + message);
	}

	// 해당 방에 있는 유저들에게 보내는 메세지 메소드
	public void sendMessage(int idx) {
		chatClient.sendMessage(Protocol.ROOM_ENTER + Protocol.DELEMETER + nickName + Protocol.DELEMETER + (idx + 1));

	}

	// 해당 방을 검색한 유저들에게 보내는 메세지 메소드
	public void sendMessage(String roomName) {
		chatClient.sendMessage(Protocol.ROOM_SEARCH + Protocol.DELEMETER + nickName + Protocol.DELEMETER + roomName);
	}

	// 해당 방에 들어가는 유저들에게 보내는 메세지 메소드
	public void sendMessage(String roomTitle, String memberLimit) {
		chattingRoom.northChattingRoom.roomTitleL.setText(roomTitle);
		chattingRoom.northChattingRoom.roomTitleL.setFont(new Font("Verdana", Font.ITALIC, 18));
		chatClient.sendMessage(Protocol.ROOM_ADD + Protocol.DELEMETER + nickName + Protocol.DELEMETER + roomTitle
				+ Protocol.DELEMETER + memberLimit);
	}

	// 해당 방에 입장하는 유저들에게 보내는 메세지 메소드
	public void appendMessage(String nickName, boolean flags) {
		chattingRoom.centerChattingRoom.chatTA.append("#######" + nickName + "님이 연결하였습니다. #######\n");
	}

	// 해당 방에 있는 유저들에게 보여줄 메세지의 화면을 뿌려주는 메소드
	public void appendMessage(String message) {
		chattingRoom.centerChattingRoom.chatTA.append(message + "\n");
	}

	// 해당 방에 있는 유저들에게 보여줄  화면을 뿌려주는 메소드
	public void appendAllList(String[] infos) {
		waitingRoom.eastWaitingRoom.userRow = new Vector<String>();
		waitingRoom.eastWaitingRoom.userRow.addElement(infos[0]);
		waitingRoom.eastWaitingRoom.userRow.addElement(infos[1]);
		waitingRoom.eastWaitingRoom.model.addRow(waitingRoom.eastWaitingRoom.userRow);

		chattingRoom.eastChattingRoom.userAllRow = new Vector<String>();
		chattingRoom.eastChattingRoom.userAllRow.addElement(infos[0]);
		chattingRoom.eastChattingRoom.userAllRow.addElement(infos[1]);
		chattingRoom.eastChattingRoom.userAllModel.addRow(chattingRoom.eastChattingRoom.userAllRow);
	}
	//방목록 테이블을 방번호 방제목 방장 허용 인원 순으로 화면에 붙이는 기능
	public void appendMessage(String[] message) {
		waitingRoom.centertWaitingRoom.userRow = new Vector<String>();
		waitingRoom.centertWaitingRoom.userRow.addElement(message[1]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[2]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[0]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[3]);
		waitingRoom.centertWaitingRoom.model.addRow(waitingRoom.centertWaitingRoom.userRow);
	}
	//검색한 방목록을 방테이블에 붙이는 기능
	public void appendRows(String[] message) {
		waitingRoom.centertWaitingRoom.userRow = new Vector<String>();
		waitingRoom.centertWaitingRoom.userRow.addElement(message[0]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[1]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[2]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[3]);
		waitingRoom.centertWaitingRoom.model.addRow(waitingRoom.centertWaitingRoom.userRow);
	}
	//같은 방에 있는 유저들끼리 모아 방 유저목록에 띄워주는 기능
	public void updateSameRoomUserList() {
		chattingRoom.eastChattingRoom.chatUserModel.setNumRows(0);
		Hashtable<String, String> roomUserList = chatClient.getUserInfo();
		String roomNum = roomUserList.get(nickName);
		Enumeration<String> tmpNicks = roomUserList.keys();
		while (tmpNicks.hasMoreElements()) {
			String tmpNick = tmpNicks.nextElement();
			if (roomUserList.get(tmpNick).equals(roomNum)) {
				chattingRoom.eastChattingRoom.chatUserRow = new Vector<String>();
				chattingRoom.eastChattingRoom.chatUserRow.addElement(tmpNick);
				chattingRoom.eastChattingRoom.chatUserRow.addElement(roomNum);
				chattingRoom.eastChattingRoom.chatUserModel.addRow(chattingRoom.eastChattingRoom.chatUserRow);
			}
		}
	}
	
	//들어가는 유저마다 해당 방의 제목을 붙여주는 기능
	public void updateRoomName() {
		chattingRoom.northChattingRoom.roomTitleL.setText(getTitle());
		chattingRoom.northChattingRoom.roomTitleL.setFont(new Font("Verdana", Font.ITALIC, 18));
	}
	//유저가 들어오거나 나갈때마다 모든 유저의 리스트를 갱신하는 기능
	public void updateAllUserList() {
		chatClient.sendMessage(Protocol.ALL_USER_LIST + Protocol.DELEMETER + nickName);
	}
	//유저 목록을 보여줄 때 해당 목록들을 지우는 기능
	public void removeAllUserList() {
		waitingRoom.eastWaitingRoom.model.setNumRows(0);
		chattingRoom.eastChattingRoom.userAllModel.setNumRows(0);
		chattingRoom.eastChattingRoom.chatUserModel.setNumRows(0);
	}
	//방 목록 제거 기능
	public void removeRoomList() {
		waitingRoom.centertWaitingRoom.model.setNumRows(0);
	}
	//채팅화면에 유저목록을 띄워주는 기능
	public void addChoiceList() {
		chattingRoom.centerChattingRoom.msgToC.removeAll();
		chattingRoom.centerChattingRoom.msgToC.add("전체메세지");
		String roomNumber = chatClient.getUserInfo().get(nickName);
		Enumeration<String> nickNames = chatClient.getUserInfo().elements();
		while(nickNames.hasMoreElements()) {
			String nick = nickNames.nextElement();
			if(chatClient.getUserInfo().get(nick).equals(roomNumber)) {
				chattingRoom.centerChattingRoom.msgToC.add(nick);
			}
		}
	}
	//방 목록에 해당 유저를 추가하여 리스트에 붙이는 기능
	public void addAllRoomList() {
		chatClient.sendMessage(Protocol.ROOM_LIST + Protocol.DELEMETER + nickName);
	}
	//개인 메세지를 해당 유저에게 보내는 기능
	public void addPrivateMessage(String string) {
		chattingRoom.centerChattingRoom.chatTA.append("[" + getNickName() +"에게] " + string);
	}
	// 초대 메세지를 해당 유저에게 띄워주는 기능
	public void addInviteMessage(String user) {
		waitingRoom.southWaitingRoom.message1L.setText(user + " 님께서 초대메세지를 보내셨습니다!");
		waitingRoom.southWaitingRoom.message1L.setForeground(Color.RED);

	}
	//해당 유저에게 귓속말을 붙이는 기능
	public void sendSpecificMessage(String selectedItem) {
		String message = chattingRoom.centerChattingRoom.chatTF.getText();
		if (message == null || message.trim().length() == 0) {
			return;
		}
		chattingRoom.centerChattingRoom.chatTF.setText("");
		chatClient.sendMessage(Protocol.PRIVATE_CHAT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + selectedItem + Protocol.DELEMETER + message);
	}
	//해당 유저에게 귓속말을 보내는 기능
	public void sendSpecificMessage(int protocolNum, String nickName, String sendTo) {
		chatClient.sendMessage(Protocol.CHAT_INVITATION + Protocol.DELEMETER + nickName + Protocol.DELEMETER + sendTo);
	}

	//해당 유저의 연결 종료를 보내는 기능      
	public void closing() {
		chatClient.sendMessage(Protocol.DISCONNECT + Protocol.DELEMETER + nickName);
		chatClient.stopClient();
	}
	
	//소켓을 끝고 화면을 종료하는 기능
	public void finish() {
		closing();
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	//화면 x 눌렀을 때 발생하는 이벤트
	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
	}
}
