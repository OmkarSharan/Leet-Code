package coding.leetCode.mayChalange;

public class FloodFill {
	public static boolean isSafe(int[][] image, int row, int col) {
		if(row >= image.length || col>=image[0].length || row < 0 || col < 0) return false;
		return true;
	}
	
	public static int[][]floodFill(int[][] image, int sr, int sc, int newColor, int existingColor, boolean [][]visited){
        int x[] = new int[] {1, -1, 0, 0};
        int y[] = new int[] {0, 0, 1, -1};
         visited[sr][sc] = true;
        
        for(int i = 0; i<4; i++) {
        	if(isSafe(image, sr+x[i], sc+y[i]) && !visited[sr+x[i]][sc+y[i]]&& image[sr+x[i]][sc+y[i]] == existingColor) {
        		image[sr+x[i]][sc+y[i]] = newColor;
        		floodFill(image, sr+x[i], sc+y[i], newColor, existingColor, visited);
        	}
        }
        image[sr][sc] = newColor;
        return image;
    }
	public static void main(String []args) {
		int [][] image = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
		boolean [][] visited = new boolean [image.length][image[0].length];
		int [][]res = floodFill(image, 1,1,2, image[1][1], visited);	
		for(int i=0; i<image.length; i++) {
			for(int j=0; j<image[0].length; j++)
				System.out.print(res[i][j]+" ");
			System.out.print("\n");
		}
		
		
	}
}
