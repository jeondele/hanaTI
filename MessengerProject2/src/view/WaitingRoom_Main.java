package view;

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

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import common.Protocol;

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

	public void setContents() {
		setLayout(borderLayout);
		add(eastWaitingRoom, borderLayout.EAST);
		add(new Label(""), borderLayout.WEST);
		add(centertWaitingRoom, borderLayout.CENTER);
		add(northWaitingRoom, borderLayout.NORTH);
		add(southWaitingRoom, borderLayout.SOUTH);
	}

	public void eventRegist() {
		
		northWaitingRoom.exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				talkFrame.closing();
				talkFrame.changeCard("LOGIN");
			}
		});

		southWaitingRoom.enterRoomB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				talkFrame.changeCard("CHAT");
			}
		});

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
				}
			}
		});
		
		inputPanel.cancelB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		
		southWaitingRoom.enterRoomB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int idx = centertWaitingRoom.roomTable.getSelectedRow();
				talkFrame.sendMessage(idx);
				talkFrame.updateAllUserList();
				
			}
		});
		
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
		
		centertWaitingRoom.roomTable.addMouseListener(new MouseListener() {
	         
	         @Override
	         public void mouseClicked(MouseEvent e) {
	            int idx = centertWaitingRoom.roomTable.getSelectedRow();
	            talkFrame.updateRoomUserList(idx);
	         }
	         
	         @Override
	         public void mouseReleased(MouseEvent e) {}
	         
	         @Override
	         public void mousePressed(MouseEvent e) {}
	         
	         @Override
	         public void mouseExited(MouseEvent e) {}
	         
	         @Override
	         public void mouseEntered(MouseEvent e) {}
	      });

	}
}
