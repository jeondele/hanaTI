/**
 * 다중구현을 이용한 클래스 정의
 * 
 * @author 전상일
 * 
 */
public class SamsungTV implements RemoteControl, Browsable {
	
	private int currentChannel;
	private int currentVolume;
	
	//부모는 자동으로 object
	public SamsungTV() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SamsungTV(int currentChannel, int currnetVolume) {
		super(); // 부모 클래스의 디폴트 생성자가 자동적으로 추가된다.
		this.currentChannel = currentChannel;
		this.currentVolume = currnetVolume;
	}

	
	public int getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}

	public int getCurrnetVolume() {
		return currentVolume;
	}

	public void setCurrnetVolume(int currnetVolume) {
		this.currentVolume = currnetVolume;
	}

	@Override
	public void surfing(String url) {
		System.out.println(url + "을 화면에 렌더링(출력)합니다");
	}

	@Override
	public void turnOn() {
		System.out.println("전원을 켭니다");
	}

	@Override
	public void turnOff() {
		System.out.println("전원을 끕니다");
	}

	@Override
	public void volumnUp() {
		if(currentVolume < MAX_VOLUME) {
			currentVolume++;
		} 
	}

	@Override
	public void volumnDown() {
		currentVolume--;
	}

	@Override
	public void setVolumn(int volume) {
		currentVolume = volume;
	}

	@Override
	public void setChannel(int channel) {
		currentChannel = channel;
	}
	
	public static void main(String[] args) {
		RemoteControl tv = (SamsungTV)new SamsungTV();
		tv.turnOn();
		tv.setChannel(147);
		
		System.out.println(((SamsungTV)tv).getCurrentChannel()); //다운캐스팅을 해줘야 get메소드 사용 가능
		
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		tv.volumnUp();
		
		System.out.println(((SamsungTV)tv).getCurrnetVolume()); //다운캐스팅을 해줘야 get메소드 사용 가능
		System.out.println(tv.MAX_VOLUME);
		tv.turnOff();
	}
}
