package section;

public class Cat extends Animal implements Climb {
	public Cat(String name, int age) {
		super(name, age);
	}
	
	public void remember() {
		System.out.println(this.getClass().getSimpleName() + " can remember for 5 minutes ");
	}
	
	public void protectOwner() {
		System.out.println(this.getClass().getSimpleName() + " will protect owner ");
	}
	
	public void climb() {
		System.out.println(this.getClass().getSimpleName() + " can climb ");
	}
}
