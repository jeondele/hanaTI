public interface RemoteControl {
	public static final/*원래 자동 생성됨(컴파일이 자동 추가)*/ int MAX_VOLUME = 50;
	public static final/*원래 자동 생성됨*/ int MIN_VOLUME = 0;
	public static final/*원래 자동 생성됨*/ int MAX_CHANNEL = 100;
	public static final/*원래 자동 생성됨*/ int MIN_CHANNEL = 1;
	public /*abstract*/ void turnOn();
	public void turnOff();
	public void volumnUp();
	public void volumnDown();
	public void setVolumn(int volume);
	public void setChannel(int channel);
	
	
}
