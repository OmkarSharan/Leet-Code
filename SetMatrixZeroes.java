package coding.leetCode.mayChalange;

import java.util.HashMap;
import java.util.Map;

public class SetMatrixZeroes {
	public static void main(String [] args) {
		int [][]mat = new int[][] {
			{0,1,2,0},
			{3,4,5,2},
			{1,3,1,5}
		};
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(mat[i][j] == 0) {
					map.put(i, 1);
					map.put(j, 1);
				}
			}
		}
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				if(map.containsKey(i) || map.containsKey(j))
					mat[i][j] = 0;
			}
		}
		
		for(int i=0; i<mat.length; i++) {
			for(int j=0; j<mat[0].length; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
}
