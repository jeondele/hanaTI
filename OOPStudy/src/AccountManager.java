import java.util.ArrayList;

/**
 * 배열을 이용한 은행계좌 관리
 * 
 * @author 전상일
 *
 */
public class AccountManager {

	private Account[] accounts;
	private int count;

	public AccountManager() {
		this(0);
	}

	public AccountManager(int size) {
		accounts = new Account[size];
	}
	
	
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @param account 계좌목록에 추가할 계좌
	 */
	public void add(Account account) {
		accounts[count] = account;
		count++;
	}

	/**
	 * @return 계좌목록에 있는 실제값들을 반환
	 */
	public Account[] list() {
		Account[] realAccounts = new Account[count];
		for (int i = 0; i < count; i++) {
//			if (realAccounts[i] instanceof MinusAccount) {
//				System.out.println("마이너스 계좌 \t" + realAccounts[i].toString());
//			} else  {} 					//바꿀시 사용 가능
			realAccounts[i] = accounts[i];
		}
		return realAccounts;
	}

	/**
	 * @param accountNum 계좌번호로 Account 조회
	 * @return 계좌번호에 맞는 Account 반환
	 */
	public Account get(String accountNum) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				return accounts[i];
			}
		}
		return null;
	}

	/**
	 * @param accountOwner 예금주가 가지고 있는 계좌 검색
	 * @return 				1예금주가 가지고있는 계좌 목록들을 반환
	 */
	public Account[] search(String accountOwner) {
		Account[] myAccounts = new Account[count];
		int idx = 0;
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountOwner().equals(accountOwner)) {
				myAccounts[idx] = accounts[i];
				idx++;
			}
		}
		Account[] returnSearch = new Account[idx];
		for (int i = 0; i < idx; i++) {
			returnSearch[i] = myAccounts[i];
		}
		
		return returnSearch;
		
	}

	/**
	 * @param accountNum 지우고자 하는 계좌의 계좌번호
	 * @return 계좌번호가 지워졌으면 true, 지울 계좌가 없으면 false
	 */
	public boolean remove(String accountNum) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNum)) {
				for (int j = i + 1; j < count; j++) {
					accounts[j - 1] = accounts[j];
				}
				count--;
				return true;
			}
			
		}
		
		return false;
	}

}
