package test;

import java.io.ObjectOutputStream.PutField;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

enum Day1 {
	GOOD, AVERAGE, WORST
}

enum Page {
	A1, A2, A3, A4, A5, A6, A7, A8, A9, A10
}

enum DayOfWeek {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
}

enum Fruit {
	APPLE, ORANGE, STRAWBERRY, BANANA, LEMON, GRAPE_FRUIT;
}

enum Example {
	ONE(1), TWO(2);
//	static Map<String, Integer> integers ;
	static Map<String, Integer> integers = new HashMap<>() ;
	
//	private Example(int value) {
//		integers.put(this.name(), value);
//	}
	
	private Example(int value) {
		putValue(this.name(), value);
	}
	
	private static void putValue(String name, int value) {
		if (integers==null) {
			integers = new HashMap<>();
		}
		
		integers.put(name, value);
	}
}
public class Test {
	int output;
	public static void main(String[] args) {
//		EnumSet<Page> range = EnumSet.range(Page.A1, Page.A5);
//		
//		if (range.contains(Page.A7)) {
//			System.out.println("Range contains A4");
//		}
//		
//		EnumSet<Page> of = EnumSet.of(Page.A1, Page.A5, Page.A3);
//		
//		if (of.contains(Page.A2)) {
//			System.out.println("Off contains A2");
//		}
//		
//		Day1 day = Day1.GOOD;
//		
//		if (day.equals(Day1.GOOD)) {
//			System.out.println("GOOD DAY!");
//		}
//		
//		System.out.println("-----");
//		if (day == Day1.GOOD) {
//			System.out.println("------");
//			System.out.println("Good Day!");
//		}
//		
//		String dayName = DayOfWeek.SUNDAY.name();
//		assert dayName.equals("SUNDAY");
//		
//		DayOfWeek dayWeek = DayOfWeek.valueOf(dayName);
//		assert dayWeek == DayOfWeek.SUNDAY;
		System.out.println(Fruit.BANANA.name());
		System.out.println(Fruit.GRAPE_FRUIT.toString());
		
	}

}
