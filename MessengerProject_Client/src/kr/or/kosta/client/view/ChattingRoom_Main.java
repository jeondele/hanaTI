package kr.or.kosta.client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import kr.or.kosta.client.common.Protocol;


/**
 * 채팅방의 패널클래스들을 합쳐주는 패널 클래스
 * 
 * @author 전상일
 *
 */
public class ChattingRoom_Main extends Panel {

	TalkFrame talkFrame;
	BorderLayout borderLayout;

	ChattingRoom_East eastChattingRoom;
	ChattingRoom_Center centerChattingRoom;
	ChattingRoom_North northChattingRoom;
	ChattingRoom_South southChattingRoom;

	public ChattingRoom_Main(TalkFrame talkFrame) {

		this.talkFrame = talkFrame;
		borderLayout = new BorderLayout(20, 20);

		eastChattingRoom = new ChattingRoom_East();
		eastChattingRoom.setPreferredSize(new Dimension(200, HEIGHT));
		centerChattingRoom = new ChattingRoom_Center();
		centerChattingRoom.setPreferredSize(new Dimension(350, HEIGHT));
		northChattingRoom = new ChattingRoom_North();
		southChattingRoom = new ChattingRoom_South();
		setContents();
		eventRegist();
	}
	/**
	 *  화면의 구성들을 세팅하는 메소드
	 */
	public void setContents() {
		setLayout(borderLayout);
		add(eastChattingRoom, borderLayout.EAST);
		add(new Label(""), borderLayout.WEST);
		add(centerChattingRoom, borderLayout.CENTER);
		add(northChattingRoom, borderLayout.NORTH);
		add(southChattingRoom, borderLayout.SOUTH);
	}

	/**
	 *  채팅방에서 발생하는 모든 이벤트들을 처리하는 메소드
	 */
	public void eventRegist() {
		
		//채팅방나가기 버튼을 누를 때 카드레이아웃을 대기방으로 전환, 초이스 버튼 삭제
		northChattingRoom.exitChatB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				talkFrame.changeCard("WAIT");
			}
		});
		
		//전체메세지 버튼을 누를시 초이스 박스에 전체메세지를 띄움
		southChattingRoom.msgAllB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				centerChattingRoom.msgToC.select("전체메세지");;
			}
		});
		
		//실질적인 채팅창 메세지 전화 부분
		centerChattingRoom.sendB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(centerChattingRoom.msgToC.getSelectedItem().equals("전체메세지")) talkFrame.sendMessage();
				else talkFrame.sendSpecificMessage(centerChattingRoom.msgToC.getSelectedItem());
			}
		});

		// 초대하고 싶은 사람 클릭 && 버튼 누를 시 초대 기능 수행
		southChattingRoom.inviteB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int cnt = 0;
				int row = eastChattingRoom.userAllTable.getSelectedRow();
				int col = eastChattingRoom.userAllTable.getSelectedColumn();
				String sendTo = (String) eastChattingRoom.userAllTable.getValueAt(row, col);
				Hashtable<String, String> users = talkFrame.getChatClient().getUserInfo();
				Enumeration<String> keys = users.keys();
				while (keys.hasMoreElements()) {
					String key = keys.nextElement();
					if (key.equals(sendTo) && users.get(key).equals("대기실")) {
						cnt++;
						talkFrame.sendSpecificMessage(Protocol.CHAT_INVITATION, talkFrame.getNickName(), sendTo);
						return;
					}
				}
				if (cnt == 0)
					JOptionPane.showMessageDialog(null, "대기실에 있는 사용자를 눌러주세요", "알림", JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		// 초대메세지를 보낼 대상을 선택하고 초대메세지를 보냄
		southChattingRoom.msgB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int cnt = 0;
				int row = eastChattingRoom.chatUserTable.getSelectedRow();
				int col = eastChattingRoom.chatUserTable.getSelectedColumn();
				String sendTo = (String) eastChattingRoom.userAllTable.getValueAt(row, col);
				Hashtable<String, String> users = talkFrame.getChatClient().getUserInfo();
				Enumeration<String> keys = users.keys();
				while (keys.hasMoreElements()) {
					String key = keys.nextElement();
					System.out.println(key);
					if (key.equals(sendTo)) {
						cnt++;
						talkFrame.sendSpecificMessage(Protocol.CHAT_INVITATION, talkFrame.getNickName(), sendTo);
						return;
					}
				}
				if (cnt == 0)
					JOptionPane.showMessageDialog(null, "대기실에 있는 사용자를 눌러주세요", "알림", JOptionPane.PLAIN_MESSAGE);
			}
		});
	}
}
