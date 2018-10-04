
public class Rectangle extends Shape{
	private double width, height;
	
	
	public Rectangle() {
		this(0.0, 0.0, 0.0, 0.0);
	}

	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	
	@Override
	public void draw() {
		System.out.println(getWidth() + ", " + getHeight());
	}
	
	@Override
	public double getLength() {
		return x + y;
	}
	
	@Override
	public double getArea() {
		return height * width;
	}

	@Override
	public String toString() {
		return super.toString() + "Rectangle [width=" + width + ", height=" + height + ", getWidth()=" + getWidth() + ", getHeight()="
				+ getHeight() + ", getLength()=" + getLength() + ", getArea()=" + getArea() + "]";
	};
	
	
}
