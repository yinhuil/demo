package cn.yinhui;

import java.util.Stack;

public class IncreasingTripletSubsequence {

	public boolean increasingTriplet(int[] nums) {
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= small) {
				small = n;
			} // update small if n is smaller than both
			else if (n <= big) {
				big = n;
			} // update big only if greater than small but smaller than big
			else
				return true; // return if you find a number bigger than both
		}
		return false;
	}
	public static boolean increasingTriplet2(int[] nums) {
		int min=Integer.MAX_VALUE;
		int max=Integer.MAX_VALUE;
		for (int i : nums) {
			if(i<min) min=i;
			else if(i<max) max=i;
			else return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		int[] in={1,2,3,4,5};
		System.out.println(increasingTriplet2(in));

	}

}
