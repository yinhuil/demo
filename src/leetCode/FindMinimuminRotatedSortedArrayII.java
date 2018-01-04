package leetCode;

public class FindMinimuminRotatedSortedArrayII {
/*	Follow up for "Find Minimum in Rotated Sorted Array":
		What if duplicates are allowed?

		Would this affect the run-time complexity? How and why?
		Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

		Find the minimum element.

		The array may contain duplicates.*/
	public int findMin1(int[] nums) {
		int start = 0, end = nums.length - 1, mid = 0;
		while (nums[start] >= nums[end]) {
			if (end - start == 1) {
				mid = end;
				break;
			}
			mid = start + (end - start) / 2;
			if (nums[mid] == nums[start] && nums[mid] == nums[end]) {
				return minorder(nums, start, end);
			}
			if (nums[mid] >= nums[start]) {
				start = mid;
			} else {
				end = mid;
			}
		}
		return nums[mid];
	}

	private int minorder(int[] nums, int start, int end) {
		int min = nums[start];
		for (int i = start; i < end; i++) {
			min = Math.min(min, nums[i]);
		}
		return min;
	}
	
//	方法二
	public int findmin(int[] nums){
		int start=0,end=nums.length-1,mid=0;
		while(end>=start){
			mid=start+(end-start)/2;
			if(nums[mid]>nums[end]){
				start=mid+1;
			}else if(nums[mid]<nums[end]){
				end=mid;
			}else{
				end--;
			}
		}
		return nums[mid];
	}
}




















