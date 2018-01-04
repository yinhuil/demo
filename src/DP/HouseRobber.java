package DP;

import java.util.Arrays;

public class HouseRobber {

	public static int rob(int[] num) {
		if(num.length==0) return 0;
		if(num.length==1) return num[0];
		if(num.length==2) return Math.max(num[0], num[1]);
		if(num.length==3) return Math.max(num[0], Math.max(num[1], num[2]));
		return Math.max(rob1(Arrays.copyOfRange(num, 1, num.length)),
				num[0]+ rob1(Arrays.copyOfRange(num, 2, num.length-1)));
	}
	


	private static int rob1(int[] nums) {
		int[] dp=new int[nums.length+1];
		dp[1]=nums[0];
		for(int i=2;i<=nums.length;i++){
			dp[i]=Math.max(dp[i-1], dp[i-2]+nums[i-1]);
		}
		return dp[nums.length];
	}



	public static void main(String[] args) {
		int[] in={1,7,9,2};
		int[] ne=Arrays.copyOfRange(in, 2, in.length-1);
		for (int  i : ne) {
			System.out.println(i);
		}

	}

}
