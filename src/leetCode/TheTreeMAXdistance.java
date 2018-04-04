package leetCode;

public class TheTreeMAXdistance {
//    求树的最大距离
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
     }
     public static int maxtree=0;
     public static int maxDistance(TreeNode root){
        if(root==null){
            return 0;
        }else if(root.left==null && root.right==null) return 0;
        int distance=Math.max(height(root.left)+height(root.right),Math.max
                (maxDistance(root.left),maxDistance(root.right)));
        if(distance>maxtree){
            maxtree=distance;
        }
        return maxtree;
     }
     public static int height(TreeNode root){
         if(root==null) return 0;
         int left=height(root.left);
         int right=height(root.right);
         return Math.max(left,right)+1;
     }
}
