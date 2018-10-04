import java.util.LinkedList;
import java.util.Stack;

public class QueueExample {

	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<String>(); //추가 삭제, 그중에서도 삭제가 많을 때 linkedlist 많이 사용
		queue.offer("aaa");		//저장할때는 offer					
		queue.offer("bbb");							
		queue.offer("ccc");							
		queue.offer("aaa");						
		
		queue.poll();			//빼올때는 poll
		queue.poll();			
		System.out.println(queue.poll());
		
		for ( String string : queue) {
			System.out.println(string);
		}
	}

}
