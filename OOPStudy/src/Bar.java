public class Bar {
	
	@Deprecated
	public void some() {
		System.out.println("썸..");
	}
	
	@Override
	public String toString() {
		System.out.println("어노테이션 테스트");
		return null;  
	}
	
	public static void main(String[] args) {
		Bar bar = new Bar();
		bar.some();
	}
}
