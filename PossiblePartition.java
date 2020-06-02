package coding.leetCode.mayChalange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class PossiblePartition {
	
	public static boolean bfs(LinkedList<Integer> adj[], int root, int N, int []colors) {
		
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(root);
		colors[root] = 0;
		while(!queue.isEmpty()) { 
			int curr = queue.poll();
			for(int i=0; i<adj[curr].size(); i++) {
				if(colors[curr] == colors[adj[curr].get(i)])
					return false;
				if(colors[adj[curr].get(i)] == -1) {
					colors[adj[curr].get(i)] = 1 - colors[curr];
					queue.add(adj[curr].get(i));
				}
			}
		}
		return true;
	}
	public static void main(String [] args) {
		int[][] dislikes = new int[][] {{1,2},{1,3},{2,4}};
		int n = 4;
		LinkedList<Integer> adjacencyList[] = new LinkedList[n+1];
		for(int i =0; i<=n; i++) {
			adjacencyList[i] = new LinkedList<Integer>();
		}
		
		for(int i=0; i<dislikes.length; i++) {
			adjacencyList[dislikes[i][0]].add(dislikes[i][1]);
			adjacencyList[dislikes[i][1]].add(dislikes[i][0]);
		}
		int colors[] = new int[n+1];
		for(int i=0; i<=n; i++)
			colors[i] = -1;
		boolean res = false;
		for(int i=1; i<dislikes.length; i++) {
			if(colors[dislikes[i][0]] == -1)
				if(bfs(adjacencyList, dislikes[i][0], n, colors) == false)
				{
					System.out.println("false");
					break;
				}
		}
		System.out.println("true");
	}
}
