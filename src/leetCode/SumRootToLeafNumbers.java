package leetCode;

public class SumRootToLeafNumbers {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
    }
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
    public static int sum(TreeNode root,int sum){
        if(root==null) return sum;
        if(root.left==null && root.right==null) return sum*10+root.val;
        return sum(root.left,sum*10+root.val)+sum(root.right,sum*10+root.val);
    }
}
