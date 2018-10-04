class WhileExample {
	public static void main(String[] args) {
		int i = 10;
		while (i > 0) {
			System.out.println("코스타187기 화이팅!");
			i--;
		}
		
		int sum = 0;
		int evenSum = 0;
		int oddSum = 0 ;

		while (i < 100) {
			i++;
			if (i%2 ==0){
				evenSum +=i;
			} else {
				oddSum +=i;
			}
			sum +=i;
			
		}

		System.out.println("합 :" + sum);
		System.out.println("짝수합 :" + evenSum);
		System.out.println("홀수합 :" + oddSum);
	}
}
