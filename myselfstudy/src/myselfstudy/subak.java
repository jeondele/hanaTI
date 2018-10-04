package myselfstudy;

import java.util.Scanner;

class subak {
	  public static String solution(int n) {
	      String answer = "";
	      int cnt = 1;
	      while (cnt <= n) {
	    	  if(cnt%2!=0) answer += "수";
	    	  else answer +="박";
	    	  cnt++;
	      }
	      return answer;
	  }
	  
	  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}
}


//class Solution {
//	  public String solution(int n) {
//		      String answer = "";
//		      for (int i = 0 ; i < n/2; i++) {
//		    	  answer += "수박";
//		    	  if((i == (n/2 -1)) && (n%2 != 0)) {
//		    		  answer += "수";
//		    	  }
//		      }
//		      return answer;
//		  }
//	}
