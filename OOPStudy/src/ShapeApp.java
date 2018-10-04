
public class ShapeApp {

	public static void main(String[] args) {
//		Shape shape = new Shape(12.5, 35.7);
		Shape shape = null;
		shape.draw();
		
		Circle circle = new Circle(15.0, 15.0, 30.0);
		circle.draw();
		System.out.println(circle.getLength());
		System.out.println(circle.getArea());
	}

}
