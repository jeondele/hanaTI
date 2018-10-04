package kr.or.kosta.chat.common;

public interface Protocol {
	//서버에서 클라이언트로 가는 건지 클라이언트에서 서버로 가는 건지 구분해줘야한다.
//	public static final int SC_CONNECT = 1000;
//	public static final int CS_CONNECT = 1000;
	public static final String DELEMETER = ",";
	public static final int CONNECT = 1000;
	public static final int CONNECT_RESULT = 1001;
	public static final int MULTICHAT 	= 2000;
	public static final int DISCONNECT = 3000;
}
