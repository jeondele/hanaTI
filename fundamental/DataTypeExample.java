/**
* �ڹ� ���������� �׽�Ʈ
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

		// �����
		System.out.println("��\b���� \n����\t�Դϴ�.");
		System.out.println("\'�ڹ�\'�� \\���ƿ�.");

		//byte, short, int , long
		// long ���ǻ���
		long money = 500000L;
		System.out.println(money);
		System.out.print("�����");
		System.out.printf("%d", 100);
		System.out.println();
		//float, double
		float pi = 3.141592F;
		System.out.println(pi);
	}
}
