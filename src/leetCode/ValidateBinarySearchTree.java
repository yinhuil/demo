package leetCode;

import java.util.Stack;

public class ValidateBinarySearchTree {
  /*  Given a binary tree, determine if it is a valid binary search tree (BST).

    Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.
    Example 1:
            2
            / \
            1   3
    Binary tree [2,1,3], return true.
    Example 2:
            1
            / \
            2   3
    Binary tree [1,2,3], return false.*/
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
  }
//  第一种方法，采用非递归
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> sta=new Stack<>();
        TreeNode pre=null;
        while(root!=null ||!sta.isEmpty()){
            while(root!=null){
                sta.push(root);
                root=root.left;
            }
            root=sta.pop();
            if(pre!=null && root.val<=pre.val) return false;
            pre=root;
            root=root.right;

        }
        return true;
    }
//    第二种方法，采用递归
    public boolean isValidBST1(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
