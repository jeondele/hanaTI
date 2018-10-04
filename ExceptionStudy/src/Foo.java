import java.io.IOException;

public class Foo {
	
	public void someMethod() {
		String message = null;
		//System.out.println(message.length()); // new nullpointException 발생 -> 출력하고 프로그램 셧다운
		//System.out.println(10/0); //new arithmeticException
		//메소드 콜스택 : 메세지를 계속 쌓아 놓고 , 스택에 있는 내용을 쫙 표현해준다
		
		int[] array = {1, 2, 3};
		System.out.println(array[3]); // new ArrayIndexOutOfBoundsException
	}
	
	public void someMethod2() {
		try {
			String message = null;
			System.out.println(message.length());
//			System.out.println(10/0); 
			int[] array = {1, 2, 3};
			System.out.println(array[3]);
		} catch(NullPointerException e) {
			System.out.println("인스턴스 생성 안됐습니다..");
			System.out.println(e.getMessage());
			e.printStackTrace(); // 비동기 처리되어있어서 순서대로 안나올 수 있다.
			return;
		} catch(ArithmeticException e) {
			System.out.println("숫자 오류입니다..");
			System.out.println(e.getMessage());
			e.printStackTrace(); // 비동기 처리되어있어서 순서대로 안나올 수 있다.
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("해당 인덱스가 없습니다..");
			System.out.println(e.getMessage());
			e.printStackTrace(); // 비동기 처리되어있어서 순서대로 안나올 수 있다.
		} catch(Exception e) {
			System.out.println("에러입니다");
			System.out.println(e.getMessage());
			e.printStackTrace(); // 비동기 처리되어있어서 순서대로 안나올 수 있다.
		} finally {
			System.out.println("예외 발생 여부와 상관없이 항상 실행 코드");
		}
	}
	
	
	public void someMethod3() throws NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException {
		String message = null;
		System.out.println(message.length()); // new nullpointException 발생 -> 출력하고 프로그램 셧다운
		System.out.println(10/0); //new arithmeticException
		//메소드 콜스택 : 메세지를 계속 쌓아 놓고 , 스택에 있는 내용을 쫙 표현해준다
		
		int[] array = {1, 2, 3};
		System.out.println(array[3]); // new ArrayIndexOutOfBoundsException
	}
	
	
	public static void main(String[] args) {
		System.out.println("jvm에 의해 프로그램 시작됨...");

		Foo foo = new Foo();
		//foo.someMethod2();
		try {
			foo.someMethod3();
		} catch (Exception e) {
			System.out.println("메인에서 모든 예외처리 완료!");
		} 
		
		try {
			//키보드톨부터 데이터 받기 위한 블락메소드가 실행됨.
			int value = System.in.read();
			System.out.println(value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 키보드에서 읽어들인 값은 int형
		
		System.out.println("프로그램 종료됨...");

	}
}
