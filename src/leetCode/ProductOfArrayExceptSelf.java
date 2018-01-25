package leetCode;

public class ProductOfArrayExceptSelf {
  /*  Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Solve it without division and in O(n).

    For example, given [1,2,3,4], return [24,12,8,6]*/

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (n == 0)
            return res;

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int r = 1;
        for (int j = n - 2; j >= 0; j--) {
            r *= nums[j + 1];
            res[j] *= r;
        }
        return res;
    }
}
