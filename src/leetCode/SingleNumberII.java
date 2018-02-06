package leetCode;

public class SingleNumberII {
/*    Given an array of integers, every element appears three
    times except for one, which appears exactly once. Find that single one.*/

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int i = 0; i < nums.length; i++){
            ones = (ones ^ nums[i]) & ~twos;
            twos = (twos ^ nums[i]) & ~ones;
        }
        return ones;
    }

    public static void main(String[] args) {
        int[] in={3,3,3};
        System.out.println(singleNumber(in));
    }
}
