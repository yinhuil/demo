package cn.yinhui;

public class ClimbingStairs {
	public static  int climbStairs(int n) {
		int[] dp=new int[n];
		if(n<2) return 1;
		dp[0]=1;
		dp[1]=2;
		for(int i=2;i<n;i++){
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n-1];
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}

}
