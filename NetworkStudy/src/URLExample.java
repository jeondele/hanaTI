import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class URLExample {

	public static void main(String[] args) {
		// 네트워크에서 얻어올때 브릿지 스트림이 필요할 수도 있고, 텍스트로 받을 수 도 있다.
//		String urlString = "http://www.daum.net:80/index.html"; //웹서버라는 프로그램에 접속한것 :80은 안써줘도 된다.
		String urlString = "https://movie.v.daum.net/v/glUEZ0Nzjb"; //웹서버라는 프로그램에 접속한것 :80은 안써줘도 된다.
		URL url = null;
		try {
			//읽는 것 ... 쓰는 것은 절대 안된다.
			url = new URL(urlString);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			
			InputStream in = url.openStream();
//			
//			byte[] buffer = new byte[1024];
//			int count = 0;
//			while((count = in.read(buffer)) != -1) {
//				String text = new String(buffer, 0, count);
//				System.out.println(text);
//			}
			//바이트 스트림이니까 브릿지가 필요하구나 
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));	
			String line = null;
			while((line = br.readLine())!=null) {
				System.out.println(line);
			}
			
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null,"서버를 찾을 수 없습니다...");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"서버를 찾을 수 없습니다...");
		}
	}

}
