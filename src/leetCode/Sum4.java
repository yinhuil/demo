package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Sum4 {
  /*  Given an array S of n integers, are there elements a, b, c, and d in S such that
    a + b + c + d = target? Find all unique quadruplets in the array which gives the
    sum of target.

            Note: The solution set must not contain duplicate quadruplets.

    For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

    A solution set is:
            [
            [-1,  0, 0, 1],
            [-2, -1, 1, 2],
            [-2,  0, 0, 2]
            ]*/

//  先固定住前两个，然后在解决最后两个；
  public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        int lens=nums.length;
        if(nums==null ||nums.length<4) return result;
        Arrays.sort(nums);
        HashSet<List<Integer>> hash=new HashSet<>();
        for(int i=0;i<=lens-4;i++){
            for(int j=i+1;j<=lens-3;j++){
                for(int k=j+1,h=lens-1;k<h;){
                    int sum=nums[i]+nums[j]+nums[k]+nums[h];
                    if(sum<target){
                        k++; continue;
                    }
                    if(sum>target){
                        h--;continue;
                    }
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    temp.add(nums[h]);
                    if(!hash.contains(temp)){
                        hash.add(temp);
                        result.add(temp);
                    }
                    h--;
                    k++;

                }
            }
        }
        return result;

  }

}
