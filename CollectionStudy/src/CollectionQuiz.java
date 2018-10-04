import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionQuiz {

	/*
	 * jvm은 해쉬코드로 접근한다. 
	 * 모든 객체는 식별자를 저장해 놓고, 그 객체에 접근하기 위해 해쉬코드를 저장해 놓는다.
	 * 최상위 클래스인 object의 해쉬코드는 무조건 다 값이 다르다.
	 * 콜랙션의 부류를 같게 만들어 주기 위해서 hashcode를 overriding 한다.
	 * <참고> object의 toString()은 클래스이름@hashcode값이다.
	 */
	public static void main(String[] args) {
		Set<Account> set = new HashSet<Account>();
		set.add(new Account("1111","김기정",1111,20000));
		set.add(new Account("2222","김기정",1111,20000));
		set.add(new Account("1111","김기정",1111,20000));
		System.out.println(set.size());
		Map<String, String> map = System.getenv();
		Set<String> keySet = map.keySet();
		System.out.println(keySet);
		for (String name : keySet) {
			String value = System.getenv(name);
			System.out.println(value);
		}
	}
}
