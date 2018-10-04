package hashcode;
class BaseClassWithField {
	private int x= 5;
	
	public int getX() {
		return x;
	}
}
class Vehicle {
	public void drive() {
		System.out.println("i am driving");
	}
}
public class Car extends BaseClassWithField {
	Car(int x) {
		//this.x = x;
	}
//	public void drive() {
//		System.out.println("brrrm brrm");
//	}
	public static void main(String[] args) {
		BaseClassWithField bf = new BaseClassWithField();
		System.out.println(bf.getX());
		System.out.println(bf);
	}

}
