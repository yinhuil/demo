package Algorithms;

public class activitySelector {
	public static int activity(int[] s,int [] f){
		int n=s.length-1;
		int[] dp=new int[s.length];
		dp[0]=0;
		for(int i=1;i<=n;i++){
			dp[i]=0;
			for(int j=0;j<i;j++){
				if(s[i]>=f[j]){
					dp[i]=Math.max(dp[i], dp[j]+1);
				}else{
					dp[i]=Math.max(dp[i], dp[j]);
				}
			}
		}
		return dp[n];
	}
	public static void greedy(int[]s,int[]f,int k,int n){
		int m=k+1;
		while((m<=n)&& (s[m]<=f[k])){
			m++;
		}
		if(m<=n){
			System.out.println(m);
			greedy(s, f, m, n);
		}else{
			return;
		}
	}
	public static void main(String[] args) {
		int[] s = { 0, 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int[] f = { 0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16 };
		// int ans=activity(s, f);
		greedy(s, f, 0, 11);
//		for (int i = 0; i < 11; i++) {
//			greedy(s, f, i, 11);
//			System.out.println("************");
//		}
	}
}
