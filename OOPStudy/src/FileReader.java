// java FileReader [ 읽고자 하는 파일명1 ] [ 읽고자 하는 파일명2 ]
public class FileReader {

	public static void main(String[] args) {
		//입력이 안됐을 시 처리되는 것을 해줘야 한다.
		if(args.length != 2) {
			System.out.println("사용법 java FileReader [ 읽고자 하는 파일명1 ] [ 읽고자 하는 파일명2 ]");
			return; 	// if 다음 문장들 실행안하고 메인메소드의 끝 중괄호로 넘어감.
		}
		
		String fileName1 = args[0];
		String fileName2 = args[1];
		System.out.println(fileName1);
		System.out.println(fileName2);
		
		
		
	}

}
