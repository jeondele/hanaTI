
public class ThreadExample {
	
	static class MyThread extends Thread {
		public MyThread(String name) {
			super(name);
		}
		@Override
		public void run() {
			System.out.println(getName() + "스레드 시작");
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
			}
			System.out.println(getName() + "스레드 끝");
		}
	}
	
	
	
	public static void main(String[] args) {
		//우선수위가 중요한 요소가 되지는 않는다. 약간의 변화정도 뿐
		System.out.println(Thread.currentThread().getPriority());
		
		System.out.println("프로그램 시작");
		MyThread t1 = new MyThread("방그리");
		MyThread t2 = new MyThread("소연이");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		System.out.println(t1.currentThread().getPriority());
		System.out.println(t2.currentThread().getPriority());
		
		t1.start();
		t2.start();
		System.out.println("프로그램 종료");
	}

}
