package coding.leetCode.mayChalange;

public class RiverSize {
	public static int count = 1;
	public static boolean isSafe(int [][]mat, int i, int j) {
		if(i >=0 && i < mat.length && j >=0 && j<mat[0].length)
			return true;
		return false;
	}
	public static void dfs(int mat[][], boolean [][] isVisited, int i, int j) {
		isVisited[i][j] = true;
		int x[] = new int[] {0, 1};
		int y[] = new int[] {1, 0};
		if(i < 0 || i >= mat.length || j < 0 || j >= mat[0].length) return ;
		for(int k=0; k<2; k++) {
			if(isSafe(mat, i + x[k], j+y[k]) && mat[i+x[k]][j+y[k]] == 1 && !isVisited[i+x[k]][j+y[k]]) {
				isVisited[i+x[k]][j+y[k]] = true;
				count = count + 1;
				dfs(mat, isVisited, i+x[k], j+y[k]);
			}
		}
		return;
	}
	public static void main(String [] args) {
		int [][] mat = new int[][] {{1,0,1,1,0,0},
									{0,0,1,0,1,0},
									{0,0,1,0,1,0},
									{1,0,1,0,0,0},
									{1,0,0,1,1,1}};
		int row = mat.length;
		int col = mat[0].length;
		boolean isVisited[][] = new boolean[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				if(mat[i][j] == 1 && !isVisited[i][j]) {
					count = 1;
					dfs(mat, isVisited, i, j);
					System.out.println(count);
				}
			}
		}
	}
}
