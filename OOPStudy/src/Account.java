/** 
*	일상생활의 객체를 추상화하기 위한 모델링클래스 정의
*	은행계좌 객체
*/
//document 만들때 반드시 public
public class Account {
	
	//static 초기화 블록(특수한 목적에 명령어(초기화 작업들) 실행)
	static {
		System.out.println("초기화 블록 실행입니다...1");
		System.out.println("초기화 블록 실행입니다...2");

	}
	//클래스(static) 변수 => private : 공유는 하는데 이 클래스에서만 공유하고 딴 클래스에서는 공유하고 싶지 않아 할때
	public static String bankName = "하나은행"; //위치는 바뀌어도 상관이 없다.
	//private static String bankName = "하나은행";

	//인스턴스 변수 선언;
	
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	
	//생성자 - 다형성과 관계된다. 초기화 시키고 싶은 것만 초기화 할 수 있다. 
	Account(){
		this(null,null);
	}

	//생성자 - 데이터 타입이나 개수가 달라야한다. 아래와 같이 같으면 오버로딩이 아님
	//Account(String accountNum){
	//	this.accountNum = accountNum;
	//}

	//Account(String accountOwner){
	//	this.accountOwner = accountOwner;
	//}
	/*																				*/

	Account(String accountNum, String accountOwner){
		//this.accountNum = accountNum;
		//this.accountOwner = accountOwner;
		this(accountNum, accountOwner, 0, 0);
	}

	Account(int passwd, long restMoney){
		//this.passwd = passwd;
		//this.restMoney = restMoney;
		this(null, null, passwd, restMoney);
	}

	Account(String accountNum, String accountOwner, int passwd, long restMoney){
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}
	
	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountOwner() {
		return accountOwner;
	}

	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	public int getPasswd() {
		return passwd;
	}

	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}

	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}

	public long deposit(long money) throws AccountException {
		
		if(money <=0) {
			throw new AccountException("저축하는 금액은 음수일 수 없습니다.", -1);
		}
		
		restMoney = restMoney + money;
		return restMoney;
	}
	
	public long withdraw(long money) throws AccountException {
		
		if(money <= 0) {
			throw new AccountException("출금하고자 하는 금액은 음수일 수 없습니다.", -1);
		} 
		
		if(money > restMoney) {
			throw new AccountException("잔액이 부족합니다.", -2);
		}
		
		restMoney -= money;
		return restMoney;
	}
	
	public long getRestMoney() {
		return restMoney;
	}
	
	public boolean checkPasswd(int passwd) {
		if(this.passwd == passwd) {
		return true;
		} else return false;
	}
	
	//클래스(static) 메소드
	public static int sum (int a, int b) {
		return a+b;
	}
	
	public static String selectAccount (int size, Account[] accountArray, String num) {
		for (int i = 0; i < size; i++) {
			if (accountArray[i].getAccountNum().equals(num)) { // == 기본타입 연산자 비교시 사용 다른때는 .equals
				return accountArray[i].toString();
			} 
		}
		return "검색된 계좌가 없습니다";
	}
	
	public void print() {
		System.out.println(getAccountNum() + "\t" + getAccountOwner() + "\t" + getRestMoney());
	}
	
	public boolean equals(Account account) {
		return this.toString().equals(account.toString());
	}
	
	//쌤코드
	public boolean equals(Object obj) {
		boolean eq = false;
		if(obj instanceof Account) {
			eq = toString().equals(obj.toString());
		}
		return eq;
	}
	

	@Override
	public String toString() {
		return getAccountNum() + "------" + getAccountOwner() + "------" + getRestMoney();
	}
}
