package view;

import model.ChatClient;

public class ClientApplication {

	public static void main(String[] args) {

		TalkFrame frame = new TalkFrame("::: HTS :::");
		frame.setSize(900, 800);
		frame.setCenter();
		frame.setVisible(true);
		frame.setResizable(false);

		ChatClient chatClient = new ChatClient(frame);
		frame.setChatClient(chatClient);
	}
}
