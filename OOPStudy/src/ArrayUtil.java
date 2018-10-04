/**
 * 배열 관련한 공통 기능 정의
 * 
 * @author 전상일
 *
 */
public class ArrayUtil {
	
	/**
	 * 배열 복사
	 * @param src			복사하고자 하는 원본 배열
	 * @param increament	증가치
	 * @return				복사된 배열
	 */
	public static int[] copy(int[] src, int increament) {
	
		int[] array = new int[src.length + increament];
		for (int i = 0 ; i < src.length; i ++) {
			array[i] = src[i];
		}
		
		return array;
	}
	
	/**
	 * 배열 오름차순 정렬
	 * @param src			원본 배열	
	 */
	
	public static void sort(int[] src) {
		for (int i = 0; i < src.length; i++) {
			for (int j = 0; j < src.length - 1 - i; j++) {
				if (src[j] > src[j + 1]) {
					int tmp = src[j];
					src[j] = src[j + 1];
					src[j + 1] = tmp;
				}
			}
		}

		for (int i : src) {
			System.out.println(i);
		}
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		int[] copy = ArrayUtil.copy( array , 4);
		for (int x : copy) {
			System.out.print(x + "\t");
		}
	}
}
