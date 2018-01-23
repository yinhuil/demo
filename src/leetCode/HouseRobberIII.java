package leetCode;

public class HouseRobberIII {
 /*   The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root."
    Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in " +
            "this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken
    into on the same night.

    Determine the maximum amount of money the thief can rob tonight without alerting the police.

            Example 1:
            3
            / \
            2   3
            \   \
            3   1
    Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
    Example 2:
            3
            / \
            4   5
            / \   \
            1   3   1
    Maximum amount of money the thief can rob = 4 + 5 = 9.*/
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
 }

    public int rob(TreeNode root) {
        if(root==null) return 0;
        int[] result=help(root);
        return Math.max(result[0],result[1]);
    }
    public static int[] help(TreeNode root){
        if(root==null) return new int[]{0,0};
        int[] left=help(root.left);
        int[] right=help(root.right);
        int with=root.val+left[1]+right[1];
        int without=left[0]+right[0];
        with=Math.max(with,without);
        int[] result=new int[]{with,without};
        return result;
    }
}
