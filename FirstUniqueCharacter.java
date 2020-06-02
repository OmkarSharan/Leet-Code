package coding.leetCode.mayChalange;

import java.util.HashMap;
import java.util.Map;

class Pair{
	int index;
	int count;
	Pair(int index, int count){
		this.index = index;
		this.count = count;
	}
}
public class FirstUniqueCharacter {
	public static void main(String[] args) {
		String s = "geeksforgeeks";
		HashMap<Character, Pair> map = new HashMap<>();
		int i = 0;
		for(Character c : s.toCharArray()) {
			if(map.get(c) == null) {
				Pair p = new Pair(i, 0);
				map.put(c, p);
			}else {
				Pair p = map.get(c);
				p.count++;
				p.index = i;
				map.put(c, p);
			}
			i++;
		}
		
		Character uniqCharacter = null;
		int minIndex = Integer.MAX_VALUE;
		
		for(Map.Entry<Character, Pair> itr : map.entrySet()) {
			Pair p = itr.getValue();
			if(p.count == 0 && minIndex > p.index) {
				minIndex = p.index;
				uniqCharacter = itr.getKey();
			}
		}
		System.out.println(uniqCharacter);
	}
}
