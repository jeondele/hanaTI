import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * 	순서를 통해 데이터를 관리하기 위한 규약(인터페이스)이다.
 *	Set과 달리 요소가 순차적으로 관리되며, 중복을 허용하는 특징을 가진다.
 *	ArrayList, Vector, LinkedList가 List 인터페이스를 구현한 대표적 클래스이다
 * 
 * @author 전상일
 *
 */

public class ListExample {

	public static void main(String[] args) {
		Vector list = null;
		list = new Vector(10, 5); //규격때문에 호환되는것. 
		//메소드 이름에 ~~element 붙어있으면 동기화처리 되어있는 것.
		list.addElement("황의조");
		list.addElement("손흥민");
		list.addElement("바나나");
		list.addElement(100); //Object obj = 100; autoBoxing!
		list.addElement(new Integer(100)); //안담음
		list.addElement("황의조"); //안담음
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());

		System.out.println(list.elementAt(0));
		System.out.println(list.removeElement("바나나"));
		
		//동기화되어있는 것을 위한 확장 for문
		Enumeration e = list.elements();
		while (e.hasMoreElements()) {
			Object object = (Object) e.nextElement();
			System.out.println(object);
		}
	}
	

}
