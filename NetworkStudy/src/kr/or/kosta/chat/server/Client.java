package kr.or.kosta.chat.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import kr.or.kosta.chat.common.Protocol;

public class Client extends Thread{
	
	private ChatServer chatServer;
	
	private boolean running;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	/** 클라이언트 식별자 */
	private String nickName ;
	
	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	//업무 분석이 되어야 논리적으로 왜 필요한지 안다.
	public Socket getSocket() {
		return socket;
	}

	public Client(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		running = true;
	}
	
	public void receiveMessage() {
		while(running) {
			String clientMessage = null;
			try {
				clientMessage = in.readLine();
				
				System.out.println("[Debug] : 클라이언트 수신 데이터: " + clientMessage);
				if (clientMessage.equalsIgnoreCase("exit")) {
					break;
				}
				//할일 들을 process 메소드에 넣어주어야한다.
//				out.println(clientMessage);
				process(clientMessage);
			} catch (IOException e) {
				e.getStackTrace();
			}
			
		}
		
		if (socket != null) {
			try {
				in.close();
				out.close();
				socket.close();
			} catch (IOException e) {} 
		}
	}
	
	/**
	 * 클라이언트의 메시지를 파싱하여 서비스 제공
	 * @param message
	 */
	public void process(String message) {
//		String[] tokens = message.split(Protocol.DELEMETER);
//		String protocol = tokens[0];
//		String nickName = tokens[1];
//		if (protocol.equals(1000) && !chatServer.getClients().containsKey(nickName)) {
//			chatServer.addClient(this);
			sendMessage(message);
//		}
	}
	
	public void sendMessage(String message) {
		out.println(message);
	}
	
	public void run() {
		receiveMessage();
	}
}
