package test;

import java.awt.DisplayMode;
import java.util.Calendar;
import java.util.Date;


interface I {}
class A implements I {}
class B implements I {}
class C implements I {}

public class Test1 {
	
	public static void main(String[] args) {
//		String code = "code";
//		StringBuilder sb = new StringBuilder(code);
//		code = sb.reverse().toString();
//		System.out.println(code);
//		
//		char[] array = code.toCharArray();
//		for (int index = 0, mirroredIndex = array.length - 1; index < mirroredIndex; index++, mirroredIndex--) {    
//			char temp = array[index];    array[index] = array[mirroredIndex];    array[mirroredIndex] = temp;
//		}
//		
//		System.out.println(new String(array));
//		
//		final Date today = new Date();
//		final Calendar calendar = Calendar.getInstance();
//		calendar.set(1990, Calendar.NOVEMBER, 1, 0, 0, 0);
//		Date birthdate = calendar.getTime();
//		System.out.println(birthdate.toString());
//		System.out.println(calendar.toString());
//		System.out.println();
		
//		I[] array10 = new I[] { new A(), new B(), new C() };
//		
//		String name = "Margaret"; int eyeCount = 16; double height = 50.2; int legs = 9; int arms = 5;
//		System.out.println(name); 
//		System.out.println(eyeCount); 
//		System.out.println(height); 
//		System.out.println(legs); 
//		System.out.println(arms);
//		for(Object attribute : new Object[]{name, eyeCount, height, legs, arms})    
//		System.out.println(attribute);
//		for(double number : new double[]{eyeCount, legs, arms, height})    
//		System.out.println(Math.sqrt(number));
		Cat letsCat = new Cat();
		System.out.println(letsCat);
	}

}

class Cat {
	@Override
	public String toString() {
		return "CAT!";
	}
}

enum Season {
	WINTER,
	SPRING,
	SUMMER,
	FALL
}

class Day {
	private Season season;
	public String getSeason() {
		return season.name();
	}
	
	public static void display(Season s) {
		System.out.println(s.name());
	}
	
}

