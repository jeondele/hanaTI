package kr.or.kosta.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;

import kr.or.kosta.chat.common.Protocol;

public class ChatServer {
	public static final int port = 7777;
	private boolean running;
	private ServerSocket serverSocket;
	private Hashtable<String, Client> clients;
	
	public boolean isRunning() {
		return running;
	}
	
	public Hashtable<String, Client> getClients() {
		return clients;
	}
	public void setClients(Hashtable<String, Client> clients) {
		this.clients = clients;
	}
	
	//생성자에서 할일을 요기서
	public void startUp () throws IOException {
		//main에서 시작할 테니까 port 충돌, 그밖의 1,2개의 익셉션은 throws로 처리하는 것이 나을 것같다.
		//이 기능이 끝이 아니다.
		running = true;
		
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			throw new IOException("["+ port +"] 포트 충돌로 ChatServer를 구동할 수 없습니다.");
		}
		
		clients = new Hashtable<String, Client>();
		System.out.println("["+ port +"] 포트에서 ChatServer start...");
		
		//서버구동상태에서 메인에서 소켓처리를 할 수 는 없다. 그리고 한놈 때문에 서버를 중지 하기는 좀 그렇다. 그렇기 때문에 try-catch
		while(running) {
			try {
				Socket socket = serverSocket.accept();
				Client client = new Client(socket);
				client.start();
				if(addClient(client)) {
					client.sendMessage(Protocol.CONNECT_RESULT + Protocol.DELEMETER + "SUCCESS");
					//클라이언트가 담겨진 상태에서 작업하는 것이 좋다.
					System.out.println("######["+ socket.getInetAddress().toString() +"]님께서 서버에 연결하셨습니다. #####");
				} else {
					//서버쪽으로 보내야한다.
					client.sendMessage(Protocol.CONNECT_RESULT + Protocol.DELEMETER + "FAIL");

				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutDown() {
		
	}
	
	public boolean addClient(Client client) {
		//닉네임 쓰고있는지에 대한 유효성 검사
		if(clients.containsKey(client.getNickName())) {
			return false;
		}
		//닉네임이 key
		clients.put(client.getNickName(), client);
		return true;
	}
	
	public void removeClient(Client client) {
		
	}
	
	public void sendAllMessage(String message) {
		
	}
}
