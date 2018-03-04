package leetCode;

public class KthLargestElementInanArray {
/*    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
    For example,
    Given [3,2,1,5,6,4] and k = 2, return 5.*/
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,k-1,0,nums.length-1);
    }
    public static int quickSelect(int[] nums,int k,int left,int right){
        int mid=nums[(left+right)/2];
        int orgl=left,orgr=right;
        while (left<=right){
            while (nums[left]>mid){
                left++;
            }
            while (nums[right]<mid){
                right--;
            }
            if(left<=right){
                swap(nums,left,right);
                left++;
                right--;
            }
        }
        if(orgl<right && k<=right) return quickSelect(nums,k,orgl,right);
        if(left<orgr && k>=left) return  quickSelect(nums,k,left,orgr);
        return nums[k];
    }
    public static void swap(int[] nums,int idx1,int idx2){
        int temp=nums[idx1];
        nums[idx1]=nums[idx2];
        nums[idx2]=temp;
    }
}
