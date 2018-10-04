/**
 * 무기에 대한 수평적 규격 역할의 인터페이스
 * 
 * @author 전상일
 *
 */
public interface Weapon {
	
	/*public static final */ int weight = 10; //상수처리 public static final이 자동으로 생성 
	//메소드만 선언되는 것이 인터페이스
	//void attack(); // 이렇게 해도 된다.
	// 인터페이스는 서로 상화작용하기위한 클래스이므로 접근제한자는 반드시 public이다. 붙여주는 것이 권장사항.
	
	//자바 컴파일시 자동으로 생성되는 것들 : 1. 디폴트 생성자  2. extend Object  3. super 4. public interface 5. public abstract 6. public static final 
	public void attack(); // abstract는 안쓰지만 public은 붙여준다.
	
	
}
