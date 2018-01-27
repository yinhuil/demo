package leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthofPairChain {
  /*  You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

    Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

    Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

    Example 1:
    Input: [[1,2], [2,3], [3,4]]
    Output: 2
    Explanation: The longest chain is [1,2] -> [3,4]*/
//第一种方法，使用dp
  public int findLongestChain1(int[][] pairs) {
      if (pairs == null || pairs.length == 0) return 0;
      Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
      int lens=pairs.length;
      int[] dp=new int[lens];
      dp[0]=1;
      for(int i=1;i<lens;i++){
          dp[i]=dp[i-1];
          for(int j=0;j<i;j++){
              if(pairs[i][0]>pairs[j][1]) dp[i]=Math.max(dp[i],dp[j]+1);
          }
      }
      return dp[lens-1];
  }
//  第二种方法不使用dp
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                return Integer.compare(first[1], second[1]);
            }
        });
        int count = 0;
        int prev = -1;
        for (int i = 0; i < pairs.length; i++) {
            if (i == 0) {
                count++;
                prev = pairs[i][1];
            } else {
                if (pairs[i][0] > prev) {
                    prev = pairs[i][1];
                    count++;
                }
            }
        }
        return count;
    }
}
