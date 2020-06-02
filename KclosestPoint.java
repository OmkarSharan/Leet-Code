package coding.leetCode.mayChalange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KclosestPoint {
	
	public static int[][] kClosest(int[][] points, int K) {
        Map<int[][], Double> map = new HashMap<>();
        for(int i=0; i<points.length; i++){
            double distance = Math.sqrt(points[i][0] * points[i][0] + points[i][1] * points[i][1]);
            int[][] arr = new int[1][2];
            arr[0][0] = points[i][0];
            arr[0][1] = points[i][1];
            map.put(arr, distance);
        }
        List<Map.Entry<int[][], Double>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<int[][], Double>>() {

			@Override
			public int compare(Entry<int[][], Double> o1, Entry<int[][], Double> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
        
        int sol[][] = new int[K][2];
        int i = 0;
        for(Map.Entry<int[][], Double> itr : list){
        	if(K == 0) break;
            sol[i][0] = itr.getKey()[0][0];
            sol[i][1] = itr.getKey()[0][1];
            K--;
            i++;
        }
        return sol;
    }
	public static void main(String [] args) {
		int[][] points = new int[][] {{1,0}, {0,1}};
		int k = 2;
		int sol[][] = kClosest(points, k);
		for(int i=0; i<k; i++)
			System.out.println(sol[i][0] +" "+ sol[i][1]);
	}
}
