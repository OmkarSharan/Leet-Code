package coding.leetCode.mayChalange;

import java.util.HashMap;
import java.util.Map;


public class TownJudge {
	
	
	public static void main(String []args) {
		int [][]trust = new int[][] {{1,3},{2,3}};
		int n = 3;
		System.out.println(findTownJudge(trust, n));
		System.exit(0);
	}

	private static int findTownJudge(int[][] trust, int n) {
		if(trust.length == 0) return 0;
		
		Map<Integer, Integer> keyValue = new HashMap<>();
		Map<Integer, Integer> valueKey = new HashMap<>();
		for(int i=0; i<trust.length; i++) {
			keyValue.put(trust[i][0], trust[i][1]);
			if(valueKey.get(trust[i][1]) == null)
				valueKey.put(trust[i][1], 1);
			else {
				int value = valueKey.get(trust[i][1]);
				valueKey.put(trust[i][1], value+1);
			}
		}
		
		int count = 0, candidateKey = 0;
		for(Map.Entry<Integer, Integer> entry : valueKey.entrySet()) {
			if(keyValue.get(entry.getKey()) == null) {
				count++;
				candidateKey = entry.getKey();
			}
		}
		if(count > 1) return -1;
		
		if(valueKey.get(candidateKey)!= null && valueKey.get(candidateKey)  == n-1)
			return candidateKey;
		return -1;
	}
}
