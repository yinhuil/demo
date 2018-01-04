package cn.yinhui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import edu.princeton.cs.algs4.In;
public class TargetSum494 {

	public static int findTargetSumWays(int[] nums, int S) {
		int sum=0;
		for (int i : nums) {
			sum+=i;
		}
		if(S>sum||S<-sum) return 0;
		int[] dp=new int[2*sum+1];
		dp[sum]=1;
		for(int j=0;j<nums.length;j++){
			int[] temp=new int[2*sum+1];
			for(int k=0;k<dp.length;k++){
				if(dp[k]!=0){
					temp[k+nums[j]]+=dp[k];
					temp[k-nums[j]]+=dp[k];
				}
			}
			dp=temp;
		}
		return dp[sum+S];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={1,1,1,1,1};
		System.out.println(findTargetSumWays(nums, 3));
	}

}
