/**
 * 
 * 
 * @author 전상일
 *
 */
public class OuterClass {
	
	enum Direction {
		A, B, C, D
	}
	
	class InnerClass {
		public void foo() {
			System.out.println("foo 호출됨...");
		}
	}
	
	
	/**
	 * static 내부 클래스
	 * 
	 * @author 전상일
	 *
	 */
	static class SInnerClass {
		public void bar() {
			System.out.println("bar 호출됨...");
		}
	}
	
	
}
