package leetCode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
 /*   Given an unsorted array of integers, find the length of longest increasing subsequence.

    For example,
    Given [10, 9, 2, 5, 3, 7, 101, 18],
    The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

    Your algorithm should run in O(n2) complexity.*/
     public static int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
         if(nums.length==0||nums==null) return 0;
         int res=1;
         Arrays.fill(dp,1);
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]+1);
            }
            res=Math.max(dp[i],res);
        }
        return res;
     }

    public static void main(String[] args) {
        int[] in={10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(in));
    }

}
