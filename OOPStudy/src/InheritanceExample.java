
public class InheritanceExample {

	public static void main(String[] args) {
		Bicycle bicycle;
		bicycle = new Bicycle(10, "삼천리자전거");
		
		System.out.println(bicycle);
		
		Bicycle mb = new MountainBicycle();
		MountainBicycle mb2 =(MountainBicycle)(new Bicycle());
		//재사용
		System.out.println(mb);
		
		//확장
//		System.out.println(mb.frame);
//		System.out.println(mb.suspension);
		mb.running();
		
	}

}
