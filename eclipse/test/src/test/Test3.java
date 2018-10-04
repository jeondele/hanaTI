package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test3 {
	
	public static void aa(int a) {
		
	}
	
	public static void aa() {}
	
	public static void main(String[] args) {
		String[] names = { "john", "darin", "bauke", "hans", "marc" };
		IntStream.range(0, names.length) 
				 .mapToObj(k -> String.format("#%d %s", k +1, names[k]))
				 .forEach(System.out :: println);
		
		Collection<String> abc = Arrays.asList("a", "b", "c");
		Collection<String> digits = Arrays.asList("1", "2", "3");
		
		System.out.println();
		
//		Stream<String> concat = Stream.concat(abc.stream(), digits.stream());
//		concat.forEach(System.out::print);;
//		
//		Stream<String> concat3 = Stream.of(abc.stream(), digits.stream()).flatMap(s->s);
//		
//		System.out.println(concat3.collect(Collectors.joining(", ")));
	}
}
