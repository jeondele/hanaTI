package kr.or.kosta.bin;

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entity.AccountManager;

/**
 * AMS (Account Management System)
 * 은행계좌 관리 어플리케이션입니다.
 * 
 * @author 전상일
 *
 */
public class AMS {
	/**
	 * 어플리케이션 실행 메소드입니다.
	 */
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		AccountManager accountManager = new AccountManager();
		mainFrame.getCenterPanel().setAccountManager(accountManager);
	}
}
