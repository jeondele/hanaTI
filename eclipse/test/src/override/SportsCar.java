package override;


class Car {
	public int gearRatio = 8;
	public String accelerate() {
		return "Accelerate : Car";
	}
}
public class SportsCar extends Car {
	public int gearRatio = 9;
	
	public String accelerate() {
		return "Accelerate : SportsCar";
	}
	
	public void test() {
		
	}
	
	public static void main(String[] args) {
		Car car = new SportsCar();
		System.out.println(car.gearRatio + " " + car.accelerate());
	}
	
	
}
