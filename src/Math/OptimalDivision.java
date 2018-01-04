package Math;

public class OptimalDivision {

	public static String optimalDivision(int[] nums) {
		String ans="";
		if(nums.length==1) return ans+nums[0];
		if(nums.length==2) return ans+nums[0]+"/"+nums[1];
		ans=ans+nums[0]+"/(";
		for(int i=1;i<nums.length-1;i++)
			ans=ans+nums[i]+"/";
		ans+=nums[nums.length-1]+")";
		return ans;
	}
	public static void main(String[] args) {
		int[] in ={1,2,3};
		System.out.println(optimalDivision(in));
		

	}

}
