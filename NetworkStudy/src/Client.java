import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 클라이언트의 데이터 수신 및 처리
 * @author 전상일
 *
 */
public class Client extends Thread {
	private boolean running;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	
	public Client(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader( new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		running = true;
	}
	
	public void receive() {
		while(running) {
			String clientMessage = null;
			try {
				clientMessage = in.readLine();
				
				System.out.println("클라이언트 수신 데이터: " + clientMessage);
				if (clientMessage.equalsIgnoreCase("exit")) {
					break;
				}
				out.println(clientMessage);
			} catch (IOException e) {
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
	
	//얘가 소켓을 가진다.
	@Override
	public void run() {
		receive();
	}
}
