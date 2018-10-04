package staticInheritance;

import java.util.stream.Stream;

public class check1 {
	public static void main(String[] args) {
		Stream<String> fruitStream = Stream.of("bananan", "apple",  "pear", "kiwi","orange");
		fruitStream.filter(s -> s.contains("a")).forEach(System.out::println);
		
	}
}
