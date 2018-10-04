import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP/IP 기반의 socket 프로그래밍 원리
 * 
 * @author 전상일
 *
 */
public class SocketExample {

//	public static final String domain = "www.naver.com";
	public static final String domain = "192.168.0.119";
	public static final int port = 7777;
	
	public static void main(String[] args) {
	
		InputStream in = null;
		OutputStream out = null;
		Socket socket = null;
		try {
//			Socket socket = new Socket(InetAddress.getByName(domain), 80);
			socket =  new Socket(InetAddress.getByName(domain), 7777);
			System.out.println("------");
			System.out.println(domain + "서버와 연결됨.....");
			System.out.println("서버와 연결됨.....");
			
			in = socket.getInputStream();
			out = socket.getOutputStream();
			
			/*
			out.write(500);
			System.out.println("서버에 데이터 전송");
			int data = in.read();
			
			System.out.println("에코된 데이터" +data);
			*/
			PrintWriter pw = new PrintWriter(out, true); //내부적으로 버퍼쓴다. 그래서 flush가 필요하다 그래서 true를 해야한다.
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				String inputMessage = sc.nextLine();
				pw.println(inputMessage);
				if(inputMessage.equalsIgnoreCase("exit")) {
					break;
				}
	//			pw.flush(); // 바로바로 보내는거다.
				String serverMessage = br.readLine();
				System.out.println("에코된 데이터: " +serverMessage);
			}
			
		} catch (IOException e) {
			System.out.println("서버를 연결할 수 없습니다..");
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
