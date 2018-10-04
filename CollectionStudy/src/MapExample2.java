import java.util.Enumeration;
import java.util.Hashtable;

public class MapExample2 {
	//동적 객체 : 객체 쓰고 싶을 때만 쓰게 하고 싶을 때 ex) fix되어있는 것 x
	//동적 객체를 만들고자 할 때 hashmap을 쓴다.
	public static void main(String[] args) {
		Hashtable <String, Account> set = new Hashtable<String, Account>();
		
		Account account1 = new Account("1111", "김기정", 1111, 10000);
		Account account2 = new Account("2222", "김기정", 1111, 10000);
		set.put(account1.getAccountNum(), account1);
		set.put(account2.getAccountNum(), account1);
		
		System.out.println(set.get("1111"));
		
		Enumeration<String> e = set.keys(); // hashmap에서는 keyset()이었지만 hashtable 로 가져오는 것이 낫다
		while (e.hasMoreElements()) {
			String key = e.nextElement();
			System.out.println(key);
		}
		
		Enumeration<Account> e2 = set.elements(); // 값을 가져올 때는 elements로 하는것이 좋다
	
	}

}
