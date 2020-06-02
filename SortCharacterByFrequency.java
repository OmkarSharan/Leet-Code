package coding.leetCode.mayChalange;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharacterByFrequency {
	public static void main(String [] args) {
			String s = "Aabb";
			LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
	        for(Character c : s.toCharArray()){
	            if(!map.containsKey(c))
	                map.put(c, 1);
	            else{
	                int count = map.get(c);
	                map.put(c, count+1);
	             }
	        }
	        List<Entry<Character, Integer>> lst= new LinkedList<Map.Entry<Character,Integer>>(map.entrySet());
	        Collections.sort(lst, new Comparator<Map.Entry<Character, Integer>>() {
	
				@Override
				public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
					return (o2.getValue().compareTo(o1.getValue()));
				}
	        	
	        });
	        String str = "";
	        for(Map.Entry<Character, Integer> it : lst) {
	        	Character c = it.getKey();
	        	for(int i=1; i<=it.getValue(); i++) {
	        		str+=c;
	        	}
	        }
	        System.out.println(str);
		   }
}
