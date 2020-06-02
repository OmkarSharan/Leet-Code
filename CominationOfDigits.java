
 package coding.leetCode.mayChalange;

import java.util.ArrayList;
import java.util.List;

public class CominationOfDigits {

	public static void swap(int[] str, int start, int end) {
		int temp = str[start];
		str[start] = str[end];
		str[end] = temp;
	}
	
	public static void pemutation(int[] str, int start, int end) {
		if(start > end) return;
		if(start == end) {
			for(int i=0; i<str.length; i++)
				System.out.print(str[i]);
			System.out.println("\n");
			return;
		}
		for(int i=start; i<=end; i++) {
			swap(str, start, i);
			pemutation(str, start+1, end);
			swap(str, start, i);
		}
		
		return;
	}
	public static void main(String[] args) {
		int arr[] =new int[] {1,2,3};
		List<List<Integer>> sol =new ArrayList<List<Integer>>();
		pemutation(arr, 0, arr.length-1);
	}

}
