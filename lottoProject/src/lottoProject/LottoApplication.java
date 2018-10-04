package lottoProject;

import java.util.Scanner;

public class LottoApplication {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("지불하실 금액 입력해주세요 : ");
		int money = sc.nextInt();
		
		if (money < 1000) {
			System.out.println("돈이 부족합니다");
		} else {
			int totalNum = money/1000;
			System.out.printf("자동로또 몇 개를 원하시나요? (%d 개 이하로 입력해주세요) : ", totalNum);
			int autoNum = sc.nextInt();
			int handNum = totalNum - autoNum;
			int[][] lottoNumsByHand;
			if(handNum >0) {
				lottoNumsByHand = new int[handNum][6];
				
				for (int i = 0 ; i < handNum; i++) {
					System.out.printf("%d번째 수동로또 번호 6개를 입력해주세요 : ", i+1);
					try {
						for (int j = 0 ; j < 6; j++) {
							lottoNumsByHand[i][j] = sc.nextInt();
						}
					} catch (Exception e) {
						System.out.println("올바르게 입력해주세요!");
					}
					
				}
			}
			else {
				lottoNumsByHand = null;
			}
			System.out.println();
			System.out.println();
			System.out.println();
			Lotto lotto = new Lotto(money, autoNum, lottoNumsByHand);
			System.out.println(lotto.returnLottoValue());
			
		}
	}

}
