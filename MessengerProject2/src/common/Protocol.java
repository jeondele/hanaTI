package common;

public interface Protocol {

   public static final String DELEMETER = ",";
   
   /** 1. 로그인(입장) 패널 */
   public static final int CONNECT = 1000; //접속 시도
   public static final int CONNECT_RESULT = 1001; //접속 시도 결과   
   public static final int DISCONNECT = 9999; // 연결해제 및 종료
   
   
   /** 2. 대기실 패널 */
   public static final int ROOM_SEARCH = 2000; //대화방 검색
   public static final int ROOM_LIST = 2100; //대화방 전체 목록
   
   public static final int ROOM_ADD = 2200; //대화방 개설
   public static final int modal_ROOM_ADD = 2201; //(모달)대화방 개설 확인, 취소
   public static final int ROOM_DELETE = 2202; // 접속자 수가 0일때 , 자동 폐쇄
   
   public static final int ROOM_INFORM = 2300; // 대화방 정보 * 채팅방 유저 목록도 나와야 함.
   
   public static final int ROOM_ENTER = 2400; // 대화방 입장
   public static final int ROOM_ENTER_RESULT = 2401; // 대화방 입장 결과 : 꽉차면 실패
   public static final int ROOM_OUT = 2500; // 대화방 입장
   
   
   public static final int ALL_USER_LIST = 3100; // 모든(접속중인) 대기실 + 채팅방 안 사용자 목록
   public static final int ROOM_USER_LIST = 3200; // 대기실에 있는 사용자 목록
   
   public static final int SESSION_OUT = 9000; // 로그아웃(대기실 퇴장)
   
   /** 3. 채팅방 패널 */
   public static final int MULTI_CHAT = 4000; // 전체 메시지
   
   public static final int PRIVATE_CHAT = 4100; //귓속말 기능
   public static final int PRIVATE_CHAT_ONOFF = 4101; // (모달) 귓속말 기능 활성화
   
   public static final int CHAT_USER_LIST = 4200; //채팅방 접속 유저 목록
   
   public static final int CHAT_INVITATION = 4300; // 채팅방 초대
   public static final int modal_CHAT_INVITATION = 4301; //(모달) 초대장 전송, 취소
   
   public static final int CHAT_EXIT = 4400; // 채팅방 퇴장
   public static final int modal_CHAT_EXIT = 4401; // (모달) 채팅방 퇴장 확인, 취소
   
   public static final int ROOM_IN = 4404; // (모달) 채팅방 퇴장 확인, 취소
   
}