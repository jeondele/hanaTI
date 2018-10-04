import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * Field를 이용하여 동적 필드값 읽기
 * 
 * @author 김기정
 *
 */

class Point {
	public int x, y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class ClassExample6 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Point point = new Point(50, 50);
//		point.x;
		
		Class cls = Point.class;
		Field field = cls.getField("x");
		Object x = field.get(point);
		System.out.println(x.toString());
	}
	

}
