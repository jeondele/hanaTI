
public class MountainBicycle extends Bicycle {
	
	String frame;
	boolean suspension;
	
	public MountainBicycle() {
		super();
		//this(null, false);
	}
	
	public MountainBicycle(String frame, boolean suspension) {
		//super();
		this.frame = frame;
		this.suspension = suspension;
	}

	public MountainBicycle(int id, String brand, String frame, boolean suspension) {
		super(id, brand); //직접 작성하면 super 안생긴다 
		this.frame = frame;
		this.suspension = suspension;
	}

	public void running() {
		System.out.println("산도 달리자");
	}
	
	@Override
	public String toString() {
		return super.toString() +" MountainBicycle [frame=" + frame + ", suspension=" + suspension + "]";
	}
	
	
}
