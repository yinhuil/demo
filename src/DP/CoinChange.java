package DP;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CoinChange {

	public static int coinChange(int[] coins, int amount) {
		if (amount < 1)
			return 0;
		int L = coins.length;
		int[] dp = new int[amount + 1];
		int sum = 0;
		// Modification.
		Arrays.sort(coins);
		while (++sum <= amount) {
			int min = -1;
			for (int coin : coins) {
				// Modification
				if (sum < coin) 
					break;
				if (dp[sum - coin] != -1) {
					int temp = dp[sum - coin] + 1;
					min = min < 0 ? temp : (temp < min ? temp : min);
				}
			}
			dp[sum] = min;
		}
		return dp[amount];
		
	}
	public static int coinChange1(int[] coins, int amount){
		if(amount<1) return 0;
		int[] dp=new int[amount+1];
		Arrays.sort(coins);
		for(int sum=1;sum<=amount;sum++){
			int min=-1;
			for (int coin : coins) {
				if(sum<coin) break;
				if(dp[sum-coin]!=-1){
					int temp=dp[sum-coin]+1;
					min=min<0?temp:(min<temp?min:temp);
				}
			}
			dp[sum]=min;
		}
		return dp[amount];
	}
	public static void main(String[] args) {
		 int[] in={1,2,5};
		 System.out.println(coinChange1(in, 11));
    
	}

}
