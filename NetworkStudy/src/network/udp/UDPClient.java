package network.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 우리가 배운건 모두 동기식 입출력을 배운것이다.
 * nio로 하는 것...
 * 
 * UDP기반 클라이언트
 */
public class UDPClient {
	String serverIP;
	DatagramSocket dataSocket;	
	DatagramPacket sendPacket;
	
	public UDPClient(){
		this("localhost");
	}
	public UDPClient(String serverIP){
		this.serverIP = serverIP;
	}
	
	
	public void clientStart() throws Exception{
		// DatagramPacket 송수신을 위한 DatagramSocket 생성
		dataSocket  = new DatagramSocket(8282);// 수신을 위한 포트 서버와의 포트번호는 다르다. 8282는 내가 서버에 보낸 후 받을 때 쓰는 번호;

		String inputMessage = "안녕하세요. 김기정입니다..";
		byte[] buffer = inputMessage.getBytes(); //인코딩 해주는 ;
		
		// 서버에 전송할 우편물 생성
		sendPacket = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(serverIP), 2018); //우편물의 주소를 써주는 역할
		
		// 서버에 데이터(우편물) 전송
		dataSocket.send(sendPacket); //우편물 던지듯이 딱 보내면 서버의 리지브에 딱 도착.. 
		
		// 데이터 수신을 위한 DatagramPacket(빈우편물) 생성
		DatagramPacket dataReceivePacket = new DatagramPacket(buffer, buffer.length); //에코된 걸 받기 위해 패킷을 또 생서, 빈통을 만들어놓고 서버로부터 들어온 것을 받아야한다. 
		dataSocket.receive(dataReceivePacket);
		System.out.println("서버로부터 에코된 메시지: " + new String(buffer, 0, buffer.length));			
	}
	
	public void close() {
		if (dataSocket != null) {
			dataSocket.close();
		}
	}
	
	
	public static void main(String[] args) {
		UDPClient client = new UDPClient();
		try {
			client.clientStart();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			client.close();
		}
	}

}
