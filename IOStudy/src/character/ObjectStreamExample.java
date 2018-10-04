package character;

import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.Vector;

public class ObjectStreamExample {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		String path = "example7.ser"; // 꼭 이렇게 할 필요는 없지만 권장사항이다.
		
//		int age = 20;
//		double weight = 45.6;
//		
//		String message = "오브젝트 스트림 실습...";
//		Calendar today = Calendar.getInstance();
//		Frame frame = new Frame("타이틀");
//		frame.setSize(500,200);
//		
//		Account account = new Account("1111", "홍길동", 1111, 1212);
//		
//		Vector<Account> vector = new Vector<>();
//		for (int i = 0; i < 50000; i++) {
//			vector.addElement(new Account(i+"-2222","1",1,1));
//		}
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
//		out.writeObject(age);
//		out.writeObject(weight);
//		out.writeObject(message);
//		out.writeObject(today);
//		out.writeObject(frame);
//		out.writeObject(account); //그냥 쓰면 안돌아감 serializable 임포트
//		out.writeObject(vector);
//		
//		if (account instanceof Serializable) { // exception 코드가 이렇게 되어있다.
//			throw new NotSerializableException();
//		}
//		out.flush(); //데이터 부족시 사용
//		out.close();
		System.out.println("다 썻음..");
		
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		int age = 0;
		double weight = 0;
		String message = null;
		Calendar today = null;
		Frame frame = null;
		Account account = null;
		Vector vector = null;
		
		age = (Integer)in.readObject();
		weight = (double)in.readObject();
		message = (String)in.readObject();
		today = (Calendar)in.readObject();
		frame = (Frame)in.readObject();
		account = (Account)in.readObject();
		vector = (Vector<Account>)in.readObject();
		
		
		System.out.println(age);
		System.out.println(weight);
		System.out.println(message);
		System.out.println(today);
		System.out.println(frame);
		System.out.println(account);
		System.out.println(vector);
	}

}
