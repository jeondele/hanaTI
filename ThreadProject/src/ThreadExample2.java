
public class ThreadExample2 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		for (int i = 0; i < 100; i++) {
			System.out.println("메인스레드에서 i값 출력 : " + i);
			
			if( i == 50) {
				new Thread() {
					@Override
					public void run() {
						for(int i = 0 ; i < 50; i++) {
							System.out.println("사용자 쓰레드 i: " + i);
						}
					}
				}.start();
				
				//굳이 이렇게 할수는 있지만 할 필요는 ㄴㄴ
				new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println("헐...");
					}
				});
			}
		}
		
		System.out.println("프로그램 종료");
	}

}
