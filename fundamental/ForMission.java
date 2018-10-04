class ForMission {
	public static void main(String[] args) {
		
		for (int j = 1 ; j<=5 ; j++ ) {
			for (int i = 0 ; i <j; i++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();


		for (int j = 1 ; j <= 5 ; j++ ) {
			for (int i = 0 ; i < 6-j; i++ ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();

		for (int i = 0 ; i < 5 ; i++ ) {
			for (int j = 4; j >= 0 ; j --){
				if (j <= i){
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		
		System.out.println();


		for (int i = 0 ; i < 5 ; i++ ) {
			for (int j = 0; j < 5 ; j ++){
				if (j >= i){
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

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
	}
}
