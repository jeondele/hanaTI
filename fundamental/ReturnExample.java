class ReturnExample {
	public static void main(String[] args) {
		System.out.println("���α׷� ���۵�...");

		for (int j = 0; j < 100 ; j++ ) {
			System.out.println("�ڽ�Ÿ 187�� ȭ����!"+ "         " + j);
			if (j==50) {
				return;
			}
		}

		System.out.println("���α׷� �����...");
		
	}
}
