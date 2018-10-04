/**
 * LIFO 구조의 스택 구현
 * 
 * @author 전상일
 *
 */
public class Stack {
	private int[] array;
	private int lastIdx;

	/**
	 * lastIdx 를 0으로 초기화, 생성자
	 */
	Stack() {
		this(0);
	}

	/**
	 * 생성자
	 * 
	 * @param size 인스턴스 생성시 stack의 풀사이즈
	 */
	Stack(int size) {
		array = new int[size];
	}

	/**
	 * value값을 stack에 담는 메소드
	 * 
	 * @param value stack에 넣을 int 타입의 값
	 */
	public void push(int value) {
		array[lastIdx] = value;
		lastIdx++;
	}

	/**
	 * 가장 마지막에 담긴 int 타입의 값을 반환하는 메소드
	 * 
	 * @return stack에 가장 나중에 담긴 순서대로 int 타입의 값을 반환
	 */
	public int pop() {
		int value = array[lastIdx - 1];
		lastIdx--;
		return value;
	}

	/**
	 * 실제값이 담긴 stack의 크기 반환하는 메소드
	 * 
	 * @return stack에 담긴 값들의 갯수
	 */
	public int length() {
		return lastIdx;
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack(100);
		stack.push(5);
		stack.push(1);
		stack.push(6);
		stack.push(7);
		stack.push(8);
		// 테스트를 위한 출력
		System.out.println(stack.pop()); // 8
		System.out.println(stack.pop()); // 7
		System.out.println(stack.pop()); // 6
		System.out.println(stack.length()); // stack의 크기 값 2
		System.out.println(stack.pop()); // 1
		System.out.println(stack.pop()); // 5
	}
}
