class OperatorExample {
	public static void main(String[] args) {
		int x = 50, y = 20;
		String k = "a", p = "b";
		
		//산술연산자
		System.out.println("결과 " + x + y); //결과 5020
		System.out.println("결과 " + (x + y)); // 결과 70
		System.out.println("나머지 : " + (x % y)); // 나머지 10

		//복합대입연산자
		x +=y ;
		System.out.println(x);

		// 형변환연산자
		double weight = 78.343434;
		System.out.println((int)weight);

		// 증감연산자
		x = 100;
		System.out.println(x++);
		System.out.println(x);
		System.out.println(++x);

		//비트연산자
		x = 10;
		System.out.println(x * 2 * 2 * 2);
		x = 10;
		System.out.println(x << 4);

		//조건삼항연산자
		int a = 3, b = 2, c = 5, max;
		max = (a > b) ? a : b;
		max = (max > c ) ? max : c;
		System.out.println("최대값 :" + max);

	}
}
