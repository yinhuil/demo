package leetCode;

public class SpiralMatrixII {
  /*  Given an integer n, generate a square matrix filled with elements from 1 to
    n2 in spiral order.

            For example,
    Given n = 3,

    You should return the following matrix:
            [
            [ 1, 2, 3 ],
            [ 8, 9, 4 ],
            [ 7, 6, 5 ]
            ]*/
  public int[][] generateMatrix(int n) {
      int[][] matrix=new int[n][n];
      int colstart=0,colend=n-1,rowstart=0,rowend=n-1;
      int num=1;
      while(colstart<=colend && rowstart<=rowend){
          for(int i=rowstart;i<=rowend;i++){
              matrix[colstart][i]=num++;
          }
          colstart++;
          for(int i=colstart;i<=colend;i++){
              matrix[i][rowend]=num++;
          }
          rowend--;
          for(int i=rowend;i>=rowstart;i--){
              matrix[colend][i]=num++;
          }
          colend--;
          for(int i=colend;i>=colstart;i--){
              matrix[i][rowstart]=num++;
          }
          rowstart++;
      }
      return matrix;
  }
}
