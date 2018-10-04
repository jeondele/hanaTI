import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {
	
	//key랑 value 쌍으로 저장하는 가장 유명한 구조
	//hashmap은 비동기, hashtable은 동기화 되어있다
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("680313", "김기정");
		map.put("680313", "김기정"); //같은 키가 있을 때는 덮어 씌운다.
		map.put("690313", "이기정");
		map.put("700313", "박기정");
		
		if(map.containsKey("680313")) {
			System.out.println("존재하는 키입니다...");
		} else {
			map.put("710313", "최기정");
		}
		System.out.println(map.get("680313"));
		
		Set<String> keyList = map.keySet(); //key 저장 목록 반환
		
		for (String key : keyList) {
			System.out.println(key);
		}
		
		Collection<String> values = map.values();
		for (String string : values) {
			
		}
	}

}
