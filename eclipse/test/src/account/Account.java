package account;

public class Account {
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

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

	public long deposit(long money) {
		this.restMoney = getRestMoney() + money;
		return restMoney;
	}
	
	public long withdraw(long money) {
		this.restMoney = getRestMoney() - money;
		return money;
	}
	
	public long getRestMoney() {
		return restMoney;
	}
	
	public boolean chechPasswd(int passwd) {
		if(this.passwd==passwd) {
			return true;
		} else {
			return false;
		}
	}
}
