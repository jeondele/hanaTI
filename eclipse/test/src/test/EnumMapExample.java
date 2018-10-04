package test;

public class EnumMapExample {
	public enum Key {
		ONE, TWO, THREE;
	}
	
	public static void main(String[] args) {
		
		for (int j = 0 ; j<5 ; j++ ) {
			for (int i = 0; i < 5; i++ ) {
				System.out.print(" ");
				if (i + j ==4) {
					for (int k = 0 ; k < 2*j+1; k++) {
						System.out.print("*");
					}
					break;
				}
			}
			System.out.println();
		}
		
		OUT:
		while(true) {
			while(true) {
				break OUT;
			}
		}
		
	}
}
