import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputStreamExample {

	static final String path = "example3.dat";
	public static void main(String[] args) throws IOException {
		boolean flag = false;
		char c = '김';
		int age = 30;
		double weight = 66.7;
		String message = "입출력 프로그램입니다...";
		//buffer를 통해서 바이트로 바꾸는 것은 좋지 않다.
		
		DataOutputStream out = new DataOutputStream(new FileOutputStream(path));
		//버퍼를 쓰진 않는다.
//		DataOutputStream out2 = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));

		out.writeBoolean(flag);
		out.writeChar(c);
		out.writeInt(age);
		out.writeDouble(weight);
		out.writeUTF(message);
		
		out.close();
		
		//오롯이 프로그램에서만의 데이터는 다른데서 열리면 안된다.
		//이것을 그대로 읽으려면 읽는 로직을 반드시 작성해야한다.
	}

}
