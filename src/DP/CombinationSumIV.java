package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIV {

	public static int combinationSum4(int[] nums, int target) {
		if(nums==null ||target==0) return 0;
		int[] dp=new int[target+1];
		dp[0]=1;
		for(int i=0;i<=target;i++){
			for (int num : nums) {
				if(i+num<=target)
					dp[i+num]+=dp[i];
			}
		}
		return dp[target];
	}
	public static void main(String[] args) {
		int [] nums={1,2,3};
		System.out.println(combinationSum4(nums, 4));

	}

}
