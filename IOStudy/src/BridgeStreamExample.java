import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BridgeStreamExample {

	public static void main(String[] args) throws IOException {
		System.out.print("당신의 이름 : ");
		//System.in -- 바이트 스트림으로 읽어드린다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		System.out.println(name);
	}

}
