package leetCode;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
  /*  Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
    The algorithm should run in linear time and in O(1) space.*/


//  解析：  最多也就不超过两个这样的数字，我们用两个数字来表示，因为首先会判断出现的第一个，所以肯定不会出现重复。
  public List<Integer> majorityElement(int[] nums) {
     List<Integer> result=new ArrayList<>();
     if(nums==null || nums.length==0) return result;
     int count1=0,count2=0;
     int val1=nums[0],val2=nums[0];
     for(int i=0;i<nums.length;i++){
         if(nums[i]==val1){
             count1++;
         }else if(nums[i]==val2){
             count2++;
         }else if(count1==0){
             val1=nums[i];
             count1++;
         }else if(count2==0){
             val2=nums[i];
             count2++;
         }else{
             count1--;
             count2--;
         }
     }
     count1=0;count2=0;
      for(int i=0;i<nums.length;i++){
          if(nums[i]==val1) count1++;
          else if(nums[i]==val2) count2++;
      }
      if(count1>nums.length/3) result.add(val1);
      if(count2>nums.length/3) result.add(val2);
      return result;
  }
}
