package cn.yinhui;

import java.util.Arrays;
import java.util.Stack;

public class ExcelSheetColumnNumber {

	public static  int[] nextGreaterElements(int[] nums) {
		int len=nums.length;
		int[] ans=new int[len];
		int[] nums2=new int[2*len];
		for(int i=0;i<len;i++){
			nums2[i]=nums[i];
			nums2[len+i]=nums[i];
		}
		for(int j=0;j<len;j++){
			int index=j+1;
			while(index<2*len){
				if(nums2[index]>nums[j]){
					ans[j]=nums2[index];
					break;
				}
				index++;
			}
			if(index==2*len)
				ans[j]=-1;
		}
		return ans;
		
	}
	public static int[] nextGreaterElements1(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<Integer>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n]; 
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }   
        return next;
    }
	public static void main(String[] args) {
		int[] in={5,4,3,2,1};
		int[] ans=nextGreaterElements1(in);
		for ( int i : ans) {
			System.out.println(i);
		}
	}

}
