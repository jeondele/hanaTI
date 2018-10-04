/** 
*	자바 표준 api의 기본 클래스 사용하기
*/

public class ApiExample {
	public static void main(String[] args) {
		String str;
		str = new String("자바가 좋아요!!!!!!!!");
		System.out.println(str);
		int length = str.length();
		System.out.println(length);
		System.out.println(str.charAt(9));
		System.out.println(Math.abs(-10));
		System.out.println(Math.sqrt(-10));
		
	}
}