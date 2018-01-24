package leetCode;

public class MaxAreaofIsland {
   /* Example 1:
            [[0,0,1,0,0,0,0,1,0,0,0,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,1,1,0,1,0,0,0,0,0,0,0,0],
            [0,1,0,0,1,1,0,0,1,0,1,0,0],
            [0,1,0,0,1,1,0,0,1,1,1,0,0],
            [0,0,0,0,0,0,0,0,0,0,1,0,0],
            [0,0,0,0,0,0,0,1,1,1,0,0,0],
            [0,0,0,0,0,0,0,1,1,0,0,0,0]]
    Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
            Example 2:
            [[0,0,0,0,0,0,0,0]]
    Given the above grid, return 0.*/
   public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,help(grid,i,j));
            }
        }
        return max;
   }
   public int help(int[][] grid,int inX,int inY){
       if(inX>=0 && inX<grid.length && inY>=0 && inY<grid[0].length && grid[inX][inY]==1){
           grid[inX][inY]=0;
           return 1+help(grid,inX+1,inY)+help(grid,inX-1,inY)+help(grid,inX,inY+1)+help(grid,inX,inY-1);
       }
       return 0;
   }
}
