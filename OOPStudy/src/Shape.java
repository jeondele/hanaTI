/**
 * 모든 도형의 공통적인 속성과 기능 정의한 추상클래스 
 * 
 * @author 전상일
 *
 */
public abstract class Shape {
	protected double x, y; //패키지가 같은 곳에서, 또는 패키지가 다르더라도 상속되는 서브에게 넘겨주기 위해서 protected 사용
	//추상클래스는 생성자, 게터 세터 없음 

	// 추상메소드
	// 서브클래스가 반드시 구현(재정의)해야 할 수직적 규약.
	public abstract void draw(); 
	public abstract double getLength();
	public abstract double getArea();
	
	//일반적인 메소드도 있을 수 있다.
	public void xxx() {
	}
}
