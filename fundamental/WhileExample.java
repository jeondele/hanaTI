class WhileExample {
	public static void main(String[] args) {
		int i = 10;
		while (i > 0) {
			System.out.println("�ڽ�Ÿ187�� ȭ����!");
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

		System.out.println("�� :" + sum);
		System.out.println("¦���� :" + evenSum);
		System.out.println("Ȧ���� :" + oddSum);
	}
}
