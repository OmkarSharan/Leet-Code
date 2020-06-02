package coding.leetCode.mayChalange;

public class LongestRepeatingReplacement {
	public static int characterReplacement(String s, int k) {
		 int hash[] = new int[26];
		 int wstart = 0;
		 int maxLen = Integer.MIN_VALUE;
		 int uniqueCharLen = 0;
		 for(int wend = 0; wend<s.length(); wend++) {
			 char c = s.charAt(wend);
			 hash[c - 'A']++;
			 uniqueCharLen = Math.max(uniqueCharLen, hash[c-'A']);
			 if(wend - wstart + 1 - uniqueCharLen > k) {
				 hash[s.charAt(wstart) - 'A']--;
				 wstart++;
			 }
			 maxLen = Math.max(maxLen, wend - wstart + 1);
		 }
		 return maxLen;
	        
	}
	
	 public static int longestOnes(int[] A, int K) {
	        int wstart = 0;
	        int maxCount = 0;
	        int hash[] = new int[3];
	        int consecutiveUniqueOne = 0;
	        for(int wend =0; wend < A.length; wend++){
	            hash[A[wend]]++;
	            consecutiveUniqueOne = Math.max(consecutiveUniqueOne, hash[A[wend]]);
	            if(wend - wstart + 1 - consecutiveUniqueOne > K){
	                hash[A[wstart]]--;
	                wstart++;
	            }
	            maxCount = Math.max(maxCount, wend-wstart+1);
	        }
	        return maxCount;
	}
	public static void main(String[] args) {
//		String str = "BAAA";
//		
//		int k = 0;
//		System.out.println(characterReplacement(str, k));
		int [] arr = new int[] {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		
		System.out.println(longestOnes(arr, k));
	}
}
