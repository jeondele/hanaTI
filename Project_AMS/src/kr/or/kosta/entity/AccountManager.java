package kr.or.kosta.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * 해쉬테이블을 이용한 은행계좌 관리
 * 
 * 1. CenterPanel 클래스와 Account 클래스가 연관이 되지 않도록 AccountManager에서 모두 처리하였습니다.
 * 2. 목록을 호출할 때는 이름없는 내부클래스로 계좌순, 계좌번호 순으로 지정하였습니다.
 * 
 * @author 전상일
 *
 */
public class AccountManager {

	private Hashtable<String, Account> accounts;

	/**
	 *  AccountManager 인스턴스 생성 당시에 기본으로 들어갈 계좌들을 default값으로 넣어줍니다.
	 *  계좌 목록은 해쉬테이블을 사용합니다.
	 */
	public AccountManager() {
		accounts = new Hashtable<String, Account>();
		defaultAdd();
	}
	
	/**
	 * @return	AccountManager 인스턴스가 가진 해쉬테이블 타입의 계좌목록을 반환합니다.
	 */
	public Hashtable<String, Account> getAccounts() {
		return accounts;
	}

	/**
	 * @param accounts	AccountManager 인스턴스 객체의 계좌목록을 파라미터값으로 세팅하는 메소드입니다.
	 */
	public void setAccounts(Hashtable<String, Account> accounts) {
		this.accounts = accounts;
	}
	
	/**
	 * AccountManager 인스턴스 객체 생성 당시 기본적으로 넣어주는 계좌입니다.
	 */
	private void defaultAdd() {
		accounts.put("1111-2222", (new Account("1111-2222", "윤예슬", 486, 100000)));
		accounts.put("1111-3333", (new Account("1111-3333", "전상일", 1229, 200000)));
		accounts.put("1111-4444", (new Account("1111-4444", "전상일", 1229, 200000)));
		accounts.put("2222-5555", (new MinusAccount("2222-5555", "전수연", 1020, 5000000, 130000000)));
		accounts.put("2222-6666", (new MinusAccount("2222-6666", "김민수", 3333, 50000, 39300000)));
	}
	
	/**
	 * CenterPanel과 Account와의 연관을 피하고자 AccountManager에서 입출금계좌를 생성하는 메소드입니다.
	 * 
	 * @param accountNum		계좌목록에 추가할 계좌번호입니다.
	 * @param accountOwner		계좌목록에 추가할 예금주입니다.
	 * @param passwd			계좌목록에 추가할 비밀번호입니다.
	 * @param restMoney			계좌목록에 추가할 현재금액입니다.
	 * @throws AccountException	동일 계좌가 있을 시 예외가 발생합니다.
	 */
	public void addAccount(String accountNum, String accountOwner, int passwd, long restMoney) throws AccountException {
		add(new Account(accountNum, accountOwner, passwd, restMoney));
	}
	
	/**
	 * CenterPanel과 Account와의 연관을 피하고자 AccountManager에서 마이너스계좌를 생성하는 메소드입니다.
	 * 
	 * @param accountNum		계좌목록에 추가할 계좌번호입니다.
	 * @param accountOwner		계좌목록에 추가할 예금주입니다.
	 * @param passwd			계좌목록에 추가할 비밀번호입니다.
	 * @param restMoney			계좌목록에 추가할 현재금액입니다.
	 * @param borrowMoney		계좌목록에 추가할 대출금액입니다.
	 * @throws AccountException 동일 계좌가 있을 시 예외가 발생합니다.
	 */
	public void addAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) throws AccountException {
		add(new MinusAccount(accountNum, accountOwner, passwd, restMoney, borrowMoney));
	}
	/**
	 * 해당 인스턴스에 생성된 계좌목록에 계좌를 추가하는 메소드입니다.
	 * 
	 * @param 	account 			계좌목록에 추가할 계좌를 파라미터로 받습니다.
	 * @throws 	AccountException 	등록할 계좌의 계좌번호와 동일한 계좌번호가 해당 인스턴스의 계좌목록에 있는 번호라면 예외가 발생합니다.
	 */
	public void add(Account account) throws AccountException {
		if (accounts.containsKey(account.getAccountNum())) {
			throw new AccountException("등록된 계좌입니다.", -1);
		}
		accounts.put(account.getAccountNum(), account);
	}

	/**
	 * 해당 AccountManager 인스턴스에 등록된 계좌목록을 계좌 종류 순(입출금 계좌, 마이너스계좌), 계좌번호 순으로 정렬하여 List타입으로 반환합니다.
	 * 
	 * @return 계좌목록에 있는 실제값들을 반환합니다.
	 */
	public List<Account> list() {
		List<Account> l = new ArrayList<Account>();
		Enumeration<String> keys = accounts.keys();
		while(keys.hasMoreElements()) {
			l.add(accounts.get(keys.nextElement()));
		}
		Collections.sort(l, new Comparator<Account>() {
			@Override
			public int compare(Account a1, Account a2) {
				if (a1.getAccType().equals(a2.getAccType())) {
					return a1.getAccountNum().compareTo(a2.getAccountNum());
				} else {
					return a2.getAccType().compareTo(a1.getAccType());
				}
			}
		});
		return l;
	}
	
	/**
	 * 해당 AccountManager 인스턴스에 등록된 계좌 유형에 따라 (입출금 계좌, 마이너스 계좌) 리스트를 반환하기 위해 list() 메소드를 오버로딩 하였습니다.
	 * 
	 * @return 계좌목록에 있는 실제값들을 반환합니다.
	 */
	public List<Account> list(String type) {
		List<Account> l = new ArrayList<Account>();
		Collection<Account> values = accounts.values();
		for (Account value : values) {
			if(value.getAccType().equals(type)) {
				l.add(value);
			}
		}
		Collections.sort(l, new Comparator<Account>() {
			@Override
			public int compare(Account a1, Account a2) {
				if (a1.getAccType().equals(a2.getAccType())) {
					return a1.getAccountNum().compareTo(a2.getAccountNum());
				} else {
					return a2.getAccType().compareTo(a1.getAccType());
				}
			}
		});
		return l;
	}
	
	/**
	 * 계좌번호를 파라미터로 받아서 일치하는 계좌번호의 계좌를 반환하는 메소드입니다.
	 * 
	 * @param	accountNum 			조회할 계좌번호를 파라미터로 받습니다.
	 * @return 						계좌번호에 맞는 계좌를 반환합니다.
	 * @throws 	AccountException 	해당 인스턴스의 계좌목록에 해당 계좌번호가 없으면 예외가 발생합니다.
	 */
	public Account get(String accountNum) throws AccountException {
		if(accounts.containsKey(accountNum)) {
			return accounts.get(accountNum);
		}
		throw new AccountException("해당 계좌번호가 없습니다.", -2);
	}

	/**
	 * 예금주 명을 받아서 해당 객체의 계좌목록 중에 예금주 명과 일치하는 계좌 목록을 반환하는 메소드입니다.
	 * 
	 * @param accountOwner 			계좌의 예금주를 검색하고 싶을 때 파라미터로 받는 예금주 명입니다.
	 * @return 						예금주가 가지고있는 계좌 목록들을 반환
	 * @throws AccountException		해당 AccountManager 인스턴스의 계좌목록에 해당 예금주가 없을 시 예외가 발생합니다. 
	 */
	public List<Account> search(String accountOwner) throws AccountException {
		List<Account> l = new ArrayList<Account>();
		Enumeration<String> keys = accounts.keys();
		String key = null;
		Account nextAccount = null;
		while(keys.hasMoreElements()) {
			key = keys.nextElement();
			nextAccount = accounts.get(key);
			if(nextAccount.getAccountOwner().equals(accountOwner)) {
				l.add(nextAccount);
			}
		}
		
		if (l.size() == 0) throw new AccountException("해당 예금주가 없습니다.", -3);
		
		Collections.sort(l, new Comparator<Account>() {
			@Override
			public int compare(Account a1, Account a2) {
				if (a1.getAccType().equals(a2.getAccType())) {
					return a1.getAccountNum().compareTo(a2.getAccountNum());
				} else {
					return a2.getAccType().compareTo(a1.getAccType());
				}
			}
		});
		
		return l;
	}

	/**
	 * 파라미터로 받은 계좌번호와 일치하는 계좌를 제거하고, 제거가 되었으면 true, 되지 않았다면 false를 반환하는 메소드입니다.
	 * 
	 * @param 	accountNum 			지우고자 하는 계좌의 계좌번호
	 * @return 						계좌번호가 지워졌으면 true, 지울 계좌가 없으면 false를 반환합니다.
	 * @throws 	AccountException	계좌번호와 일치하는 계좌가 없다면 예외가 발생합니다. 	
	 */	
	public boolean remove(String accountNum) throws AccountException {
		Enumeration<String> e = accounts.keys();
		String key = null;
		while (e.hasMoreElements()) {
			key = e.nextElement();
			if(key.equals(accountNum)) {
				return accounts.remove(key, accounts.get(key));
			}
		}
		throw new AccountException("삭제할 계좌번호가 없습니다", -4);
	}
	
	/**
	 * 비교하고자하는 계좌종류와 해당 계좌번호를 가지는 계좌의 계좌종류가 일치하는지 비교하는 메소드 입니다.
	 * 
	 * @param type					비교하고자하는 계좌종류를 의미합니다.
	 * @param key					비교하고자하는 계좌번호를 의미합니다. 
	 * @return						비교하고자하는 계좌종류와 해당 계좌번호의 계좌유형이 일치하면 true, 아니면 false를 반환합니다.
	 * @throws AccountException 	삭제할 계좌가 없을 시 예외가 발생합니다.
	 */
	public boolean isExisting(String type, String key) throws AccountException {
		if(getAccounts().get(key) ==null) {
			throw new AccountException("삭제할 계좌가 없습니다.", -4);
		}
		return type.equals(getAccounts().get(key).getAccType());
	}
}
