package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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

import common.Protocol;
import model.ChatClient;

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

	public void setContents() {
		cardPanel.setLayout(cardLayout);
		cardPanel.add("LOGIN", loginRoom);
		cardPanel.add("WAIT", waitingRoom);
		cardPanel.add("CHAT", chattingRoom);

		add(cardPanel, BorderLayout.CENTER);
	}

	public void setCenter() {
		Toolkit.getDefaultToolkit().beep();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - getSize().width) / 2;
		int y = (dim.height - getSize().height) / 2;
		setLocation(x, y);
	}

	public void changeCard(String name) {
		cardLayout.show(cardPanel, name);
	}

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

	public void connectEnable(boolean flag) {
		loginRoom.nickNameTF.setEnabled(flag);
		loginRoom.enterB.setEnabled(flag);
	}

	public void sendMessage() {
		String message = chattingRoom.centerChattingRoom.chatTF.getText();
		if (message == null || message.trim().length() == 0) {
			return;
		}
		chattingRoom.centerChattingRoom.chatTF.setText("");
		chatClient.sendMessage(Protocol.MULTI_CHAT + Protocol.DELEMETER + nickName + Protocol.DELEMETER + message);
	}

	public void sendMessage(int idx) {
		chatClient.sendMessage(Protocol.ROOM_ENTER + Protocol.DELEMETER + nickName + Protocol.DELEMETER + (idx + 1));
		
	}
	
	public void sendMessage(String roomName) {
		chatClient.sendMessage(Protocol.ROOM_SEARCH + Protocol.DELEMETER + nickName + Protocol.DELEMETER + roomName );
	}	

	public void sendMessage(String roomTitle, String memberLimit) {
		chattingRoom.northChattingRoom.roomTitleL.setText(roomTitle);
		chattingRoom.northChattingRoom.roomTitleL.setFont(new Font("Verdana", Font.ITALIC, 18));
		chatClient.sendMessage(Protocol.ROOM_ADD + Protocol.DELEMETER + nickName + Protocol.DELEMETER + roomTitle
				+ Protocol.DELEMETER + memberLimit);
	}

	public void appendMessage(String nickName, boolean flags) {
		chattingRoom.centerChattingRoom.chatTA.append("#######" + nickName + "님이 연결하였습니다. #######\n");
	}

	public void appendMessage(String message) {
		chattingRoom.centerChattingRoom.chatTA.append(message + "\n");
	}

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

	public void appendRoomUserList(String[] infos) {
		waitingRoom.eastWaitingRoom.roomUserRow = new Vector<String>();
		waitingRoom.eastWaitingRoom.roomUserRow.addElement(infos[0]);
		waitingRoom.eastWaitingRoom.roomUserRow.addElement(infos[1]);
		waitingRoom.eastWaitingRoom.roomUserModel.addRow(waitingRoom.eastWaitingRoom.roomUserRow);
	}
	public void appendMessage(String[] message) {
		waitingRoom.centertWaitingRoom.userRow = new Vector<String>();
		waitingRoom.centertWaitingRoom.userRow.addElement(message[1]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[2]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[0]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[3]);
		waitingRoom.centertWaitingRoom.model.addRow(waitingRoom.centertWaitingRoom.userRow);
	}

	public void appendRows(String[] message) {
		waitingRoom.centertWaitingRoom.userRow = new Vector<String>();
		waitingRoom.centertWaitingRoom.userRow.addElement(message[0]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[1]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[2]);
		waitingRoom.centertWaitingRoom.userRow.addElement(message[3]);
		waitingRoom.centertWaitingRoom.model.addRow(waitingRoom.centertWaitingRoom.userRow);
	}
	
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

	public void showRoomUserList(int idx) {
		waitingRoom.eastWaitingRoom.roomUserModel.setNumRows(0);
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
	
	public void updateRoomName() {
		System.out.println(getTitle());
		chattingRoom.northChattingRoom.roomTitleL.setText(getTitle());
		chattingRoom.northChattingRoom.roomTitleL.setFont(new Font("Verdana", Font.ITALIC, 18));
	}
	public void updateAllUserList() {
		chatClient.sendMessage(Protocol.ALL_USER_LIST + Protocol.DELEMETER + nickName);
	}
	
	public void updateRoomUserList(int idx) {
		System.out.println("토크프레임에 업에이트룸유져리스트 확인");
		chatClient.sendMessage(Protocol.ROOM_USER_LIST + Protocol.DELEMETER + idx);
	}

	public void removeAllUserList() {
		System.out.println("리무브 실행");
		waitingRoom.eastWaitingRoom.model.setNumRows(0);
		chattingRoom.eastChattingRoom.userAllModel.setNumRows(0);
		chattingRoom.eastChattingRoom.chatUserModel.setNumRows(0);
	}

	public void removeRoomList() {
		waitingRoom.centertWaitingRoom.model.setNumRows(0);
	}
	
	public void removeRoomUserList() {
		chattingRoom.eastChattingRoom.chatUserModel.setNumRows(0);
	}

	public void addAllUserList(String user) {
		waitingRoom.eastWaitingRoom.userList.add(user);
	}

	public void addAllRoomList() {
		chatClient.sendMessage(Protocol.ROOM_LIST + Protocol.DELEMETER + nickName);
	}

	public void closing() {
		chatClient.sendMessage(Protocol.DISCONNECT + Protocol.DELEMETER + nickName);
		chatClient.stopClient();
	}

	public void finish() {
		closing();
		setVisible(false);
		dispose();
		System.exit(0);
	}

	public void eventRegist() {

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});

	}

	

}
