package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<Integer>(), nums, target, 0);
		return list;

	}

	private static void backtrack(List<List<Integer>> list,
			ArrayList<Integer> arrayList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<Integer>(arrayList));
		else {
			for (int i = start; i < nums.length; i++) {
				if (i > start && nums[i] == nums[i - 1])
					continue; // skip duplicates
				arrayList.add(nums[i]);
				backtrack(list, arrayList, nums, remain - nums[i], i + 1);
				arrayList.remove(arrayList.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		int[] in={10,1,2,7,6,1,5};
		List<List<Integer>> result=combinationSum2(in, 8);
		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}
}
