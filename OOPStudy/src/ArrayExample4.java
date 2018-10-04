import java.util.Scanner;

public class ArrayExample4 {
	public static void main(String[] args) {
//		Account account = new Account("1111-2222-33333", "김기정", 1111, 11000);
		Account[] accounts = new Account[100];
		int index = 0;
		
		
		// 은행 계좌 개설
		accounts[index] = new Account("1111-2222-33333", "김기정", 1111, 11000);
		index++;
		
		accounts[index] = new Account("3432-2222-33333", "박지성", 1111, 11000);
		index++;
		
		accounts[index] = new Account("3421-2222-55555", "윤형주", 1111, 11000);
		index++;
		
		// 전체 계좌 목록 출력
		// 객체지향프로그래밍의 기본은 출력기능 또한 외부에서 하지 않고 클래스 내에서 선언해줘야한다.
//		for (Account account : accounts) {
//			if(account==null) break;
//			System.out.println(account);
//		}
		
		// 계좌번호로 계좌 조회
		String num = "";
		Scanner sc = new Scanner(System.in); //ctrl + shift + o;;
		System.out.println("검색 계좌번호 : ");
		num = sc.nextLine();
		
		System.out.println(Account.selectAccount(index, accounts,  num));

		
//		for (int i = 0 ; i < index; i++) {
//			accounts[i].print();
//		}
	}
}
