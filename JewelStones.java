package coding.leetCode.mayChalange;

import java.util.HashMap;
import java.util.Map;

public class JewelStones {
	
	public static int numJewelsInStones(String J, String S) {
        Map<Character, Integer> map = new HashMap();
        for(Character c : S.toCharArray()){
            if(map.get(c) == null)
                map.put(c, 1);
            else{
                int count = map.get(c);
                map.put(c, count+1);
            }
        }
        int ans = 0;
        for(Character c: J.toCharArray()){
            if(map.get(c)!= null)
                ans+=map.get(c);
        }
        return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(numJewelsInStones("aA","aAAbbbb"));
	}

}
