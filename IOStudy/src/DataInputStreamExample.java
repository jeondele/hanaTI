import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamExample {

	static final String path = "example3.dat";
	public static void main(String[] args) throws IOException {
		boolean flag = false;
		char c = 0;
		int age = 0;
		double weight = 0;
		String message = null;
		//buffer를 통해서 바이트로 바꾸는 것은 좋지 않다.
		
		DataInputStream in = new DataInputStream(new FileInputStream(path));
		//버퍼를 쓰진 않는다.
//		DataOutputStream out2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));

		flag = in.readBoolean();
		c = in.readChar();
		age = in.readInt();
		weight = in.readDouble();
		message = in.readUTF();
		
		System.out.println(flag);
		System.out.println(c);
		System.out.println(age);
		System.out.println(weight);
		System.out.println(message);
		
		in.close();
		
		//오롯이 프로그램에서만의 데이터는 다른데서 열리면 안된다.
		//이것을 그대로 읽으려면 읽는 로직을 반드시 작성해야한다.
	}

}
