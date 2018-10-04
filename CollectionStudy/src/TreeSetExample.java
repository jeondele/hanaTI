import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		Set<String> set = new TreeSet<String>(); //아예 처음부터 정렬하면서 담는다.
		set.add("황희찬");
		set.add("hwang");
		set.add("이희찬");
		set.add("kim");
		set.add("김희찬");
		set.add("최희찬");
		
		for ( String string : set) {
			System.out.println(string);
		}
	}

}
