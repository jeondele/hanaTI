package kr.or.kosta.chat.server;

import java.io.IOException;

public class BTS {
	//서버도 서버화면이 필요하다. log분석을 할 수 있는 화면이 필요하다.
	public static void main(String[] args) {
		ChatServer chatServer = new ChatServer();
		try {
			chatServer.startUp();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
