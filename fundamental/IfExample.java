import java.util.Scanner;

class IfExample {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		if(score < 100) System.out.println(score);
		else System.out.println("xxxxx");

		if (score %2 == 0){
			System.out.println("¦��");
		} else {
			System.out.println("Ȧ��");
		}

		if(score >= 90) {
			System.out.println("��");
		} else if (score >= 80) {
			System.out.println("��");
		} else if (score >= 70) {
			System.out.println("��");
		} else if (score >= 60) {
			System.out.println("��");
		} else {
			System.out.println("��");
		}
	
	}
}
