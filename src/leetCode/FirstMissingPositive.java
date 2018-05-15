package leetCode;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i]==i+1||nums[i]<=0 ||nums[i]>nums.length) i++;
            else if(nums[i]!=nums[nums[i]-1]) swap(nums,i,nums[i]-1);
            else i++;
        }
        int start=0;
        while(start<nums.length && nums[start]==start+1) start++;
        return start+1;
    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] in={};
        System.out.println(firstMissingPositive(in));
    }
}
