package leetCode;

public class SearchforARange {
	/*Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

	Your algorithm's runtime complexity must be in the order of O(log n).

	If the target is not found in the array, return [-1, -1].

	For example,
	Given [5, 7, 7, 8, 8, 10] and target value 8,
	return [3, 4].*/
//	第一种复杂度太高
	public int[] searchRange(int[] nums, int target) {
		int first=findFirst(nums,target,0,nums.length-1);
		int last=findLast(nums,target,0,nums.length-1);
		int[] result={first,last};
		return result;
	}

	private int findLast(int[] nums, int target, int start, int end) {
		if(start>end)return -1;
		int mid=start+(end-start)/2;
		if(nums[mid]==target){
			if(mid==end||nums[mid+1]>target){
				return mid;
			}else{
				start=mid+1;
			}
		}else if(nums[mid]>target){
			end=mid-1;
		}else{
			start=mid+1;
		}
		return findLast(nums, target, start, end);
	}

	private int findFirst(int[] nums, int target, int start, int end) {
		if(start>end) return -1;
		int mid=start+(end-start)/2;
		if(nums[mid]==target){
			if(mid==start||nums[mid-1]<target){
				return mid;
			}else{
				end=mid-1;
			}
		}else if(nums[mid]>target){
			end=mid-1;
		}else {
			start=mid+1;
		}
		return findFirst(nums, target, start, end);
	}

	
}
