package kr.or.kosta.entity;

import java.util.Formatter;

/**
 * Account를 확장한 마이너스 계좌
 * 
 * @author 전상일
 *
 */
public class MinusAccount extends Account {
	
	private long borrowMoney;
	
	/**
	 * 파라미터없이 마이너스 계좌 인스턴스를 생성하면 계좌번호와 예금주를 null로, 비밀번호, 남은 잔액, 대출 금액을 0으로 초기화하여 생성됩니다. 
	 */
	public MinusAccount() {
		this(null, null, 0, 0, 0);
	}
	
	/**
	 * @param accountNum 	해당 인스턴스 객체의 계좌번호입니다.
	 * @param accountOwner 	해당 인스턴스 객체의 예금주 이름입니다.
	 * @param passwd 		해당 인스턴스 객체의 비밀번호 입니다.
	 * @param restMoney		해당 인스턴스 객체의 현재 잔액입니다.
	 * @param borrowMoney	해당 인스턴스 객체의 대출 금액입니다.
	 */
	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}
	
	/* 
	 * MinusAccount 인스턴스의 유형이 마이너스계좌라는 것을 알려줍니다.
	 */
	@Override
	public String getAccType() {
		return "마이너스계좌";
	}
	
	/**
	 * @return 해당 마이너스 계좌의 대출금액을 반환합니다.
	 */
	public long getBorrowMoney() {
		return borrowMoney;
	}

	/**
	 * @param borrowMoney 해당 마이너스계좌의 대출금액을 지정합니다.
	 */
	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	
	/*
	 *  마이너스 계좌의 현재 금액은 잔액에서 대출금액을 뺀 금액이라는 것을 의미합니다.
	 */
	@Override
	public long getRestMoney() {
		return super.getRestMoney() - getBorrowMoney();
	}
	
	/* 
	 *  해당 인스턴스를 호출할 때 마이너스 계좌의 기본정보를 반환합니다.
	 */
	@Override
	public String toString() {
		Formatter formatter = new Formatter();
		return super.toString() + formatter.format("  %,20d", getBorrowMoney()).toString();
	}
}
