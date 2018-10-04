package character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class MemoryStreamExample {
	//플레인 텍스트만 읽을 수 있다.
	public static void main(String[] args) throws IOException {
		String message = "187기 하나금융 TI";
		StringReader sr = new StringReader(message);
		System.out.println((char)sr.read());
		
	}
	
}
