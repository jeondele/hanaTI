import java.io.IOException;
import java.util.Scanner;

public class StandardInOutExample {

	public static void main(String[] args) throws IOException {
		System.out.print("당신의 이름 : ");
		Scanner sc = new Scanner(System.in);
		
		byte[] buffer = new byte[100];
		int count = System.in.read(buffer);
		
		//문자 디코딩 처리;
		String name = new String(buffer, 0, count-2); //-2를 안해주면 enter값 2byte가 들어간다.
		System.out.println("당신의 이름은 "+ name + "입니다..");
		
		System.out.print("당신의 나이 : ");
		//위와 같이 할 때는 숫자를 받을 때는 아스키코드값이 들어간다. 
		count = System.in.read(buffer);
		int age = Integer.valueOf(new String(buffer, 0, count-2));
		System.out.println(age + 10);
	}

}
