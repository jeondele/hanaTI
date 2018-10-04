package section;

public class InterfaceAndAbstractClassDemo {

	public static void main(String[] args) {
		Dog dog = new Dog("Jack", 16);
		Cat cat = new Cat("Joe", 20);
		Nothing nothing = new Nothing();
		System.out.println("Dog:" + dog);
		System.out.println("Cat:" + cat);
		dog.remember();
		dog.protectOwner();
		Learn dl = dog;
		Learn zz = nothing;
		zz.learn();
		dl.learn();
		
		cat.remember();
		cat.protectOwner();
		Climb c = cat;
		c.climb();
		Man man = new Man("Ravindra", 40);
		System.out.println(man);
		
		Climb cm = man;
		cm.climb();
		Think t = man;
		t.think();
		Learn l = man;
		l.learn();
		Apply a = man;
		a.apply();
	}

}
