
public class PolymophismExample {
	public static void main(String[] args) {
		// 클래스 형변환(up casting)
		Shape shape = null;		
		shape = new Circle(10, 10, 20);
		System.out.println(shape.toString());
		
		shape = new Rectangle(10, 10, 50, 20);
		System.out.println(shape.toString());
		
		//System.out.println(shape.getWidth()); //컴파일 에러 . 가려져서 못찾는다. 자기 한테 없기 때문에 자식꺼는 확인 안함
		
		System.out.println(shape.getArea()); // 오버라이딩 되어서 나온다.

		Rectangle rectangle = (Rectangle) shape;
		System.out.println(rectangle.getWidth()); //추가된 속성이나 메소드를 접근하기 위해 down casting 필요
	
		System.out.println(shape instanceof Object);
		System.out.println(shape instanceof Shape);
		System.out.println(shape instanceof Rectangle);
		System.out.println(shape instanceof Circle);
		//System.out.println(shape instanceof String);
	}
}
