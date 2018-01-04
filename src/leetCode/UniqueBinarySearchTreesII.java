package leetCode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
/*	Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.

	For example,
	Given n = 3, your program should return all 5 unique BST's shown below.

	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3*/
	static class TreeNode{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x){
			val=x;
		}
	}

	public static List<TreeNode> generateTrees(int n) {
		if (n == 0)
			return new ArrayList<TreeNode>();
		return genTreeList(1, n);
	}

	private static List<TreeNode> genTreeList(int start, int end) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (start > end) {
			list.add(null);
		}
		for (int idx = start; idx <= end; idx++) {
			List<TreeNode> leftList = genTreeList(start, idx - 1);
			List<TreeNode> rightList = genTreeList(idx + 1, end);
			for (TreeNode left : leftList) {
				for (TreeNode right : rightList) {
					TreeNode root = new TreeNode(idx);
					root.left = left;
					root.right = right;
					list.add(root);
				}
			}
		}
		return list;
	}
	public static void main(String[] args) {
		System.out.println(generateTrees(3));
	}
}
