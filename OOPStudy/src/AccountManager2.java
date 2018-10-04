import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * 배열을 이용한 은행계좌 관리
 * 
 * @author 전상일
 *
 */
public class AccountManager2 {

	private Vector<Account> accounts;

	public AccountManager2() {
		this(0);
	}

	public AccountManager2(int size) {
		accounts = new Vector<Account>(size, 5);
	}
	
	
	public Vector<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Vector<Account> accounts) {
		this.accounts = accounts;
	}

	/**
	 * @param account 계좌목록에 추가할 계좌
	 */
	public void add(Account account) {
		accounts.addElement(account);
	}

	/**
	 * @return 계좌목록에 있는 실제값들을 반환
	 */
	//유연하게 처리하기 위해서 List, 실제 리턴은 arraylist
	public List<Account> list() {
		List<Account> l = new ArrayList<Account>();
		Enumeration<Account> e = accounts.elements();
		Account account = null;
		while (e.hasMoreElements()) {
			account = e.nextElement();
			l.add(account);
		}
	
		return l;
	}

	/**
	 * @param accountNum 계좌번호로 Account 조회
	 * @return 계좌번호에 맞는 Account 반환
	 */
	public Account get(String accountNum) {
		Enumeration<Account> e = accounts.elements();
		Account account = null;
		while (e.hasMoreElements()) {
			account = e.nextElement();
			if(account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		
		return null;
	}

	/**
	 * @param accountOwner 예금주가 가지고 있는 계좌 검색
	 * @return 				1예금주가 가지고있는 계좌 목록들을 반환
	 */
	public List<Account> search(String accountOwner) {
		List<Account> l = new ArrayList<Account>();
		Enumeration<Account> e = accounts.elements();
		Account account = null;
		while (e.hasMoreElements()) {
			account = e.nextElement();
			if(account.getAccountOwner().equals(accountOwner)) {
				l.add(account);
			}
		}
		
		return l;
		
	}

	/**
	 * @param accountNum 지우고자 하는 계좌의 계좌번호
	 * @return 계좌번호가 지워졌으면 true, 지울 계좌가 없으면 false
	 */
	public boolean remove(String accountNum) {
		Enumeration<Account> e = accounts.elements();
		Account account = null;
		while (e.hasMoreElements()) {
			account = e.nextElement();
			if(account.getAccountNum().equals(accountNum)) {
				return accounts.removeElement(account);
			}
		}
		return false;
	}

}
