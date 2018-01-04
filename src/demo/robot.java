package demo;

import java.util.Scanner;

public class robot {
	public static int robot(int n,int q){
		int ans=0;
		int[] dp=new int[n+1];
		int[] robot=new int[n+1];
		for (int j=0;j<=n;j++) {
			robot[j]=1;
		}
		for(int i=1;i<=n;i++){
			if((i-q)>0 && (dp[i-q-1]+robot[i-q-1]*2)>(dp[i-1]+robot[i-1])){
				dp[i]=dp[i-q-1]+robot[i-q-1]*2;
				robot[i]=robot[i-q-1]*2;
			}else{
				dp[i]=dp[i-1]+robot[i-1];
			}
			if(dp[i]>=n){
				ans=i;
				break;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println(robot(10, 1));
	}
}
