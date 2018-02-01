package leetCode;

public class KthSmallestElementInASortedMatrix {
   /* Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

    Note that it is the kth smallest element in the sorted order, not the kth distinct element.

    Example:

    matrix = [
            [ 1,  5,  9],
            [10, 11, 13],
            [12, 13, 15]
            ],
    k = 8,

            return 13*/
   public static int kthSmallest(int[][] matrix, int k) {
      int m=matrix.length,n=matrix[0].length;
      int lo=matrix[0][0],hi=matrix[m-1][n-1];
      while(lo<hi){
         int mid=lo+(hi-lo)/2;
         int count=0,j=n-1;
         for(int i=0;i<m;i++){
            while(j>=0&&matrix[i][j]>mid) j--;
            count+=j+1;
         }
         if(count<k) lo=mid+1;
         else hi=mid;
      }
      return lo;
   }

   public static void main(String[] args) {
      int[][] in={{1,  5,  9},{10, 11, 13},{12, 13, 15}};
      System.out.println(kthSmallest(in,8));
   }
}
