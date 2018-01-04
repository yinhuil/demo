package leetCode;

public class FindMinimuminRotatedSortedArray {
/*	Suppose an array sorted in ascending order is rotated at some pivot unknown 
 * to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

	Find the minimum element.

	You may assume no duplicate exists in the array.*/
//	本道题是没有重复的
	public static int findMin(int[] nums) {
		int start=0,end=nums.length-1;
		int mid=0;
		while(nums[start]>nums[end]){
			if(end-start==1){
				mid=end;
				break;
			}
			mid=start+(end-start)/2;
			if(nums[mid]>nums[start]){
				start=mid;
			}else{
				end=mid;
			}
		}
		return nums[mid];
	}
	public static void main(String[] args) {
		int[] in={4,5,6,7,0,1,2};
		System.out.println(findMin(in));
	}
}
