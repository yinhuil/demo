package leetCode;

public class LongestIncreasingSubsequence {
 /*   Given an unsorted array of integers, find the length of longest increasing subsequence.

    For example,
    Given [10, 9, 2, 5, 3, 7, 101, 18],
    The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

    Your algorithm should run in O(n2) complexity.*/
     public int lengthOfLIS(int[] nums) {
         if(nums.length==0 ||nums==null) return 0;
        int result=1;
        int temp=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>temp){
                result+=1;
                temp=nums[i];
            }else {
                count=Math.max(result,count);
                temp=nums[i];
            }
        }
        return count;

     }
}
