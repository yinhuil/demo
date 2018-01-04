package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		List<Integer> list=new ArrayList<Integer>();
	    dfs(nums,target,result,list,0);
	    return result;
	}
	private static void dfs(int[] nums, int target, List<List<Integer>> result,
			List<Integer> list, int start) {
		if(target<0) return ;
		else if(target==0) result.add(new ArrayList<Integer>(list));
		else{
			for(int i=start;i<nums.length;i++){
				list.add(nums[i]);
				dfs(nums, target-nums[i], result, list, i);
				list.remove(list.size()-1);
			}
		}
		
	}
	public static void main(String[] args) {
		int[] in={2,3,6,7};
		combinationSum(in, 7);
	}
}
