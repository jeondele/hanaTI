/**	
*	���α׷� ������ ���� ���ø����̼� Ŭ���� ����
*/

class AccountExample {
	public static void main(String[] args) {
		System.out.println("���� ���� ���ø����̼� ���۵�...");
		
		//Ŭ�����κ��� ��ü(�ν��Ͻ�) ����
		Account ac = new Account();

		//�ν��Ͻ��� �Ӽ��� ��� ���
		//ac.accountNum = "110392051733";
		//ac.accountOwner = "������";
		//ac.passwd = 123456789;
		//ac.restMoney = 303030;
		ac.setPasswd(123456789);
		boolean result = ac.checkPasswd(123456789);
		if (result){
			long money = ac.deposit(100000);
			System.out.println("�Ա� �� �ܾ� : " + ac.getRestMoney());
			money = ac.withdraw(10000);
			System.out.println("���� �� �ܾ� : " + ac.getRestMoney());
		} else {
			System.out.println("��й�ȣ Ȯ���ϼ���.");
		}

		Account ac2 = new Account();

		//�ν��Ͻ� ������ ��� jvm�� ���� �ڵ� �ʱ�ȭ ��.
		System.out.println(ac2.getAccountNum());
		System.out.println(ac2.getAccountOwner());
		System.out.println(ac2.getRestMoney());
		System.out.println(ac2.getPasswd());
		Account ac4 = new Account("ddddddddd", "������");
		Account ac3 = new Account("123456789", "������", 303, 12345000);
		System.out.println(ac3.deposit(100000));
		System.out.println(Account.bankName);
		Account.bankName = "Hana bank";
		System.out.println(Account.bankName);
		System.out.println(Account.sum(30,20));
		System.out.println("���� ���� ���ø����̼� �����...");
	}
}
