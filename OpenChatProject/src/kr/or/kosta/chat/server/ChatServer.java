package kr.or.kosta.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Chatting Server
 * @author 김기정
 */
public class ChatServer {
	public static final int PORT = 7777;
	private boolean running;
	private ServerSocket serverSocket;
	private Hashtable<String, Client> clients;
	
	public boolean isRunning() {
		return running;
	}

	public Hashtable<String, Client> getClients() {
		return clients;
	}
	
	public void startUp() throws IOException {
		try {
			serverSocket = new ServerSocket(PORT);
		}catch (Exception e) {
			throw new IOException("["+PORT + "] 포트 충돌로 ChatServer를 구동할 수 없습니다.");
		}
		
		running = true;
		clients = new Hashtable<String, Client>();
		System.out.println("BTS["+PORT + "] ChatServer Start....");
		
		while(running) {
			try {
				Socket socket = serverSocket.accept();
				Client client = new Client(socket, this);
				client.start();
				
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void shutDown() {}
	
	public void addClient(Client client) {
		clients.put(client.getNickName(), client);
	}
	
	
	public int getClientCount() {
		return clients.size();
	}
	
	public boolean isExistNickName(String nickName) {
		return clients.containsKey(nickName);
	}
	
	public boolean removeClient(Client client) {
		return clients.remove(client.getNickName(), client);
	}
	
	
	public void sendAllMessage(String message) {
		//메세지 줄 때 동기화처리 할 수 있도록 elements 메소드 사용
		Enumeration<Client> e = clients.elements();
		while(e.hasMoreElements()) {
			Client client = e.nextElement();
			client.sendMessage(message);
		}
	}
	
}






