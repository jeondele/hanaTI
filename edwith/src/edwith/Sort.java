package edwith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Sort {
	
	public static void sort(int[] arr) {
		HashMap<Integer, Integer> separate = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(separate.containsKey(arr[i])) {
				separate.put(arr[i], separate.get(arr[i])+1);
			} else {
				separate.put(arr[i], 1);
			}
		}
		
		List<Integer> list = new ArrayList<Integer>();
		Iterator<Integer> getKeys = separate.keySet().iterator();
		while(getKeys.hasNext()) {
			list.add(getKeys.next());
		}
		
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (separate.get(o1) == separate.get(o2)) {
					return o1 - o2;
				}
				return separate.get(o1) - separate.get(o2);
		}});
		
		for (Integer integer : list) {
			for (int i = 0 ; i < separate.get(integer); i ++) {
				System.out.println(integer);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] sample = {5, 2, 7, 1, 10000, 10000, 999, 999, 999, 888, 777, 234};
		sort(sample);
	}
}
