import java.util.Iterator;
import java.util.stream.IntStream;

/**
 * 
 * @author 전상일
 * 1차원 배열 선언, 생성, 초기화.
 *  
 */
public class ArrayExample {

	public static void main(String[] args) {
		
		int[] array = new int[10]; //선언 방식 1

//		System.out.println(array[0]);
//		System.out.println(array[1]);
//		array[0] = 10;
//		System.out.println(array[0]);

//		for( int i =0 ; i < array.length; i ++) {
//			array[i] = i+1;
//			System.out.println(array[i]);
//		}
		
		int[] array2 = new int[] {1, 2, 3, 4, 5};	//선언 방식 2
		int[] array3 = {1, 2, 3, 4, 5}; //선언 방식 3
		
//		퍼포먼스 good, error 가능성 low
//		for (int x : array3) {
//			System.out.println(x);
//		}
		
		// 미션1 : 배열 복사
		//int[] array3 = {3, 1, 9, 2, 5};
		
//		int[] array4 = new int[7];
//		for (int i = 0 ; i < array4.length; i ++) {
//			array4[i] = (i < array3.length) ? array3[i] : 0;
//		}
		
		//쌤
		int[] array4 = new int[array3.length + 2];
		for (int i = 0 ; i < array3.length; i ++) {
			array4[i] = array3[i];
		}
		
		// 미션2 : 배열 정렬
		int[] lottos = {34, 12, 3, 9, 25, 2};
		
		for(int i = 0; i < lottos.length; i++) { 
			for(int j = 0; j < lottos.length - 1-i; j++) { 
				if(lottos[j] > lottos[j+1]) { 
					int tmp = lottos[j]; 
					lottos[j] = lottos[j+1]; 
					lottos[j+1] = tmp; 
				} 
			} 
		}
		
		for (int i : lottos) {
			System.out.println(i);
		}
		
	}

}
