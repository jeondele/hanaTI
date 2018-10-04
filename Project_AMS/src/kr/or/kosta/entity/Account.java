package kr.or.kosta.entity;

import java.lang.Long;
import java.util.Formatter;

/** 
 *	은행계좌 객체를 추상화하는 모델링클래스
 *	
 *	- StringBuilder와 Formatter를 이용하여 금액을 1000단위로 포맷팅하였습니다.
 *
 *	@author 전상일
 *	
 */
public class Account {
	
	public static final String bankName = "KOSTA 은행";
	
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;
	
	/**
	 * 	계좌번호와 예금주 명을 null로 초기화하여 인스턴스 객체를 생성할 수 있습니다.
	 */
	public Account() {
		this(null,null);
	}
	
	/**
	 * 	계좌번호와 예금주 명을 파라미터로 초기화하고 비밀번호와 현재 잔액을 0으로 초기화하여 인스턴스 객체를 생성할 수 있습니다.
	 */
	public Account(String accountNum, String accountOwner){
		//this.accountNum = accountNum;
		//this.accountOwner = accountOwner;
		this(accountNum, accountOwner, 0, 0);
	}

	/**
	 * 	비밀번호와 현재 잔액을 파라미터 값으로 초기화하고 계좌번호와 예금주 명을 null로 초기화하여 인스턴스 객체를 생성할 수 있습니다.
	 */
	public Account(int passwd, long restMoney){
		//this.passwd = passwd;
		//this.restMoney = restMoney;
		this(null, null, passwd, restMoney);
	}
	
	/**
	 * 	계좌번호와 예금주명, 비밀번호와 현재 잔액을 파라미터 값으로 초기화하여 인스턴스 객체를 생성할 수 있습니다.
	 */
	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
		this.passwd = passwd;
		this.restMoney = restMoney;
	}
	
	/**
	 * Account의 기본 타입은 입출금계좌라는 것을 반환하는 메소드입니다.
	 * 
	 * @return	해당 계좌의 유형이 입출금계좌라는 것을 알려줍니다.
	 */
	public String getAccType() {
		return "입출금계좌";
	}
	
	/**
	 * Account 해당 계좌의 계좌번호를 반환하는 메소드 입니다.
	 * 
	 * @return 해당 계좌의 계좌번호를 반환합니다.
	 */
	public String getAccountNum() {
		return accountNum;
	}

	/**
	 * 파라미터로 받은 계좌번호를 해당 인스턴스의 계좌번호로 초기화 해줍니다.
	 * 
	 * @param accountNum 해당 인스턴스에 설정할 계좌번호를 의미합니다.
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	/**
	 * @return 해당 계좌의 예금주를 반환합니다.
	 */
	public String getAccountOwner() {
		return accountOwner;
	}

	/**
	 * @param accountOwner 해당 계좌의 예금주를 설정합니다.
	 */
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}

	/**
	 * @return 해당 계좌의 비밀번호를 반환합니다.
	 */
	public int getPasswd() {
		return passwd;
	}

	/**
	 * @param passwd 해당 계좌의 비밀번호를 설정합니다.
	 */
	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}

	/**
	 * @param restMoney 해당 계좌의 현재 잔액을 설정합니다.
	 */
	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}

	/**
	 * 해당 계좌에서 돈을 입금시키는 메소드입니다.
	 * 
	 * @param money 				해당 계좌에 입금할 돈을 의미합니다.
	 * @return						해당 계좌에 입금한 후의 현재 잔액을 의미합니다.
	 * @throws AccountException		해당 계좌에 입금할 돈이 음수이면 예외가 발생합니다.
	 */
	public long deposit(long money) throws AccountException {
		if(money <=0) {
			throw new AccountException("저축하는 금액은 음수일 수 없습니다.", -1);
		}
		restMoney = restMoney + money;
		return restMoney;
	}
	
	/**
	 * 해당 계좌에서 돈을 인출하고 남은 잔액을 반환하는 메소드입니다.
	 * 
	 * @param money					해당 계좌에서 인출하고자하는 돈을 의미합니다.
	 * @return						해당 계좌에서 돈을 인출하고 남은 잔액을 반환합니다.
	 * @throws AccountException		해당 계좌에서 인출하고자 하는 돈이 음수 이거나 남은 잔액보다 많은 금액을 인출하려고 할 때 예외가 발생합니다.
	 */
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
	
	/**
	 * 해당 계좌의 현재 잔액을 가져오는 메소드입니다.
	 * 
	 * @return	남은 잔액을 반환합니다.
	 */
	public long getRestMoney() {
		return restMoney;
	}
	
	/**
	 * 해당 계좌의 비밀번호 일치 여부를 체크하는 메소드입니다.
	 * 
	 * @param passwd	비교하고자 하는 비밀번호를 파라미터로 받습니다.
	 * @return			비교하고자 하는 비밀번호와 값이 같으면 true를 아니면 false를 반환합니다.
	 */
	public boolean checkPasswd(int passwd) {
		if(this.passwd == passwd) return true;
		else return false;
	}
	
	/* 
	 * 	출력값이 일정한 간격으로 나오게 하기 위해서 해당 입력값이 길이를 기준으로 간격을 설정합니다.
	 * 	금액이 입력되면 1000 단위로 ,가 찍히도록 포멧팅하였습니다.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getAccType()+ "\t ");
		sb.append(new Formatter().format("%-9s", getAccountNum()) + "\t\t");
		sb.append(new Formatter().format("%-4s", getAccountOwner()));
		sb.append("\t\t" + new Formatter().format("  %,20d", getRestMoney()).toString() + "\t\t");
		return sb.toString();
	}
}
