package kr.or.kosta.entity;

/**
 * 은행계좌 처리 시 발생되는 예외를 처리하는 클래스
 * 
 * @author 전상일
 */
public class AccountException extends Exception {

	private int errorCode;

	/**
	 * 파라미터 값이 없을 때 기본으로 반환할 메세지와 에러코드를 생성합니다.
	 */
	public AccountException() {
		this("계좌처리 중 예기치 않은 에러가 발생하였습니다.", -9);
	}

	/**
	 * @param message		예외 발생 시 사용자에게 보여줄 메세지를 의미합니다.		
	 * @param errorCode		발생한 예외의 코드번호를 의미합니다.
	 */
	public AccountException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	/**
	 * @return 예외 발생 시 해당 예외의 에러코드를 반환합니다.
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/* 
	 *  인스턴스를 호출할 때 해쉬코드 값이 아닌 발생 에러코드를 리턴합니다.
	 */
	@Override
	public String toString() {
		return "AccountException [errorCode=" + getErrorCode() + "]";
	}
}
