
public class Circle extends Shape {
	private double radian;

	public Circle() {
		this(0.0, 0.0, 0.0);
		// TODO Auto-generated constructor stub
	}

	public Circle(double x, double y, double radian) {
		//protected는 직접적으로 가면 된다. super() xxxx
		this.x = x;
		this.y = y;
		
		this.radian = radian;
	}

	public double getRadian() {
		return radian;
	}

	public void setRadian(double radian) {
		this.radian = radian;
	}
	
	@Override
	public void draw() {
		System.out.println(x + ", " + y + "," + getRadian() + "의 도형입니다...");
	}
	
	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return 2*Math.PI*radian;
	}
	
	@Override
	public double getArea() {
		return Math.PI* Math.pow(radian, 2);
	}

	@Override
	public String toString() {
		return "Circle [radian=" + radian + ", x=" + x + ", y=" + y + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
