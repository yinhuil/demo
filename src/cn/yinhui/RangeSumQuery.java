package cn.yinhui;

public class RangeSumQuery {
	private static int[] dp;
	public static  void NumArray(int[] nums) {
		dp=new int[nums.length+1];
		dp[0]=0;
		for(int i=1;i<nums.length;i++){
			dp[i]=dp[i-1]+nums[i-1];
		}
	}

	public static int sumRange(int i, int j) {
		return dp[j+1]-dp[i];
	}

	public static void main(String[] args) {
		int[] in={-2, 0, 3, -5, 2, -1};
		NumArray(in);
		System.out.println(sumRange(0, 2));
	}

}
