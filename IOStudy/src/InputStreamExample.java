import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {

	static final String path = "C:\\Users\\kosta\\Downloads\\epp420_64bit.exe";
	public static void main(String[] args) {
		InputStream in = null;
		try {
			in = new FileInputStream(path);
			System.out.println(in.available());
			
			//byte[] (버퍼) 단위로 입력
			byte[] buffer = new byte[4*1024];
			int count = 0;
			count = in.read(buffer);
			
			System.out.println(count);
			
			for (byte b : buffer)
			{
				System.out.println(b);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
