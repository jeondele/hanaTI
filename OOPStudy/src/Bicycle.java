
public class Bicycle /* extends Object*/ {
	int id;
	String brand;
	
	Bicycle () {
		//super();
		this(0, null);
	}
	
	Bicycle (int id, String brand) {
		//super();
		this.id = id;
		this.brand = brand;
	}
	
	public void running() {
		System.out.println("달려");
		System.out.println("달려");
	}
	
	@Override
	public String toString() {
		
		return "Bicycle [id=" + id + ", brand=" + brand + "]";
	}
	
}
