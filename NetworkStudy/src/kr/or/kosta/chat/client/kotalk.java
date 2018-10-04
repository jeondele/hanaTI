package kr.or.kosta.chat.client;

import kr.or.kosta.chat.client.ChatFrame;

public class kotalk {

	public static void main(String[] args) {
		ChatClient chatClient = new ChatClient();
		ChatFrame uf = new ChatFrame("KOTALK");
		uf.setContents();
		uf.setSize(600, 700); //pixel로만 가능
		uf.setCenter();
		uf.eventRegist();
		uf.setVisible(true);

		uf.setChatClient(chatClient);
		//버튼 누를때 연결이 되어야 한다. 
	}

}
