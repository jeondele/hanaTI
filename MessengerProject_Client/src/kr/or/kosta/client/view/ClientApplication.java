package kr.or.kosta.client.view;

import kr.or.kosta.client.model.ChatClient;

/**
 * 클라이언트의 메인 창을 실행하는 클래스
 * 
 * @author 전상일
 *
 */
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
