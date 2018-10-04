import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamExample {

	static final String path = "C:\\Users\\kosta\\Downloads\\epp420_64bit.exe";
	public static void main(String[] args) throws IOException {
		//Node Stream :filter stream의 기능이 없다.
		InputStream fin = null;
		fin = new FileInputStream(path);
		
		
		// Filter Stream
		BufferedInputStream in = null; //임의 접근 가능하게 해줌 fin만으로도 파일 읽을 수 있음
		in = new BufferedInputStream(fin);
		in.mark(0); //readlimit이 0이면 첫번째 바이트부터 읽어드린다.
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		System.out.println(in.read());
		in.skip(20); // 파일 포인터 개념이 있어서 스킵도 가능하다
		in.reset();
		System.out.println(in.read());

	}

}
