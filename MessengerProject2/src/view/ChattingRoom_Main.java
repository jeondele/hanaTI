package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChattingRoom_Main extends Panel {
	
	TalkFrame talkFrame;
	BorderLayout borderLayout;
	
	ChattingRoom_East eastChattingRoom;
	ChattingRoom_Center centerChattingRoom;
	ChattingRoom_North northChattingRoom;
	ChattingRoom_South southChattingRoom;
	
	public ChattingRoom_Main (TalkFrame talkFrame) {
		
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

	public void setContents() {
		setLayout(borderLayout);
		add(eastChattingRoom, borderLayout.EAST);
		add(new Label(""), borderLayout.WEST);
		add(centerChattingRoom, borderLayout.CENTER);
		add(northChattingRoom, borderLayout.NORTH);
		add(southChattingRoom, borderLayout.SOUTH);
	}

	public void eventRegist() {

		northChattingRoom.exitChatB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				talkFrame.changeCard("WAIT");
			}
		});
		
		centerChattingRoom.sendB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					talkFrame.sendMessage();
			}
		});
		
	}
}
