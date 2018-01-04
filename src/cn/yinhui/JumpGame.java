package cn.yinhui;

public class JumpGame {

	public static boolean canJump(int[] nums) {
		int reach=nums[0];
		for(int i=1;i<nums.length-1 && reach>=i;i++){
			if(nums[i]+i>reach) reach=nums[i]+i;
		}
		return reach>=(nums.length-1)?true:false;
	}

	public static void main(String[] args) {
		int[] in={2,3,1,1,4};
		System.out.println(canJump(in));
	}

}
