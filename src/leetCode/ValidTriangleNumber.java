package leetCode;

import java.util.Arrays;

public class ValidTriangleNumber {
 /*   Given an array consists of non-negative integers, your task is to count the number
    of triplets chosen from the array that can make triangles if we take them as side
    lengths of a triangle.
            Example 1:
    Input: [2,2,3,4]
    Output: 3
    Explanation:
    Valid combinations are:
            2,3,4 (using the first 2)
            2,3,4 (using the second 2)
            2,2,3*/
 public static int triangleNumber(int[] nums) {
     Arrays.sort(nums);
     int count=0,lens=nums.length-1;

     for(int i=lens;i>=2;i--){
         int start=0,end=i-1;
         while(start<end){
             if(nums[start]+nums[end]>nums[i]){
                 count+=end-start;
                 end--;
             }else start++;
         }
     }
     return count;
  }

    public static void main(String[] args) {
        int[] in={2,2,3,4};
        System.out.println(triangleNumber(in));
    }
}
