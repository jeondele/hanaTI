import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CollectionsExample {

	public static void main(String[] args) {
		List<Account> list = new ArrayList<Account>();
		list.add(new Account("3333", "홍기정", 1111, 200000));
		list.add(new Account("1111", "박기정", 1111, 100000));
		list.add(new Account("2222", "김기정", 1111, 500000));
		
		Collections.sort(list, new MoneyCompare());
		for (Account account : list) {
			System.out.println(account);
		}
	}

}
