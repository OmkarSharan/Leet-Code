package coding.leetCode.mayChalange;

public class SingleElementSortedList {
	
	public int ans=0;
	public int singleNonDuplicate(int[] nums) {
		int left = 0;
		int right = nums.length-1;
//		binarySearch(nums, left, right);
//		System.out.println(ans);
		return binaryS(nums, left, right);
	}


	private void binarySearch(int[] nums , int left, int right) {
		if(left <= right) {
			if(ans != 0) return;
			if(left == right) {
				ans = nums[left];
				return;
			}
			int mid = (left + right)/2;
			if(left + 1 == right && nums[left] == nums[right]) return; 
			if(mid-1 >=left && mid+1<= right && nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]) {
				ans = nums[mid];
				return;
			}
			if(mid - 1 >= left && nums[mid] == nums[mid-1]) {
				binarySearch(nums, left, mid-2);
			}
			if(mid-1 >= left && nums[mid] != nums[mid-1])
				binarySearch(nums, left, mid-1);
			if(mid + 1 <= right && nums[mid] == nums[mid+1]){ 
				binarySearch(nums, mid+2, right);
			}
			if(mid+1 <= right && nums[mid] != nums[mid+1])
				binarySearch(nums, mid+1, right);
		}
		return;
	}
	
	private static int binaryS(int nums[], int left, int right) {
		if(left == right)
			return nums[left];
		if(nums[left] != nums[left+1])
			return nums[left];
		if(nums[right] != nums[right-1])
			return nums[right];
		while(left <= right) {
			int mid = (left + right)/2;
			if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1])
				return nums[mid];
			if(mid%2 == 0 && nums[mid] == nums[mid+1] || mid %2 == 1 && nums[mid] == nums[mid-1])
				left = mid+1;
			else right = mid - 1;
		}
		return -1;
	}
}
