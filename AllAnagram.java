package coding.leetCode.mayChalange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagram {

	public static void main(String[] args) {
		String s = "abab";
		String p = "ab";
		int [] mapPattern = new int[257];
		int [] countAnagram = new int[257];
		List<Integer> anagrams = new ArrayList<>();
		for(int i=0; i<p.length(); i++) {
			mapPattern[p.charAt(i)]++;
			countAnagram[s.charAt(i)]++;
		}
		for(int i = p.length(); i<s.length(); i++) {
			if(checkForAnagram(mapPattern, countAnagram)) {
				anagrams.add(i - p.length());
			}
			countAnagram[s.charAt(i)]++;
			countAnagram[s.charAt(i-p.length())]--;
		}
		if(checkForAnagram(mapPattern, countAnagram))
			anagrams.add(s.length() - p.length());
		System.out.println(anagrams);

	}

	private static boolean checkForAnagram(int[]mapPattern, int[] countAnagram) {
		for(int i=0; i<=256; i++) {
			if(mapPattern[i] != countAnagram[i])
				return false;
		}
		return true;
	}

}
