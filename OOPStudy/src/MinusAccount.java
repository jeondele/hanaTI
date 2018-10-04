/**
 * Account를 확장한 마이너스 계좌
 * @author 전상일
 *
 */
public class MinusAccount extends Account {
	private long borrowMoney;
	
	public MinusAccount() {
		this(null, null, 0, 0, 0);
	}
	
	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}
	
	
	public long getBorrowMoney() {
		return borrowMoney;
	}

	@Override
	public long getRestMoney() {
		return super.getRestMoney() - getBorrowMoney();
	}
	
	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

	@Override
	public String toString() {
		return "MinusAccount [borrowMoney=" + borrowMoney + ", getBorrowMoney()=" + getBorrowMoney()
				+ ", getRestMoney()=" + getRestMoney() + "]";
	}
	
	
//	public static void main(String[] args) {
//		MinusAccount ma = new MinusAccount();
//		System.out.println(ma.getBorrowMoney());
//		
//		MinusAccount ma2 = new MinusAccount("99999-1111-2222", "김대대출", 1111, 10, 1000000);
//		//ma2.deposit(100000);
//		System.out.println(ma2.getRestMoney());
//	}
}
