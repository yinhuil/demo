package leetCode;

import java.util.HashSet;

public class TwoSumIVInputIsABST {
   /* Given a Binary Search Tree and a target number, return true if there exist two elements in
    the BST such that their sum is equal to the given target.

            Example 1:
    Input:
            5
            / \
            3   6
            / \   \
            2   4   7

    Target = 9

    Output: True*/
   static class TreeNode{
       TreeNode left;
       TreeNode right;
       int val;
       TreeNode(int x){
           val=x;
       }
   }
   public boolean findTarget(TreeNode root, int k) {
       HashSet<Integer> hash=new HashSet<>();
       return dfs(hash,root,k);
   }
   public boolean dfs(HashSet<Integer> hash,TreeNode root,int k){
       if(root==null) return false;
       if(hash.contains(k-root.val)) return true;
       hash.add(root.val);
       return dfs(hash,root.left,k)||dfs(hash,root.right,k);
   }
}
