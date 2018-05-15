package leetCode;

public class SingleElementinaSortedArray {
    public static int singleNonDuplicate(int[] nums){
        for(int i=0;i<nums.length-1;){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
            i+=2;
        }
        return nums[nums.length-1];
    }

    public static void main(String[] args) {
        int[] in={1,1,2};
        System.out.println(singleNonDuplicate(in));
    }
}
