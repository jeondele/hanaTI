package kr.or.kosta.chat.client;

import java.awt.Color;

public class kotalk {

	public static void main(String[] args) {
		
		RoomFrame frame = new RoomFrame("::: kotalk :::");
		frame.setContents();
		frame.setSize(1000, 800);
		frame.setCenter();
		frame.eventRegist();
		frame.setVisible(true);
		frame.setComponentSize();
		//frame.setBackground(Color.lightGray);
		
		ChatClient chatClient = new ChatClient(frame);
		frame.setChatClient(chatClient);

	}

}
