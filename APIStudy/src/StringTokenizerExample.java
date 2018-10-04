import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		String data = "2018-08-23";
		StringTokenizer st = new StringTokenizer(data,"-");
		System.out.println(st.countTokens());
		
		System.out.println("----------------------");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

}
 