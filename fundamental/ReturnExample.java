class ReturnExample {
	public static void main(String[] args) {
		System.out.println("프로그램 시작됨...");

		for (int j = 0; j < 100 ; j++ ) {
			System.out.println("코스타 187기 화이팅!"+ "         " + j);
			if (j==50) {
				return;
			}
		}

		System.out.println("프로그램 종료됨...");
		
	}
}
