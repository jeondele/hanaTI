package staticInheritance;

public class BaseClass {
	public static int num = 5;
	public static void sayHello() {
		System.out.println("Hello");
	}
	public static void main(String[] args) {
		BaseClass.sayHello();
		System.out.println(BaseClass.num);
		SubClass.sayHello();
		SubClass.sayHello(true);
	}

}
