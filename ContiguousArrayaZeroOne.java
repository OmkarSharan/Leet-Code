package coding.leetCode.mayChalange;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArrayaZeroOne {
	public static void main(String [] args) {
		int [] arr = new int[] {0,1,1,0,1};
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int count = 0;
		int maxLen = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0)
				count++;
			else if(arr[i] == 1)
				count--;
			if(map.containsKey(count))
				maxLen = Math.max(maxLen, i - map.get(count));
			else
				map.put(count, i);
		}
		System.out.println(maxLen);
	}
}
