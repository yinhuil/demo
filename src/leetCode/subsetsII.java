package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public class subsetsII {
/*    Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

    Note: The solution set must not contain duplicate subsets.

    Example:

    Input: [1,2,2]
    Output:
            [
            [2],
            [1],
            [1,2,2],
            [2,2],
            [1,2],
            []
            ]*/
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(nums.length==0||nums==null) return result;
        Arrays.sort(nums);
        help(nums,result,list,0);
        return result;
    }
    public static void help(int[]nums,List<List<Integer>> result,List<Integer> list,int start){
        if(start<=nums.length) result.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            help(nums,result,list,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] in={1,2,2};
        List<List<Integer>> list=subsetsWithDup(in);
        for (List<Integer> i:list
             ) {
            System.out.println(i);

        }
    }
}
