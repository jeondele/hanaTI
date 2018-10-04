import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

public class InputStreamExample2 {

	static final String path = "C:\\Users\\kosta\\Downloads\\epp420_64bit.exe"; //경로가 고정되어있는거보다는 다르게 하는것이 좋다.
	public static void main(String[] args) {
		InputStream in = null;
		File file = new File(path); //무조건 빨대를 꽂지않고 존재여부를 확인하는 것이 좋다.
		if(!file.exists()) {
			JOptionPane.showMessageDialog(null, "파일이 없시유...");
			return;
		}
		try {
			in = new FileInputStream(path);
			System.out.println(in.available());
			
			//byte[] (버퍼) 단위로 입력
			byte[] buffer = new byte[4*1024];
//			int count = in.read(buffer);
//			
//			System.out.println(count);
//			
//			for (byte b : buffer)
//			{
//				System.out.println(b);
//			}
			int count = 0;
			int totalCount = 0;
			while((count=in.read(buffer)) != -1) {
//				while((count=in.read(buffer, 2, buffer.length)) //3번째부터 저장) {
				System.out.println(count);
				totalCount += count;
			}
			
			System.out.println(in.available());
			System.out.println("파일 다 읽었음");
			
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
