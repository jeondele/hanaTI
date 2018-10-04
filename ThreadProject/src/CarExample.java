
public class CarExample {
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("메인스레드에 의해 프로그램 시작됨.."); //프로세스의 메인스레드에 의해 메인메소드 실행
		
		Car car = new Car("방그리");
		Car car2 = new Car("sleep");
		Car car3 = new Car("홍길동");
		

		car.start(); //독립적으로 움직인다.
		car2.start(); //독립적으로 움직인다.
		car3.start(); //독립적으로 움직인다.
		car.join();
		car2.join();
		car3.join();
		System.out.println("메인스레드에 의해 프로그램 종료됨..");
		
		
	}
}
