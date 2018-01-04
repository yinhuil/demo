package leetCode;

public class NumberofIslands {

	/*
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
	 * islands. An island is surrounded by water and is formed by connecting
	 * adjacent lands horizontally or vertically. You may assume all four edges
	 * of the grid are all surrounded by water.
	 * 
	 * Example 1:
	 * 
	 * 11110 11010 11000 00000 Answer: 1
	 * 
	 * Example 2:
	 * 
	 * 11000 11000 00100 00011 Answer: 3
	 */
	public static int numIslands(char[][] grid) {
		int num=0;
		if(grid.length==0) return 0;
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[0].length;j++){
				if(grid[i][j]=='1'){
					help(grid,i,j);
					num++;
				}
			}
		}
		return num;
	}

	private static  void help(char[][] grid, int i, int j) {
		if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0') return;
		grid[i][j]='0';
		help(grid, i, j+1);
		help(grid, i, j-1);
		help(grid, i+1, j);
		help(grid, i-1, j);
	}
	public static void main(String[] args) {
		char[][] ch={{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		System.out.println(numIslands(ch));
	}
}
