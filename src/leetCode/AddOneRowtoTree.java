package leetCode;

public class AddOneRowtoTree {
  /*  Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

    The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.

    Example 1:
    Input:
    A binary tree as following:
            4
            /   \
            2     6
            / \   /
            3   1 5

    v = 1

    d = 2

    Output:
            4
            / \
            1   1
            /     \
            2       6
            / \     /
            3   1   5

    Example 2:
    Input:
    A binary tree as following:
            4
            /
            2
            / \
            3   1

    v = 1

    d = 3

    Output:
            4
            /
            2
            / \
            1   1
            /     \
            3       1*/
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
  }
//  第一种，采用递归的方法；
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root==null) return null;
        if(d==1){
            TreeNode temp=new TreeNode(v);
            temp.left=root; return temp;
        }
        help(root,v,d,1);
        return root;
    }
    public void help(TreeNode root,int v,int d,int lens){
        if(root==null) return;
        if(lens==d-1){
            TreeNode temp=root.left;
            root.left=new TreeNode(v);
            root.left.left=temp;

            TreeNode temp1=root.right;
            root.right=new TreeNode(v);
            root.right.right=temp1;
            return;
        }
        help(root.left,v,d,lens+1);
        help(root.right,v,d,lens+1);
    }
//    第二种，采用非递归的方法；
    public TreeNode addOneRow1(TreeNode root, int v, int d) {
        if (d == 0 || d == 1) {
            TreeNode newroot = new TreeNode(v);
            newroot.left = d == 1 ? root : null;
            newroot.right = d == 0 ? root : null;
            return newroot;
        }
        if (root != null && d >= 2) {
            root.left  = addOneRow(root.left,  v, d > 2 ? d - 1 : 1);
            root.right = addOneRow(root.right, v, d > 2 ? d - 1 : 0);
        }
        return root;
    }
}























