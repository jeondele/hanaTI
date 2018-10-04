package kr.or.kosta.chat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 
 * 서버와의 통신 대행자
 * 
 * @author 전상일
 *
 */
public class ChatClient {
	public static final String SERVER = "127.0.0.1";
	public static final int PORT = 7777;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	private boolean running;

	public void connectServer() throws Exception {
		try {
			socket = new Socket(SERVER, PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			running = true;
			
		} catch (Exception e) {
			throw new Exception("네트웤 끊어졌을 수도 있고, 서버가 찾을 수 없을 수도 있고, 포트번호가 잘못되었을 수도 있다.");
		}

	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}

	public void stopClient() {
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {}
		}
	}

	public void sendMessage(String message) {
		if (out != null) out.println(message);
	}
	
	public String readMessage() {
		String message = null;
		if (in != null) {
			try {
				message = in.readLine();
			} catch (IOException e) {}
		}
		return message;
	}

	public void receiveMessage() {
		new Thread() {
			@Override
			public void run() {
				while(running) {
					String serverMessage = null;
					try {
						serverMessage = in.readLine();
						
						System.out.println("[Debug] : 서버 수신 데이터: " + serverMessage);
						process(serverMessage);
					
					} catch (IOException e) {
						System.out.println("네트워크가 끊어졌습니다..");
						break;
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
		}.start();
		
	}
	
	public void process(String message) {
		System.out.println(message);
	}
}
