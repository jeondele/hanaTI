package character;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
	//플레인 텍스트만 읽을 수 있다.
	public static void main(String[] args) throws IOException {
		String path = "src/BufferedInputStreamExample.java";
		FileReader in = new FileReader(path);
//		System.out.println((char)n.read()); //105 ---- import의 'i'        인코딩 / 디코딩이 안되어있어서 이런다.
		char[] chars = new char[1024];
		int count = 0 ;
		while((count=in.read(chars))!= -1) {
			for(char c : chars) {
				System.out.print(c);
			}
		}
		
		//한 바이트씩 읽으려고 하니까 한글은 깨지게 되는 것이다!!!
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer2 = new byte[1024];
		count = 0;
		while((count=fis.read(buffer2))!= -1) {
			for(byte c : buffer2) {
				System.out.print(c);
			}
		} 
		
//		바이트를 char로 바꿔 주는 string 생성
	}

}
