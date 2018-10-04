import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
	
	static final String path = "example2.dat";
	
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream out = new BufferedOutputStream(fos); //내부적으로 512바이트를 가지고 버퍼읽어들임
		out.write(10); //BufferedOutputStream에다가 쓰는것이다. 하드웨어 텍스트 자체에 바로 쓰는 것이 아님;
		out.write(20);
		byte[] data = { 5, 6, 7, 8, 9 };
		out.write(data);
		out.flush(); //flush가 없어도 써지긴 한다. 끝날때는 나머지 애들을 다 쓰고 끝난다.
		System.out.println("파일에 데이터 썻음..");
	}

}
