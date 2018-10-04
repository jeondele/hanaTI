package myselfstudy;

public class Test {
	static int k;
	String xx;
	int[] yy;
	public static void main(String[] args) {
		String xxxx = args[0];
		String yxxx = args[1];
		System.out.println(xxxx + "      " + yxxx );
//		int a = 10;
//		switch(a) {
//			default : System.out.println(a+"디폴트");
//			case 10 : System.out.println(a+"케이스10"); 
//			case 2 : System.out.println(a+"케이스2");
//			case 3 : System.out.println(a+"케이스3");
//			case 4 : System.out.println(a+"케이스4");
//		}
		Test test = new Test();
		String[] yk = new String[5];
		for (String a : yk) {
			System.out.println(a);
		}
		System.out.println(k);
		String xxx = null;
		System.out.println(xxx);
		int[] p = new int[5];
		for (int x : p) {
			System.out.println(x);
		}
	}

}
