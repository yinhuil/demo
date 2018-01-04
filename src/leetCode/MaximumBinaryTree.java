package leetCode;

public class MaximumBinaryTree {
//题目
/*	Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

		The root is the maximum number in the array.
		The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
		The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
		Construct the maximum tree by the given array and output the root node of this tree.

		Example 1:
		Input: [3,2,1,6,0,5]
		Output: return the tree root node representing the following tree:

		      6
		    /   \
		   3     5
		    \    / 
		     2  0   
		       \
		        1
		Note:
		The size of the given array will be in the range [1,1000]*/
//解题思路： 每一次寻找最大值，然后他的左边就是左子树，右边就是右子树
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x){
			val=x;
		}
	}
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		if(nums.length==0) return null;
		return help(nums,0,nums.length-1);
	}
	private TreeNode help(int[] nums, int start, int end) {
		if(start>end){
			return null;
		}
		int temp=start;
		for(int i=start+1;i<=end;i++){
			if(nums[i]>nums[temp]){
				temp=i;
			}
		}
		TreeNode result=new TreeNode(nums[temp]);
		result.left=help(nums, start, temp-1);
		result.right=help(nums, temp+1, end);
		return result;
		
	}

}
