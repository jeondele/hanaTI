package com.lotto;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Lotto  {
	final static String dateNow = new Date().toLocaleString();
	static Scanner sc;
	private int inputMoney;
	private int autoNum;
	private int handNum;
	
	Lotto() {
		this(0,0);
	}
	
	Lotto(int inputMoney, int autoNum) {
		this.inputMoney = inputMoney;
		this.autoNum = autoNum;
		this.handNum = (inputMoney/1000 - autoNum);
	}
	
	public int change () {
		return inputMoney%1000;
	}
	
	public int[][] getAutoLottos(int autoNum) {
		if (!isExisting(autoNum)) {
			return null;
		} else {	
			int[][] autoLottos = new int[autoNum][6];
			for (int i = 0; i < autoNum; i++) {
				for (int j = 0; j < 6; j++) {
					
					autoLottos[i][j] = (int) (Math.random() * 45 + 1);
					
					for (int k = 0; k < j; k++) {
						if (autoLottos[i][k] == autoLottos[i][j]) {
							j--;
							break;
						}
					}
				}
			}
			return autoLottos;
		}
	}
	
	public int[][] getHandLottos(int handNum) {
		if (!isExisting(handNum)) {
			return null;
		} else {
			int[][] returnArray = new int[handNum][6];
			return recursive(0, handNum, returnArray);
		}
	}
	
	public int[][] recursive(int start, int end, int[][] returnArray) {
		sc = new Scanner(System.in);
		
		if (start == end) {
			return returnArray;
		} else {
			int error = 0;
			System.out.printf("%d번째 수동로또 번호 6개를 입력해주세요 : ", start+1);
			int[] tmpArray = new int[6];
			
			
			for (int j = 0; j < 6; j++) {
				tmpArray[j] = sc.nextInt();
			}
			
			OUT:
			for (int j = 0; j < 6; j++) {
				if (!(tmpArray[j] > 0 && tmpArray[j] < 46)) {
					System.out.println("다시 입력해주세요");
					error ++;
					break OUT;
				}
				
				for (int k = 0; k < j; k++) {
					if (tmpArray[k] == tmpArray[j]) {
						System.out.println("중복 값이 있습니다. 다시 입력해주세요");
						error ++;
						break OUT;
					}
				}
			}
			returnArray[start] = tmpArray;
			
			if (error != 0 ) {
				recursive(start, end, returnArray);
			} else {
				recursive(start+1, end, returnArray);
			}
			
			return returnArray;
		}
	}
	
	public int[][] sorting(int[][] lottos) {
		if(isExisting(lottos)) {
			for (int i = 0 ; i < lottos.length ; i ++) {
				Arrays.sort(lottos[i]);
			}
			return lottos;
		}
		return null;
	}
	
	public boolean isExisting(int Num) {
		boolean flag = (Num != 0) ? true : false;
		return flag;
	}
	
	public boolean isExisting(int[][] handLotto) {
		boolean flag = (handLotto != null) ? true : false;
		return flag;
	}
	
	public String returnLottoValue() {
		int[][] autoLotto = sorting(getAutoLottos(autoNum));
		int[][] handLotto = sorting(getHandLottos(handNum));
		
		StringBuilder sb = new StringBuilder();
		sb.append("\n\n");
		sb.append("발매 시간 : \t");
		sb.append(dateNow).append("\n");
		sb.append("거스름돈 : \t").append(change()+"원\n");
		sb.append("----------------------------------------\n");
		
		if (autoLotto == null) {
			sb.append("자동은 없습니다\n\n");
		} else {
			sb.append("자동 : \n");
			for (int i = 0 ; i < autoLotto.length; i ++) {
				sb.append("\t");
				for (int j = 0 ; j < 6; j++) {
					sb.append(autoLotto[i][j]+ " ");
				}
				sb.append("\n");
			}
		}
		
		
		sb.append("\n");
		if (handLotto == null) {
			sb.append("수동은 없습니다\n\n");
		} else {
			sb.append("수동 : \n");
			for (int i = 0 ; i < handLotto.length; i ++) {
				sb.append("\t");
				for (int j = 0 ; j < 6; j++) {
					sb.append(handLotto[i][j]+ " ");
				}
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
	
}