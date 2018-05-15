package leetCode;

import java.util.Arrays;

public class JumpGameII {
   /* Given an array of non-negative integers, you are initially positioned at the first index of the array.

    Each element in the array represents your maximum jump length at that position.

    Your goal is to reach the last index in the minimum number of jumps.

    Example:

    Input: [2,3,1,1,4]
    Output: 2
    Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.*/
   public static int jump(int[] nums) {
        int lens=nums.length;
        int[] dp=new int[lens];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=0;i<nums.length;i++){
            dp[i]=Math.min(dp[i],i);
            for(int j=1;j<=nums[i] &&(j+i)<lens;j++){
                dp[j+i]=Math.min(dp[j+i],dp[i]+1);
            }
        }
        return dp[lens-1];
   }
   public static int jump2(int[] nums){
       int cur=0,last=0,count=0;
       for(int i=0;i<nums.length;i++){
           if(i>last){
               last=cur;
               count++;
           }
           cur=Math.max(cur,i+nums[i]);
       }
       return count;
   }
    public int jump3(int[] nums){
        int step = 0;
        for(int l = 0, r = 0; r < nums.length - 1; step++){
            int rNew = 0;
            for(int i = l; i <= r; i++) rNew = Math.max(rNew, i + nums[i]);
            l = r + 1;
            r = rNew;
        }
        return step;
    }

    public static void main(String[] args) {
        int[] in={2,3,1,1,4};
        System.out.println(jump2(in));
    }
}
