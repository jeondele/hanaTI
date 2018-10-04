import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class StackExample {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>(); //벡터를 확장한 클래스가 stack
		stack.push("aaa");							// 제거한하고 맨 위에거 가져오는 것이 peek.
		stack.push("abbb");
		stack.push("cccc");
		stack.push("dddd");
		stack.push("eeee");
		
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
		for ( String string : stack) {
			System.out.println(string);
		}
	}

}
