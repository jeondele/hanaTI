package override;

public class Classes {
	public static void main(String[] args) {
		ClassA a = new ClassA();
		ClassB b = new ClassB();
		a.printing();
		b.printing();
	}
}

class ClassA {
	public void printing() {
		System.out.println("a");
	}
}

class ClassB extends ClassA {
	public void printing() {
		System.out.println("B");
	}
}