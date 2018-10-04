package kr.or.kosta.entity;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountDAO {
	/** 저장 파일 경로 */
	private static final String FILE_PATH = "Accounts.txt";

	/** 레코드(계좌)수 저장을 위한 파일 컬럼 사이즈 고정 */
	private static final int RECORD_COUNT_LENGTH = 4;

	/** 레코드(계좌번호, 예금주, 비밀번호, 현재금액, 대출금액) 저장을 위한 컬럼별 사이즈 고정 */
	private static final int TYPE_LENGTH = 1; // 계좌타입(1바이트)
	private static final int NUM_LENGTH = 20; // 계좌번호(20바이트)
	private static final int OWNER_LENGTH = 8; // 예금주(8바이트)
	private static final int PWD_LENGTH = 4; // 비밀번호(4바이트)
	private static final int RESTMONEY_LENGTH = 20; // 현재금액(20바이트)
	private static final int LOANMONEY_LENGTH = 20; // 대출금액(20바이트)

	/** 계좌정보 저장을 위한 레코드 사이즈 : 73바이트 */
	public static final int RECORD_LENGTH = TYPE_LENGTH +NUM_LENGTH + OWNER_LENGTH + PWD_LENGTH + RESTMONEY_LENGTH + LOANMONEY_LENGTH;

	private RandomAccessFile file;

	/** 저장된 친구(레코드)수 */
	private int recordCount = 0;

	public AccountDAO() throws IOException {
		file = new RandomAccessFile(FILE_PATH, "rw");
		// 저장된 파일이 있는 경우
		if (file.length() != 0) {
			recordCount = file.readInt();
			System.out.println(recordCount);
		} 
	}

	/** getter */
	public int getRecordCount() {
		return recordCount;
	}
	
	/**
	 * 계좌 생성하여 파일에 입력하는 메소드
	 * 
	 * @param account		입력할 계좌
	 * @param idx			입력 시킬 인덱스
	 * @throws IOException	입력시 예외가 발생할 수 있음.
	 */
	public void create(Account account, int idx) throws IOException {
		
		file.writeInt(idx);
		// 파일의 해당 인덱스로 파일 포인터 이동.
		file.seek(((idx) * RECORD_LENGTH) + RECORD_COUNT_LENGTH);

		int accType = account.getAccType();
		String accNum = account.getAccountNum();
		String accOwner = account.getAccountOwner();
		int accPwd = account.getPasswd();
		long accRM = account.getRestMoney();

		file.writeInt(accType);
		
		int accNumCount = accNum.length();
		for (int i = 0; i < (NUM_LENGTH / 2); i++) {
			file.writeChar((i < accNumCount ? accNum.charAt(i) : ' '));
		}
		
		int accOwnerCount = accOwner.length();
		for (int i = 0; i < (OWNER_LENGTH / 2); i++) {
			file.writeChar((i < accOwnerCount ? accOwner.charAt(i) : ' '));
		}
		
		file.writeInt(accPwd);
		file.writeLong(accRM);
		
		if (account instanceof MinusAccount) {
			long accLM = ((MinusAccount) account).getBorrowMoney();
			file.writeLong(accLM);
			// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
			file.seek(0);
		} else {
			long accLM = 0L;
			file.writeLong(accLM);
			// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
			file.seek(0);
		}
	}

	/** 계좌 정보 디폴트 저장 */
	public void create(Account account) throws IOException {
		for (int i = 0 ; i < recordCount; i++) {
			if(account.getAccountNum().equals(read(i).getAccountNum())) {
				return;
			}
		}
		file.writeInt(recordCount);
		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		file.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);

		int accType = account.getAccType();
		String accNum = account.getAccountNum();
		String accOwner = account.getAccountOwner();
		int accPwd = account.getPasswd();

		file.writeInt(accType);
		
		int accNumCount = accNum.length();
		for (int i = 0; i < (NUM_LENGTH / 2); i++) {
			file.writeChar((i < accNumCount ? accNum.charAt(i) : ' '));
		}
		
		int accOwnerCount = accOwner.length();
		
		for (int i = 0; i < (OWNER_LENGTH / 2); i++) {
			file.writeChar((i < accOwnerCount ? accOwner.charAt(i) : ' '));
		}
		
		file.writeInt(accPwd);

		if (account instanceof MinusAccount) {
			long accLM = ((MinusAccount)account).getBorrowMoney();
			long accRM = ((MinusAccount)account).getSuperRestMoney();

			file.writeLong(accRM);
			file.writeLong(accLM);

			// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
			// 등록된 레코드(계좌) 수 1 증가
			file.seek(0);
			file.writeInt(++recordCount);

		} else {
			long accRM = account.getRestMoney();
			long accLM = 0L;

			file.writeLong(accRM);
			file.writeLong(accLM);

			// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
			// 등록된 레코드(계좌) 수 1 증가
			file.seek(0);
			file.writeInt(++recordCount);
		}
	}
	/**
	 * 계좌 하나당 저장
	 * 
	 * @throws AccountException
	 */
	public void add(int accType, String accNum, String accOwner, int accPwd, long accRM)
			throws IOException, AccountException {
		Account account = null;
		// 존재하는 계좌번호인지 조회
		for (int i = 0; i < recordCount; i++) {
			account = read(i);
			System.out.println(account.toString());
			if (account.getAccountNum().equals(accNum)) {
				throw new AccountException("등록된 계좌입니다.", -1);
			}
		}

		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		file.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		file.writeInt(accType);
		
		int accNumCount = accNum.length();

		for (int i = 0; i < (NUM_LENGTH / 2); i++) {
			file.writeChar((i < accNumCount ? accNum.charAt(i) : ' '));
		}

		int accOwnerCount = accOwner.length();

		for (int i = 0; i < (OWNER_LENGTH / 2); i++) {
			file.writeChar((i < accOwnerCount ? accOwner.charAt(i) : ' '));
		}

		file.writeInt(accPwd);
		file.writeLong(accRM);
		file.writeLong(0L);

		// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
		// 등록된 레코드(계좌) 수 1 증가
		file.seek(0);
		file.writeInt(++recordCount);

	}
	
	/**
	 * 계좌 하나당 저장
	 * 
	 * @throws AccountException
	 */
	public void minusAdd(int accType, String accNum, String accOwner, int accPwd, long accRM, long accLM)
			throws IOException, AccountException {
		Account account = null;
		// 존재하는 계좌번호인지 조회
		for (int i = 0; i < recordCount; i++) {

			account = read(i);

			if (account.getAccountNum().equals(accNum)) {
				throw new AccountException("등록된 계좌입니다.", -1);
			}
		}

		// 파일의 마지막 레코드끝으로 파일 포인터 이동.
		file.seek((recordCount * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		file.writeInt(accType);
		int accNumCount = accNum.length();

		for (int i = 0; i < (NUM_LENGTH / 2); i++) {
			file.writeChar((i < accNumCount ? accNum.charAt(i) : ' '));
		}

		int accOwnerCount = accOwner.length();

		for (int i = 0; i < (OWNER_LENGTH / 2); i++) {
			file.writeChar((i < accOwnerCount ? accOwner.charAt(i) : ' '));
		}

		file.writeInt(accPwd);
		file.writeLong(accRM);
		file.writeLong(accLM);

		// 레코드 저장 후 파일포인터를 파일의 처음으로 이동시켜
		// 등록된 레코드(계좌) 수 1 증가
		file.seek(0);
		file.writeInt(++recordCount);
	}

	/** 등록된 전체리스트 반환 */
	public List<Account> listAll() throws IOException {
		List<Account> list = new ArrayList<Account>();
		for (int i = 0; i < recordCount; i++) {
			Account account = read(i);
			list.add(account);
		}

		Collections.sort(list, new Comparator<Account>() {
			@Override
			public int compare(Account a1, Account a2) {
				if (a1.getAccType() == a2.getAccType()) {
					return a1.getAccountNum().compareTo(a2.getAccountNum());
				} else {
					return a1.getAccType() - a2.getAccType();
				}
			}
		});
		return list;
	}

	/** 등록된 유형별리스트 반환 */
	public List<Account> list(int type) throws IOException {
		List<Account> list = new ArrayList<Account>();
		for (int i = 0; i < recordCount; i++) {
			Account account = read(i);
			if (account.getAccType() ==type) {
				list.add(account);
			}
		}
		Collections.sort(list, new Comparator<Account>() {
			@Override
			public int compare(Account a1, Account a2) {
				if (a1.getAccType() == a2.getAccType()) {
					return a1.getAccountNum().compareTo(a2.getAccountNum());
				} else {
					return a1.getAccType() - a2.getAccType();
				}
			}
		});

		return list;
	}

	/**
	 * 계좌번호를 파라미터로 받아서 일치하는 계좌번호의 계좌를 반환하는 메소드입니다.
	 * 
	 * @param accountNum 조회할 계좌번호를 파라미터로 받습니다.
	 * @return 계좌번호에 맞는 계좌를 반환합니다.
	 * @throws AccountException 해당 인스턴스의 계좌목록에 해당 계좌번호가 없으면 예외가 발생합니다.
	 */
	public Account get(String accountNum) throws AccountException, IOException {
		for (int i = 0; i < recordCount; i++) {
			Account account = read(i);
			if (account.getAccountNum().equals(accountNum)) {
				return account;
			}
		}
		throw new AccountException("해당 계좌번호가 없습니다.", -2);
	}

	/**
	 * 예금주 명을 받아서 해당 객체의 계좌목록 중에 예금주 명과 일치하는 계좌 목록을 반환하는 메소드입니다.
	 * 
	 * @param accountOwner 계좌의 예금주를 검색하고 싶을 때 파라미터로 받는 예금주 명입니다.
	 * @return 예금주가 가지고있는 계좌 목록들을 반환
	 * @throws AccountException 해당 AccountManager 인스턴스의 계좌목록에 해당 예금주가 없을 시 예외가
	 *                          발생합니다.
	 * @throws IOException
	 */
	public List<Account> search(String accountOwner) throws AccountException, IOException {
		List<Account> list = new ArrayList<Account>();

		for (int i = 0; i < recordCount; i++) {
			Account account = read(i);
			if (account.getAccountOwner().equals(accountOwner)) {
				list.add(account);
			}
		}

		if (list.size() == 0)
			throw new AccountException("해당 예금주가 없습니다.", -3);

		Collections.sort(list, new Comparator<Account>() {
			@Override
			public int compare(Account a1, Account a2) {
				if (a1.getAccType() == a2.getAccType()) {
					return a1.getAccountNum().compareTo(a2.getAccountNum());
				} else {
					return a1.getAccType()-a2.getAccType();
				}
			}
		});

		return list;
	}

	/** 특정 레코드의 정보를 계좌로 반환 */
	private Account read(int index) throws IOException {
		int acctype = 0;
		String accNum = "";
		String accOwner = "";
		int accPwd = 0;
		long accRM = 0;
		long accLM = 0;

		file.seek((index * RECORD_LENGTH) + RECORD_COUNT_LENGTH);
		
		acctype = file.readInt();
		
		if (acctype != 1) {
			MinusAccount account = null;
			for (int i = 0; i < (NUM_LENGTH / 2); i++) {
				accNum += file.readChar();
			}
			accNum = accNum.trim();

			for (int i = 0; i < (OWNER_LENGTH / 2); i++) {
				accOwner += file.readChar();
			}
			accOwner = accOwner.trim();

			accPwd = file.readInt();
			accRM = file.readLong();
			accLM = file.readLong();

			account = new MinusAccount(accNum, accOwner, accPwd, accRM, accLM);

			return account;
		} else {
			Account account = null;

			for (int i = 0; i < (NUM_LENGTH / 2); i++) {
				accNum += file.readChar();
			}
			accNum = accNum.trim();

			for (int i = 0; i < (OWNER_LENGTH / 2); i++) {
				accOwner += file.readChar();
			}
			accOwner = accOwner.trim();

			accPwd = file.readInt();

			accRM = file.readLong();
			account = new Account(accNum, accOwner, accPwd, accRM);
			return account;
		}
	}

	/**
	 * 파라미터로 받은 계좌번호와 일치하는 계좌를 제거하고, 제거가 되었으면 true, 되지 않았다면 false를 반환하는 메소드입니다.
	 * 
	 * @param accountNum 지우고자 하는 계좌의 계좌번호
	 * @return 계좌번호가 지워졌으면 true, 지울 계좌가 없으면 false를 반환합니다.
	 * @throws AccountException 계좌번호와 일치하는 계좌가 없다면 예외가 발생합니다.
	 * @throws IOException
	 */
	public boolean remove(String accountNum) throws AccountException, IOException {
		int idx = 0;
		for (int i = 0; i < recordCount; i++) {
			Account account = read(i);

			if (account.getAccountNum().equals(accountNum)) {
				idx = i+1;
				for (int j = idx; j < recordCount; j++) {
					create(read(j), j-1);
				}
				file.writeInt(--recordCount);
				return true;
			}
		}

		throw new AccountException("삭제할 계좌번호가 없습니다", -4);
	}

	/**
	 * 계좌 유형에 맞는 계좌번호가 존재하는 지 여부를 검증하는 메소드
	 */
	public boolean isExisting(int type, String key) throws AccountException, IOException {
		int cnt = 0;
		for (int i = 0; i < recordCount; i++) {
			Account account = read(i);
			if (!(account.getAccType() == type) && account.getAccountNum().equals(key)) {
				cnt++;
			}
		}

		if (cnt == 0) {
			return true;
		}
		throw new AccountException("삭제할 계좌가 없습니다.", -4);
	}

	// 스트림 닫기
	public void close() {
		try {
			if (file != null)
				file.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
