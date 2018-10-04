
public class Calculator {
	
	//메소드 오버로딩(중복정의) / static은 오버로딩과 무관.
	public static int sum(int x , int y) {
		return x+y;
	}
	
	public static double sum(double x , double y) {
		return x+y;
	}
	
	
	public static void main(String[] args) {
		System.out.println(Calculator.sum(10, 20));
		System.out.println(sum(3, 5));
		System.out.println(sum(3.3, 4.5));
		
		
		int[] p = new int[5];
		int[] a;
		int[] b = new int[] {0, 1, 2, 3, 4, 5};
		for (int x : p) {
			System.out.println(x);
		}
	}
}
