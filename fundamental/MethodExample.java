class MethodExample {

	void printMessage(String name, String message){
      
	  System.out.println("[" + name + "] : " + message);
	
	}

	int sum(int x, int y){
      return x + y;
	}
	
	// JVM에 의해 최초 실행되는 엔트리포인트 main() 함수
	public static void main(String[] args){
      // 함수 사용(호출)
	  	MethodExample mp = new MethodExample ();
		mp.printMessage(" 방그리 ", "행복하세요"); // 반환값 없음 	
      
		int result = mp.sum(30, 50); // 반환값 있음
		System.out.println(result);
	} 

}
