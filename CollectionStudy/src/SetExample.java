import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 	Set은
 * 	데이터의 중복 저장 없이 데이터를 관리하기 위한 규약(인터페이스)이다.
 * 	순서와 관련 없이 데이터를 관리한다.
 *	HashSet이 Set 인터페이스를 구현한 대표적인 클래스이다.
 * 
 * @author 전상일
 *
 */

public class SetExample {

	public static void main(String[] args) {
		Set set = null;
		set = new HashSet(10); //자동으로 커진다
		set.add("황의조");
		set.add("손흥민");
		set.add("바나나");
		set.add(100); //Object obj = 100; autoBoxing!
		set.add(new Integer(100)); //안담음
		set.add(Calendar.getInstance());
		set.add("황의조"); //안담음
		
		System.out.println(set.size());
		System.out.println(set.isEmpty());
		
		Set boddari = new HashSet();
		boddari.add("aaaa");
		boddari.add("bbbb");
		boddari.add("cccc");
		
		set.addAll(boddari);
		boolean result = set.remove("바나나");
		System.out.println("삭제결과" +result);
		
		System.out.println(set.contains("황의조"));
		System.out.println(Calendar.getInstance());
		
		Object[] list = set.toArray();
		for (Object object : list) {
			if(object instanceof String) {
				System.out.println(((String) object).length());
			}
			System.out.println(object);
		}
		
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			System.out.println(iter);
		}
		
		//확장포문
		for(Object object : set) {
			System.out.println(object);
		}
	}

}
