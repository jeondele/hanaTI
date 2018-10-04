package character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PrintWriterExample {
	//플레인 텍스트만 읽을 수 있다.
	public static void main(String[] args) throws IOException {
		String path = "src/BufferedInputStreamExample.java";
		FileReader in = new FileReader(path);
//		System.out.println((char)n.read()); //105 ---- import의 'i'        인코딩 / 디코딩이 안되어있어서 이런다.
//		char[] chars = new char[1024];
//		int count = 0 ;
//		while((count=in.read(chars))!= -1) {
//			for(char c : chars) {
//				System.out.print(c);
//			}
//		}
		
		BufferedReader br = new BufferedReader(in);	//가장 중요한 역할 : 디코딩 : 문자셋을 ms949를 사용해서 buffer를 디코딩해준다.
//		String txt = br.readLine();
//		System.out.println(txt);
		String line = null;
		while((line=br.readLine()) != null) {
			System.out.println(line);
		}
	}

}
