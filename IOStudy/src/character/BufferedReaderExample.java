package character;

import java.io.IOException;
import java.io.PrintWriter;

public class BufferedReaderExample {
	//플레인 텍스트만 읽을 수 있다.
	public static void main(String[] args) throws IOException {
		String path = "example6.html";
		PrintWriter out = new PrintWriter(path);
		out.println("<html>");
		out.println("<body>");
		out.println("<b>텍스트 파일입니다....</b>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}

}
