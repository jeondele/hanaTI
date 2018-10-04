import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileExample {

	public static void main(String[] args) throws IOException {
		String path = "c:/some.dat";
		
		System.out.println("존재여부 :::::" + new File(path).exists());
		
		System.out.println("---------------------------------------\n");
		path = "C:\\Users\\kosta\\Downloads\\epp420_64bit.exe";
		
		System.out.println("파일용량 : " + new File(path).length());
		
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String strDate = sdfDate.format(new File(path).lastModified());
	    
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTimeInMillis(new File(path).lastModified());
	    
	    
		System.out.println("변경날짜 : " + strDate);
		System.out.println("---------------------------------------\n");

		path = "c:/KOSTA187";
		System.out.println("패스가 디렉토리인지 파일인지 출력::::: 파일입니까?  " + new File(path).isFile() + " 디렉토리입니까?   " + new File(path).isDirectory());
		System.out.println("---------------------------------------\n");

		System.out.println("디렉토리 경우 이 디렉토리의 서브디렉토리 목록 출력");
		File[] listFiles = new File(path).listFiles();
		int i = 1;
		for (File file : listFiles) {
			System.out.println("서브 디렉토리 목록..." + i +"."+ file.getName());
			i++;
		}
		System.out.println("---------------------------------------\n");

		path = "example.dat";
		System.out.println("이 파일의 절대경로 출력 :::::"+ new File(path).getAbsolutePath());
		System.out.println(new File(path).getPath());
		System.out.println(new File(path).toURL());
		System.out.println(new File(path).toURI()); //URL보다 더 광범위한 주소 체계
		
		
		
		path = "xxx.dat";
		File file2 = new File(path);
		System.out.println(file2.createNewFile());
		
		File f = File.createTempFile("some", ".dat"); //만들어지는 주소는 현재의 디렉토리가 아니다.
		System.out.println(f.getAbsolutePath());
		FileOutputStream out = new FileOutputStream(f);
		out.write(10);
		
		f.deleteOnExit(); //temp file이기때문에 알아서 삭제된다.
		
		File dir = new File("c:/KOSTA187/xxx");
//		System.out.println(dir.mkdirs());
		dir.delete();
		
		File[] drives = File.listRoots();
		for (File file3 : drives) {
			System.out.println(file3);
		}
	}
}
