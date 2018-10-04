package test;

import java.util.HashMap;
import java.util.Map;

public class forEach {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap <Integer, String>();
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.replaceAll((key, value) -> key + "10");
		map.forEach((key,value) -> System.out.println("KEY : " + key + " :: Value : " + value));
	}
}
