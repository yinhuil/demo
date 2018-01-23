package leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindBottomLeftTreeValue {
  /*  Given a binary tree, find the leftmost value in the last row of the tree.

    Example 1:
    Input:

            2
            / \
            1   3

    Output:
            1
    Example 2:
    Input:

            1
            / \
            2   3
            /   / \
            4   5   6
            /
            7

    Output:
            7*/
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
  }
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            root=queue.poll();
            if(root.right!=null) queue.add(root.right);
            if(root.left!=null) queue.add(root.left);
        }
        return root.val;

    }
}
