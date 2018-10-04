import java.util.Scanner;

class IfExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		if(score < 100) System.out.println(score);
		else System.out.println("xxxxx");

		if (score %2 == 0){
			System.out.println("礎熱");
		} else {
			System.out.println("�汝�");
		}

		if(score >= 90) {
			System.out.println("熱");
		} else if (score >= 80) {
			System.out.println("辦");
		} else if (score >= 70) {
			System.out.println("嘐");
		} else if (score >= 60) {
			System.out.println("曄");
		} else {
			System.out.println("陛");
		}
	
	}
}
