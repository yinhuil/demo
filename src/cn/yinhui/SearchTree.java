package cn.yinhui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.BinaryRefAddr;

public class SearchTree {

	/**
	 * @param args
	 */
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		};
	}

	public static int[] in = new int[7];
	public static int i = 0;

	public static void tree(TreeNode root) {
		if (root != null) {
			tree(root.left);
			tree(root.right);
			in[i++] = root.val;
		}
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;
		TreeNode tree = help(nums, 0, nums.length - 1);
		return tree;
	}

	private static TreeNode help(int[] nums, int low, int high) {
		// TODO Auto-generated method stub
		if (low > high)
			return null;
		int mid = (low + high) >>> 1;
		TreeNode tn = new TreeNode(nums[mid]);
		tn.left = help(nums, low, mid - 1);
		tn.right = help(nums, mid + 1, high);
		return tn;
	}

	public static int diameterOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int s1 = binary(root.left);
		int s2 = binary(root.right);
		return s1 + s2 + 1;
	}

	public static int binary(TreeNode root) {
		if (root == null)
			return 0;
		int left = binary(root.left);
		int right = binary(root.right);
		return left >= right ? left + 1 : right + 1;
	}

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		return (left == 0 || right == 0) ? left + right + 1 : Math.min(left,
				right) + 1;
	}

	public static boolean isBalanced(TreeNode root) {
		return balanceHeight(root) >= 0;
	}

	private static int balanceHeight(TreeNode root) {
		if (root == null)
			return 0;
		int left = balanceHeight(root.left);
		int right = balanceHeight(root.right);
		if (left < 0 || right < 0 || Math.abs(left - right) > 1)
			return -1;
		return Math.max(left, right) + 1;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(0);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(5);
		TreeNode node7 = new TreeNode(6);
		TreeNode node8 = new TreeNode(7);

		node1.left = node2;
		node1.right = node3;
		node1.left.left = node4;
		node1.left.right = node5;
		node1.right.left = node6;
		node1.right.right = node7;
		node1.left.left.left = node8;

		System.out.println(isBalanced(node1));

	}

}
