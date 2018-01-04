package recover;

public class TargetSum {
	
	public static int findTargetSumWag(int[] nums,int s){
		int sum=0;
		for (int i : nums) {
			sum+=i;
		}
		if(s>sum||s<-sum) return 0;
		int[] dp=new int[2*sum+1];
		dp[sum]=1;
		for(int j=0;j<nums.length;j++){
			int[] temp=new int[2*sum+1];
			for(int k=0;k<dp.length;k++){
				if(dp[k]!=0){
					temp[k-nums[j]]+=dp[k];
					temp[k+nums[j]]+=dp[k];
				}
			}
			dp=temp;
		}
		return dp[sum+s];
	}
	public static void main(String[] args) {
		
	}
}
