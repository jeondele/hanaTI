package section;

abstract class Animal {
	String name;
	int lifeExpentency;
	
	public Animal(String name, int lifeExpentency) {
		this.name = name;
		this.lifeExpentency = lifeExpentency;
	}
	
	public abstract void remember();
	public abstract void protectOwner();
	
	public String toString() {
		return this.getClass().getSimpleName()+ ":" +name+":" +lifeExpentency;
	}
}
