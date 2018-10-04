/**
 * 다차원 배열 테스트
 * 
 * @author 전상일
 *
 */
public class ArrayExample2 {

	public static void main(String[] args) {
		char[][] array = new char[10][10];
		array[0][0] = 'A';
		array[9][9] = 'Z';
		
//		for (int i = 0 ; i < array.length; i++) {
//			for ( int j = 0 ; j < array[i].length; j++) {
//				System.out.print(array[i][j] + "\t");
//			}
//		}
		
		int[][] array2 = new int [][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; //대괄호 안에 숫자 들어가면 안된다. 중활호 안에만
		int[][] array3 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}; //대괄호 안에 숫자 들어가면 안된다. 중활호 안에만
		
		float pi = 3.141F;
		
		//구구단 만들기!!
		int[][] gugudan = new int[8][9];
		
		for (int i = 0 ; i < gugudan.length; i++) {
			for (int j = 0; j < gugudan[i].length; j++) {
				gugudan[i][j] = (i+2) * (j+1);
				System.out.print((i+2) + " * " + (j+1) + " = " +gugudan[i][j] + "\t");
			}
			System.out.println();
		}
		
		//과제!! 데이터구조 만들기 stack 만들기 <클래스로>
		//클래스 다이어그램에 그려준것을 클래스로 만들기
	}

}
