import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 	순서를 통해 데이터를 관리하기 위한 규약(인터페이스)이다.
 *	Set과 달리 요소가 순차적으로 관리되며, 중복을 허용하는 특징을 가진다.
 *	ArrayList, Vector, LinkedList가 List 인터페이스를 구현한 대표적 클래스이다
 * 
 * @author 전상일
 *
 */

public class ListExample2 {

	public static void main(String[] args) {
		List list = null;
		list = new ArrayList(); //규격때문에 호환되는것. 
		
		list.add("황의조");
		list.add("손흥민");
		list.add("바나나");
		list.add(100); //Object obj = 100; autoBoxing!
		list.add(new Integer(100)); //안담음
		list.add(Calendar.getInstance());
		list.add("황의조"); //안담음
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		
		Set boddari = new HashSet();
		boddari.add("aaaa");
		boddari.add("bbbb");
		boddari.add("cccc");
		
		list.addAll(boddari);
		boolean result = list.remove("바나나");
		System.out.println("삭제결과" +result);
		
		System.out.println(list.contains("황의조"));
		System.out.println(Calendar.getInstance());
		
		Object[] lists = list.toArray();
		for (Object object : lists) {
			if(object instanceof String) {
				System.out.println(((String) object).length());
			}
			System.out.println(object);
		}
//		
//		Iterator iter = list.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter);
//		}
//		
		//확장포문
		for(Object object : list) {
			System.out.println(object);
		}
		
		//List에 추가된 규약 메소드들
		list.add(0, "김기정");
		System.out.println(list.get(0));
		System.out.println(list.remove(0));
		System.out.println(list.set(0, "황희찬"));
		
		System.out.println(list.size());
		
		List l = list.subList(0, 3);
		
		for (Object obj : l) {
			System.out.println(obj);
		}
		
	}
	

}
