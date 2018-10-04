package myselfstudy;

import java.util.Scanner;

public class Colatz {
	
	static int start = 1;
	
	public static int countRecursive(int num) {
		long n = (long)num;
		for (int i = 0 ; i< 500; i++) {
			if(n ==1) return i;
			n = (n%2 ==0) ? n/2 : 3 * n + 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(countRecursive(n));
	}

}
