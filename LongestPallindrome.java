package coding.leetCode.mayChalange;

public class LongestPallindrome {
	
	public static int[] pallindrome(String str, int i, int j) {
		int[] arr = new int[2];
		while(i >= 0 && j < str.length()) {
			if(str.charAt(i) == str.charAt(j)) {
				arr[0] = i;
				arr[1] = j;
			}else {
				break;
			}
			i--;
			j++;
		}
		return arr;
	}
	public static void main(String[] args) {
		String str = "aaaa";
		int len = Integer.MIN_VALUE;
		String sol= "";
		for(int i=0; i<str.length(); i++) {
			int [] arr1 = pallindrome(str, i, i);
			int [] arr2 = pallindrome(str, i, i+1);
			int len1 = arr1[1] - arr1[0]+1;
			int len2 = arr2[1] - arr2[0]+1;
			if(len < Math.max(len1, len2)) {
				len = Math.max(len1, len2);
				if(len == len1)
					sol = str.substring(arr1[0], arr1[1]+1);
				else
					sol = str.substring(arr2[0], arr2[1]+1);
			}
		}
		System.out.println(sol);

	}

}
