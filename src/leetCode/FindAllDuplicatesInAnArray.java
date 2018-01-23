package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllDuplicatesInAnArray {
   /* Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

    Find all the elements that appear twice in this array.

    Could you do it without extra space and in O(n) runtime?

    Example:
    Input:
            [4,3,2,7,8,2,3,1]

    Output:
            [2,3]*/

//第一种方法不开辟额外的空间，
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
//    第二种，开辟额外的空间，而且效率很高
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int[] dp=new int[nums.length+1];
        for(int i=0;i<nums.length;i++){
            if(dp[nums[i]]!=0 ||(i>0 && nums[i]==nums[0]) ) result.add(nums[i]);
            else dp[nums[i]]=i;
        }
        return result;
    }
}
