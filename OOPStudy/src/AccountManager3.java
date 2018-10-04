import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

/**
 * 배열을 이용한 은행계좌 관리
 * 
 * @author 전상일
 *
 */
public class AccountManager3 {

	private Hashtable<String, Account> accounts;

	public AccountManager3() {
		accounts = new Hashtable<String, Account>();
	}
	
	
	public Hashtable<String, Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Hashtable<String, Account> accounts) {
		this.accounts = accounts;
	}
	
	/**
	 * @param account 계좌목록에 추가할 계좌
	 * @throws AccountException 
	 */
	public void add(Account account) throws AccountException {
		if (accounts.containsKey(account.getAccountNum())) {
			throw new AccountException("등록된 계좌입니다.", -1);
		}
		accounts.put(account.getAccountNum(), account);
	}

	/**
	 * @return 계좌목록에 있는 실제값들을 반환
	 */
	//유연하게 처리하기 위해서 List, 실제 리턴은 arraylist
	public List<Account> list() {
		List<Account> l = new ArrayList<Account>();
		Enumeration<String> keys = accounts.keys();
		while(keys.hasMoreElements()) {
			l.add(accounts.get(keys.nextElement()));
		}
		
		Collections.sort(l, new NumberCompare());
		return l;
	}

	/**
	 * @param accountNum 계좌번호로 Account 조회
	 * @return 계좌번호에 맞는 Account 반환
	 */
	public Account get(String accountNum) {
		if(accounts.containsKey(accountNum)) {
			return accounts.get(accountNum);
		}
		return null;
	}

	/**
	 * @param accountOwner 예금주가 가지고 있는 계좌 검색
	 * @return 				1예금주가 가지고있는 계좌 목록들을 반환
	 * @throws AccountException 
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
		
		if (l.size() == 0) throw new AccountException("해당 예금주가 없습니다.", -2);
		
		return l;
	}

	/**
	 * @param accountNum 지우고자 하는 계좌의 계좌번호
	 * @return 계좌번호가 지워졌으면 true, 지울 계좌가 없으면 false
	 * @throws AccountException 
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
		throw new AccountException("삭제할 예금주가 없습니다", -3);
	}

}
