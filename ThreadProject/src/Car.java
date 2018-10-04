/**
 * cpu를 추상화 시킨 것이 thread
 * 
 * @author 전상일
 *
 */
public class Car extends Thread{
//	String name; 	//굳이 안줘도 된다
	
	public Car(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println(getName() + "       자동차 start!!!!!!! ");
		for (int i = 0; i <10; i++) {
			System.out.println(getName() +"       -------"+i);
			try {
				Thread.sleep((int)(Math.random()*500)); //throw 하면 안됨
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 인터럽트
			if(i == 9) {
				System.out.println(getName() +"         도착!!!");
			}
		}
	}
}
