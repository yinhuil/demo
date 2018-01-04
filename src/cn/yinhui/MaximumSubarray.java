package cn.yinhui;

import java.util.Stack;

public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		 int[] dp=new int[nums.length];
		 dp[0]=nums[0];
		 int sum=Integer.MIN_VALUE;
		 for(int i=1;i<nums.length;i++){
			 dp[i]=nums[i]+(dp[i-1]<0? 0:dp[i-1]);
			 sum=Math.max(sum, dp[i]);
		 }
		 return sum;
	}
	public static int maxconsist(int[] nums){
		int n=nums.length;
		int[] dp=new int[n];
		int sum=1;
		dp[0]=1;
		for(int i=1;i<n;i++){
			dp[i]=nums[i]>nums[i-1]?dp[i-1]+1:1;
			sum=Math.max(sum, dp[i]);
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] in={5,3,4,8,6,7};
		System.out.println(maxconsist(in));
	}

}
