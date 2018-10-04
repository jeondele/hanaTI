

//파일저장은 public으로

public interface Ainterface {
	public void a();
}

interface Binterface {
	public void b();
}

//인터페이스 다중 상속 인터페이스만 가능!!!, 클래스간의 다중상속은 안돼!!!
//인터페이스를 사용하는 목적은 수평적 규약!!!
interface Cinterface extends Ainterface, Binterface { 
	public void c();
}