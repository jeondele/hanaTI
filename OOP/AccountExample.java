/**	
*	프로그램 실행을 위한 애플리케이션 클래스 정의
*/

class AccountExample {
	public static void main(String[] args) {
		System.out.println("은행 계좌 애플리케이션 시작됨...");
		
		//클래스로부터 객체(인스턴스) 생성
		Account ac = new Account();

		//인스턴스의 속성과 기능 사용
		//ac.accountNum = "110392051733";
		//ac.accountOwner = "전상일";
		//ac.passwd = 123456789;
		//ac.restMoney = 303030;
		ac.setPasswd(123456789);
		boolean result = ac.checkPasswd(123456789);
		if (result){
			long money = ac.deposit(100000);
			System.out.println("입금 후 잔액 : " + ac.getRestMoney());
			money = ac.withdraw(10000);
			System.out.println("인출 후 잔액 : " + ac.getRestMoney());
		} else {
			System.out.println("비밀번호 확인하세요.");
		}

		Account ac2 = new Account();

		//인스턴스 변수의 경우 jvm에 의해 자동 초기화 됨.
		System.out.println(ac2.getAccountNum());
		System.out.println(ac2.getAccountOwner());
		System.out.println(ac2.getRestMoney());
		System.out.println(ac2.getPasswd());
		Account ac4 = new Account("ddddddddd", "예슬이");
		Account ac3 = new Account("123456789", "상일이", 303, 12345000);
		System.out.println(ac3.deposit(100000));
		System.out.println(Account.bankName);
		Account.bankName = "Hana bank";
		System.out.println(Account.bankName);
		System.out.println(Account.sum(30,20));
		System.out.println("은행 계좌 애플리케이션 종료됨...");
	}
}
