
public class AutoBoxing {

	public static void main(String[] args) {
		Double obj = 78.56; // new double()로 자동 박싱 == autoboxing
		System.out.println(obj);
		
//		double value = new Double(169.45); // unboxing : 객체의 double value가 자동으로 나온다.
		double value = new Double(169.45).doubleValue();
		
	}

}
