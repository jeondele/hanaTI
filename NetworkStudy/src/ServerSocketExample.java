import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketExample {

	public static final int port = 7777;
	
	public static void main(String[] args) {
		boolean running = true;
		//내가 서버기 때문에 따른 ip는 필요없고 포트번호만 필요하다.
		try {
			ServerSocket serverSocket = new ServerSocket(7777);
			System.out.println(port + "포트에서 서버 실행....");
			while(running) {
				Socket socket = serverSocket.accept();
				InetAddress ia = socket.getInetAddress(); //아이넷 어드레스 클래스를 리턴한다.
				System.out.println(ia + " 클라이언트가 연결해옴 ");
				
				Client client = new Client(socket);
				client.start();
//				
//				InputStream in = socket.getInputStream();
//				OutputStream out = socket.getOutputStream();
//				/*
//				int data = in.read();
//				System.out.println("클라이언트 수신 데이터: " + data);
//				out.write(data); //에코 서버 -- 온 데이터를 그대로 틩겨주는것
//				*/
//				
//				PrintWriter pw = new PrintWriter(out,true);
//				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
