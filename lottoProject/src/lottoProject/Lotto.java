package lottoProject;

import java.util.Arrays;
import java.util.Date;

public class Lotto {
	final static String dateNow = new Date().toLocaleString();
	
	private int inputMoney;
	private int autoNum;
	private int[][] lottoNumsByHand;
	
	Lotto() {
		this(0,0,null);
	}
	Lotto(int inputMoney, int autoNum, int[][] lottoNumsByHand) {
		this.inputMoney = inputMoney;
		this.autoNum = autoNum;
		this.lottoNumsByHand = lottoNumsByHand;
	}
	
	public int change () {
		return inputMoney%1000;
	}
	
	public int[][] getAutoLottos(int autoNum) {
		if (isExisting(autoNum)) {
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

		return null;
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
	
	public boolean isExisting(int autoNum) {
		boolean flag = (autoNum != 0) ? true : false;
		return flag;
	}
	
	public boolean isExisting(int[][] handLotto) {
		boolean flag = (handLotto !=null) ? true : false;
		return flag;
	}
	
	public String returnLottoValue() {
		int[][] autoLotto = sorting(getAutoLottos(autoNum));
		int[][] handLotto = sorting(lottoNumsByHand);
		
		StringBuilder sb = new StringBuilder();
		sb.append("발매 시간 : ").append("\t");
		sb.append(dateNow).append("\n");
		sb.append("거스름돈 : ").append("\t").append(change()+"원").append("\n");
		sb.append("----------------------------------------").append("\n");
		
		if (autoLotto == null) {
			sb.append("자동은 없습니다").append("\n\n");
		} else {
			sb.append("자동 : ").append("\n");
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
			sb.append("수동은 없습니다").append("\n\n");
		} else {
			sb.append("수동 : ").append("\n");
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