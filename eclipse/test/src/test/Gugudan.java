package test;

public class Gugudan {
	String printGugudan(int number) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < 10; i++) {
			for (int j = 2 ; j <= number; j++) {
				sb.append(j + " * " +  i + " = " + i*j ).append("\t");				
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Gugudan gugudan = new Gugudan();
		System.out.println(gugudan.printGugudan(4));
	}
}
