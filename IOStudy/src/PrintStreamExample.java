import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;

public class PrintStreamExample {
	//모든 프로그램들이 읽을 수 있는 (호환되는 파일을 만들 때 사용)
	
	static final String path = "example4.dat";
	public static void main(String[] args) throws IOException {
		boolean flag = false;
		char c = '김';
		int age = 30;
		double weight = 66.7;
		String message = "입출력 프로그램입니다...";
		Calendar now = Calendar.getInstance();
		
//		PrintStream out = new PrintStream(new FileOutputStream(path));
		PrintStream out = new PrintStream(path); //위에 처럼 필터를 주지않고 바로 path를 지정할 수 있다.
		
		out.println(flag);
		out.println(c);
		out.println(age);
		out.println(weight);
		out.printf("%1$tF %1$tT", now);
		
		
		
		out.close();
		
		//오롯이 프로그램에서만의 데이터는 다른데서 열리면 안된다.
		//이것을 그대로 읽으려면 읽는 로직을 반드시 작성해야한다.
	}

}
