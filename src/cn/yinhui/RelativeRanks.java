package cn.yinhui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RelativeRanks {

	public static String[] findRelativeRanks(int[] nums) {
		int[] rank=nums.clone();
		Arrays.sort(rank);
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int j=0;j<rank.length;j++){
			map.put(rank[j], rank.length-j);
		}
		String[] ans=new String[nums.length];
		for(int i=0;i<nums.length;i++){
			int temp=map.get(nums[i]);
			if(temp==1) ans[i]="Gold Medal";
			else if(temp==2) ans[i]="Silver Medal";
			else if(temp==3) ans[i]="Bronze Medal";
			else{
				ans[i]=temp+"";
			}
		}
		return ans;
		
	}
	public static void main(String[] args) {
		int[] in={5,4,3,2,1};
		String[] ans=findRelativeRanks(in);
		for (String string : ans) {
			System.out.println(string);
		}
	}

}
