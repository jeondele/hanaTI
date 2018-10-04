class SwitchExample {
	public static void main(String[] args) {
		
		int x = 70;
		int y = 25;
		String opp = "/";
		switch(x){
			default : System.out.println("gogo");
			case 1 : System.out.println("xx");
			case 2 : System.out.println("xxxxxxx"); 
			case 7 : System.out.println("ooooo"); break;
			case 9 : System.out.println("oxxxxoooo");
			
		}

		switch(opp){
			
			case "+" : System.out.println(x+y); break;
			case "-" : System.out.println(x-y);  break;
			case "*" : System.out.println(x*y); break;
			case "/" : System.out.println((double)x/y); break;
			default : System.out.println("지원되지않는 연산자입니다");
		}
		System.out.println();
	}
}
