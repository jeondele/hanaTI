package com.lotto;

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
			System.out.println();
			System.out.println();
			System.out.println();
			Lotto lotto = new Lotto(money, autoNum);
			System.out.println(lotto.returnLottoValue());
			
		}
	}

}
