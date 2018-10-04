
public class VarargExample {

	public static int sum (int[] args) {
		
		int result = 0 ;
		
		for (int i : args) {
			result += i;
		}
		
		return result;
	}
 	
	
	public static int summ(int... args) {

		int result = 0;

		for (int i : args) {
			result += i;
		}

		return result;
	}
	
	public static int sum (int args) {
		return 0;
	}
	public static void main(String[] args) {
		System.out.println(summ(new int[] {1, 2, 3, 4}));
		
		System.out.println(summ(10));
		System.out.println(summ(10, 20));
		System.out.println(summ(10, 20, 30));
	}

}
