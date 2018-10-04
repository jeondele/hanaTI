
public class Yeseul {
	final static String boyfriend = "상일이";
	private String todo ;
	
	Yeseul() {
		this("일단 만나자");
	}
	
	Yeseul(String whatToDo) {
		todo = whatToDo;
	}
	public String getTodo() {
		return todo;
	}
	
	public void setTodo(String todo) {
		this.todo = todo;
	}
	
	public void placeWithBoyFriend(String place) {
		System.out.println(boyfriend + "와 " + place + "가기");
	}
	
	public void haveWithBoyFriend(String food) {
		System.out.println(boyfriend + "와 " + food + "먹기");
	}
	
	public static void main(String[] args) {
		Yeseul yeseul = new Yeseul();
		System.out.println(yeseul.getTodo());
		yeseul.placeWithBoyFriend("춘천");
		yeseul.haveWithBoyFriend("쮺뀪믺");
	}
}
