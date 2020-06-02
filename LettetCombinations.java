package coding.leetCode.mayChalange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LettetCombinations {
		static List<String> solution = new ArrayList<>();
		static Map<Character, String> map = new HashMap<>();
		static {
	        map.put('2', "abc");
	        map.put('3', "def");
	        map.put('4', "ghi");
	        map.put('5', "jkl");
	        map.put('6', "mno");
	        map.put('7', "pqrs");
	        map.put('8', "tuv");
	        map.put('9', "wxyz");
		}
	    public static void getCobination(String combinations, String digits){
	       if(digits.length() == 0) {
	    	   solution.add(combinations);
	       }else {
	    	   char digit = digits.charAt(0);
	    	   String str = map.get(digit);
	    	   for(int i=0; i<str.length(); i++) {
	    		   getCobination(combinations + str.charAt(i), digits.substring(1));
	    	   }
	       }
	    }
	    @SuppressWarnings("unlikely-arg-type")
		public static List<String> letterCombinations(String digits) {
	       String cobinations = "";
	       getCobination(cobinations, digits);
	       return solution;
	    }
	    
	    public static void main(String [] args) {
	    	String digits = "23";
	    	System.out.println(letterCombinations(digits));
	    }
}
