class OperatorExample {
	public static void main(String[] args) {
		int x = 50, y = 20;
		String k = "a", p = "b";
		
		//���������
		System.out.println("��� " + x + y); //��� 5020
		System.out.println("��� " + (x + y)); // ��� 70
		System.out.println("������ : " + (x % y)); // ������ 10

		//���մ��Կ�����
		x +=y ;
		System.out.println(x);

		// ����ȯ������
		double weight = 78.343434;
		System.out.println((int)weight);

		// ����������
		x = 100;
		System.out.println(x++);
		System.out.println(x);
		System.out.println(++x);

		//��Ʈ������
		x = 10;
		System.out.println(x * 2 * 2 * 2);
		x = 10;
		System.out.println(x << 4);

		//���ǻ��׿�����
		int a = 3, b = 2, c = 5, max;
		max = (a > b) ? a : b;
		max = (max > c ) ? max : c;
		System.out.println("�ִ밪 :" + max);

	}
}
