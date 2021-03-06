import java.util.Arrays;

public class AccountException extends Exception {
	//String message; 미리 상속 받았다
	private int errorCode;

	public AccountException() {
		this("계좌처리 중 예기치 않은 에러가 발생하였습니다.", -9);
	}

	public AccountException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "AccountException [errorCode=" + errorCode + ", getErrorCode()=" + getErrorCode() + ", getMessage()="
				+ getMessage() ;
	}

	
	
	
}
