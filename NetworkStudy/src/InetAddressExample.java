import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS와의 통신을 위해 IP <-> Domain 정보 제공
 * @author 전상일
 *
 */
public class InetAddressExample {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ia = InetAddress.getLocalHost(); //팩토리 메소드
		System.out.println(ia.getHostAddress());
		
		String domain = "www.naver.com";
		InetAddress ia2 = InetAddress.getByName("www.daum.net");
		InetAddress ia3 = InetAddress.getByName("www.naver.net");
		System.out.println(ia2.getHostAddress());
		System.out.println(ia3.getHostAddress());
		
		InetAddress[] ias = InetAddress.getAllByName("www.google.com");
		for (InetAddress inetAddress : ias) {
			System.out.println(inetAddress);
		}
	}

}
