package edwith;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class jaeheok {

	   public static void  bbamSort(int [] arrBbam){
	      LinkedHashMap<Integer, Integer> sort = new LinkedHashMap<Integer,Integer>();
	      LinkedHashMap<Integer, Integer> temp = new LinkedHashMap<Integer,Integer>();
	      Arrays.sort(arrBbam);
	      
	      for(int a : arrBbam){
	         if(sort.containsKey(a)){
	            int ct = sort.get(a)+1;
	            sort.put(a, ct);
	         }else
	            sort.put(a, 1);
	      }
	      int [] bbamSort = new int[arrBbam.length];
	      int idx = 0;
	      int freq = 1;
	      Iterator<Integer> iteratorKey = sort.keySet().iterator();

	      while (true) {
	         Integer key = iteratorKey.next();
	         if(sort.get(key) == freq){
	            for(int i = 0; i< freq ; i++){
	               bbamSort[idx] = key;
	               idx++;
	            }
	            if(idx == arrBbam.length){
	               break;
	            }
	         }else{
	            temp.put(key, sort.get(key));
	         }
	         
	         if(!(iteratorKey.hasNext())){
	            iteratorKey = temp.keySet().iterator();
	            temp = new LinkedHashMap<Integer,Integer>();
	            freq++;
	         }
	      }
	      
	      for(int i : bbamSort){
	         System.out.println(i);
	      }
	   }
	   
	   public static void main(String[] args){
	      int[] arrBbam = {5,2,7,1,10000,10000,999,999, 999, 888,777,234}; 
	      bbamSort(arrBbam);
	   }

}
