package coding.leetCode.mayChalange;

import java.net.Inet4Address;

public class CircularSubArraySum {
	public static int kadanes(int [] nums) {
		int max_sum = Integer.MIN_VALUE;
		int sum = 0, neg_count = 0;
		int neg_Number = Integer.MIN_VALUE;
		for(int i=0; i<nums.length; i++) {
			sum+=nums[i];
			if(sum < 0)
				sum = 0;
			if(max_sum < sum)
				max_sum = sum;
		}
		return max_sum;
	}
	public static int maxSubarraySumCircular(int[] A) {
	      int kdanesSum = kadanes(A);
	      int total_Sum=0, neg_count = 0, neg_num = Integer.MIN_VALUE;
	      for(int i=0; i<A.length; i++) {
	    	  total_Sum+=A[i];
	    	  if(A[i] < 0) {
	    		  if(neg_num < A[i])
	    			  neg_num = A[i];
	    		  
	    		  neg_count++;
	    	  }
	    	  A[i] = -A[i];
	      }
	      int circularSum = kadanes(A);
	      if(neg_count == A.length) return neg_num;
	      return kdanesSum > total_Sum +  circularSum ? kdanesSum:total_Sum +  circularSum;
    }
	public static void main(String [] args) {
		int [] nums = new int[]{-1, 40, -14, 7, 6, 5, -4, -1};
		System.out.println(maxSubarraySumCircular(nums));
	}
}
