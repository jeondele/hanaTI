package kr.or.kosta.bin;

import java.io.IOException;
import java.util.List;

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountDAO;
import kr.or.kosta.entity.AccountException;
import kr.or.kosta.entity.MinusAccount;

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
	 * 
	 * @throws IOException 		계좌 생성 당시 파일 입출력 예외가 발생할 수 있습니다.
	 */
	public static void main(String[] args) throws IOException {
			AccountDAO accountManager;
			accountManager = new AccountDAO();
			accountManager.create(new Account("1111-2222", "윤예슬", 486, 100000));
			accountManager.create(new Account("1111-3333", "전상일", 1229, 200000));
			accountManager.create(new MinusAccount("1111-4444", "전상일", 1229, 200000, 3000000));
			accountManager.create(new MinusAccount("2222-5555", "전수연", 1020, 5000000, 130000000));
			MainFrame mainFrame = new MainFrame();
			mainFrame.getCenterPanel().setAccountManager(accountManager);
	}
}
