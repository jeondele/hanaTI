/**
 * 레퍼런스 타입 선언, 생성, 초기화
 * 다차원 배열
 * 
 * @author 전상일
 *
 */
public class ArrayExample5 {

	public static void main(String[] args) {
		String[][] array = new String[3][100];
		array[0][0] = "AAA";
		array[2][2] = "ZZZ";	
		
		String[][] array2 = new String[][] {{"a", "b","c"},{"a", "b","c"},{"a", "b","c"}};
		String[][] array3 = {{"a", "b","c"},{"a", "b","c"},{"a", "b","c"}};
		
		//이론 시험!!!!!!!!!!!!!!!!!!!
		
		
		//문법에러 아님 0000 이론시험!!!!!!!!
		int[][] twoDim;                  // 선언
		twoDim = new int[3][];           // 생성
		twoDim[0] = new int[2]; 
		twoDim[1] = new int[4];
		twoDim[2] = new int[1];
		twoDim[0][0] = 1;                // 초기화
		twoDim[0][1] = 2;
		twoDim[1][0] = 3;
		twoDim[1][1] = 4;
		
		
		// 선언/생성/초기화 동시에
		int twoDim2[][] = {{1, 2}, {3, 4, 5, 6}, {7}};


	}

}
