/**
* 자바 데이터유형 테스트
*
*
*/
class DataTypeExample {
	public static void main(String[] args) {
		boolean flag = true;// false
		boolean flag2 = false;
		char x = '\uD55C';
		char y = '\uAE00';
		System.out.println(flag2);
		System.out.println(x);
		System.out.println(y);

		// 제어문자
		System.out.println("김\b기정 \n강사\t입니다.");
		System.out.println("\'자바\'가 \\좋아요.");

		//byte, short, int , long
		// long 주의사항
		long money = 500000L;
		System.out.println(money);
		System.out.print("김기정");
		System.out.printf("%d", 100);
		System.out.println();
		//float, double
		float pi = 3.141592F;
		System.out.println(pi);
	}
}
