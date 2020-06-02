package coding.leetCode.mayChalange;

import java.util.ArrayList;
import java.util.List;


public class ListIntersection {
	public static int[][] intervalIntersection(int[][] A, int[][] B) {
        //int[][] solution = new int[A.length*B.length][2];
        List<int[][]> solution = new ArrayList<>();
        int k=0;
        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int[][] inner = new int[1][2];
                if(B[j][0] > A[i][1])
                    break;
                else if(B[j][0] <= A[i][0] && A[i][0] <= B[j][1]){
                    inner[0][0]=A[i][0];
                    inner[0][1]=B[j][1];
                    solution.add(inner);
                }
                else if(B[j][0] >= A[i][0] && B[j][0] <= A[i][1]){
                    inner[0][0] = B[j][0];
                    inner[0][1] = A[i][1];
                    solution.add(inner);
                } 
               
            }
        }
        int array[][] = new int[solution.size()][2];
        for(int i=0; i<solution.size(); i++) {
        	int[][] arr = solution.get(i);
        	array[i][0] = arr[0][0];
        	array[i][1] = arr[0][1];
        }
        return array;
    }
	public static void main(String[] args) {
		int [][]A = new int[][] {{0,2},{5,10},{13,23},{24,25}};
		int [][]B = new int[][] {{1,5},{8,12},{15,24},{25,26}};
	    System.out.println(intervalIntersection(A, B));
	}
}
