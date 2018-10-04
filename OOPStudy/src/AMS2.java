import java.util.List;

/**
 * AMS (Account Management System)
 * 은행계좌 관리 어플리케이션
 * 
 * @author 전상일
 *
 */
public class AMS2 {

	public static void main(String[] args) {
//		AccountManager manager = new AccountManager();
		AccountManager2 manager = new AccountManager2(100); //파라미터 값에  맞게 생성자를 생성해라
		
		Account account = new Account("1111-2222-3333", "김기정", 1111, 100000);
		manager.add(account);
		manager.add(new Account("3432-2222-33333", "박지성", 1111, 11000));
		manager.add(new Account("3435-2222-34333", "손흥민", 1111, 11000));
		manager.add(new Account("5555-2222-33333", "황희찬", 1111, 11000));
		manager.add(new Account("8888-2222-33333", "황의조", 1111, 11000));
		
		//업 캐스팅
		manager.add(new MinusAccount("9999-9999-9999", "조현우" , 1111, 110000, 1000000));
		manager.add(new MinusAccount("9999-9999-9999", "이승우" , 1111, 1000, 10000000));
		
		manager.add(new Account("9999-9999-9999", "이승우" , 1111, 10000000));
		
		List<Account> list = manager.list();
		
		for (Account myAccount : list) {
			System.out.println(myAccount.toString());
		}
		
		System.out.println();
		System.out.println();
		System.out.println();

		if(manager.remove("5555-2222-33333")) {
			List<Account> list2 = manager.list();
			
			for (Account myAccount : list2) {
				System.out.println(myAccount.toString());
			}
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		List<Account> a = manager.search("박지성");
		for (Account myAccount : a) {
			System.out.println(myAccount.toString());
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		manager.add(new Account("8888-2222-33333", "황의조", 1111, 11000));
		
		List<Account> list2 = manager.list();
		
		for (Account myAccount : list2) {
			System.out.println(myAccount.toString());
		}
	}

}
