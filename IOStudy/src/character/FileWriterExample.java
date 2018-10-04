package character;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
	//플레인 텍스트만 읽을 수 있다.
	public static void main(String[] args) throws IOException {
		String path = "example5.txt";
		String message = "아 배고파....";
		FileWriter fout = new FileWriter(path);
		
		char[] chars = new char[100];
		
		message.getChars(0, message.length(), chars, 0);
		
		fout.write(chars);
//		fout.close();
		
		BufferedWriter bw = new BufferedWriter (fout); //filewriter에 인코딩 기능까지 들어있는거. 가장많이 쓴다.
		bw.write(message);
		bw.close();
	}

}
