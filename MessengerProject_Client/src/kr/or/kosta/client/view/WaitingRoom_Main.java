package kr.or.kosta.client.view;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import kr.or.kosta.client.common.Protocol;

/**
 * 대기실 모든 패널클래스를 담은 클래스
 * 
 * @author 전상일
 *
 */
public class WaitingRoom_Main extends Panel {
	TalkFrame talkFrame;
	BorderLayout borderLayout;

	WaitingRoom_East eastWaitingRoom;
	WaitingRoom_Center centertWaitingRoom;
	WaitingRoom_North northWaitingRoom;
	WaitingRoom_South southWaitingRoom;
	CreateRoom inputPanel;
	Dialog dialog;

	public WaitingRoom_Main(TalkFrame talkFrame) {
		this.talkFrame = talkFrame;

		borderLayout = new BorderLayout(20, 20);

		eastWaitingRoom = new WaitingRoom_East();
		eastWaitingRoom.setPreferredSize(new Dimension(250, HEIGHT));
		centertWaitingRoom = new WaitingRoom_Center();
		centertWaitingRoom.setPreferredSize(new Dimension(300, HEIGHT));
		northWaitingRoom = new WaitingRoom_North();
		southWaitingRoom = new WaitingRoom_South();
		inputPanel = new CreateRoom();
		dialog = new Dialog(talkFrame, "방 정보 설정", true);
		setContents();
		eventRegist();
	}
	/**
	 *  화면의 구성들을 세팅하는 메소드
	 */
	public void setContents() {
		setLayout(borderLayout);
		add(eastWaitingRoom, borderLayout.EAST);
		add(new Label(""), borderLayout.WEST);
		add(centertWaitingRoom, borderLayout.CENTER);
		add(northWaitingRoom, borderLayout.NORTH);
		add(southWaitingRoom, borderLayout.SOUTH);
	}

	//대기실에서 발생하는 모든 이벤트
	public void eventRegist() {
		
		//종료시 소켓 종료하는 기능
		northWaitingRoom.exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				talkFrame.closing();
				talkFrame.changeCard("LOGIN");
				
			}
		});

		//방에 입장하는 기능
		southWaitingRoom.enterRoomB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				talkFrame.changeCard("CHAT");
			}
		});

		//방을 만들기 위해 다이얼로그를 띄우는 기능
		southWaitingRoom.createRoomB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				dialog = new Dialog(talkFrame, "방 정보 설정", true);
				dialog.add(inputPanel);
				dialog.setSize(500, 200);

				int x = (talkFrame.getX() + talkFrame.getWidth());
				int y = (talkFrame.getY() + (talkFrame.getHeight() / 2));
				dialog.setLocation(x, y);
				dialog.setVisible(true);
			}
		});
		
		//방을 만드는 기능
		inputPanel.createB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (inputPanel.roomNameTF.getText() != null && inputPanel.memberLimitTF.getText() != null) {
					talkFrame.chattingRoom.centerChattingRoom.chatTA.append("######## 방장님이 입장하셨습니다, 즐챗☆☆☆ ########\n");
					talkFrame.sendMessage(inputPanel.roomNameTF.getText(), inputPanel.memberLimitTF.getText());
					talkFrame.changeCard("CHAT");
					dialog.setVisible(false);
					dialog.dispose();
					talkFrame.updateAllUserList();
					talkFrame.chattingRoom.centerChattingRoom.msgToC.add(talkFrame.getNickName());
				}
			}
		});
		
		//방 만들기를 취소하는 기능
		inputPanel.cancelB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		
		//방에 들어가는 기능
		southWaitingRoom.enterRoomB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = centertWaitingRoom.roomTable.getSelectedRow();
				talkFrame.sendMessage(idx);
				talkFrame.updateAllUserList();
				talkFrame.chattingRoom.centerChattingRoom.msgToC.add(talkFrame.getNickName());
			}
		});
		
		//방 검색 기능
		northWaitingRoom.searchRoomB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String roomName = northWaitingRoom.searchRoomTF.getText();
				int size = centertWaitingRoom.model.getRowCount();
				for (int i = 0 ; i < size; i ++) {
					if(roomName.equals(centertWaitingRoom.model.getValueAt(i, 1))) {
						talkFrame.removeRoomList();
						talkFrame.sendMessage(roomName);
					}
				}
			}
		});

		//방 검색시 해당 텍스트필드 클릭하면 필드를 리셋하는 기능
		northWaitingRoom.searchRoomTF.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				northWaitingRoom.searchRoomTF.setText(" ");
				northWaitingRoom.searchRoomTF.setText("");
				talkFrame.addAllRoomList();
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
	}
}
