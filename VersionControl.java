package coding.leetCode.mayChalange;

import java.util.Map;

public class VersionControl {
	public static int k = 1702766719;
	public static Boolean isBadVersion(int n) {
		if(n < k)
			return false;
		return true;
	}
	public static int checkBadVersion(int left, int right){
        long badVesrion = 0;
        long l = left;
        long r = right;
        while(l <= r){
            long mid = (l + r)/2;
            if(isBadVersion((int)mid)){
                badVesrion = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return (int)badVesrion;
    }
	
	public static void main(String [] args) {
		System.out.println(checkBadVersion(1, 2126753390));
	}
}
