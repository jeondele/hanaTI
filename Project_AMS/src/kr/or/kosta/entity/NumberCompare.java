package kr.or.kosta.entity;
import java.util.Comparator;

public class NumberCompare implements Comparator<Account> {
	// o1이 o2보다 크면 1
	// 같으면 0, 작으면  -1
	@Override
	public int compare(Account o1, Account o2) {
		return o1.getAccountNum().compareTo(o2.getAccountNum());
	}

}
