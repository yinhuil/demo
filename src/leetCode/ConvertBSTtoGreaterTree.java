package leetCode;

public class ConvertBSTtoGreaterTree {
    /*Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

    Example:

    Input: The root of a Binary Search Tree like this:
            5
            /   \
            2     13

    Output: The root of a Greater Tree like this:
            18
            /   \
            20     13*/
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
    }
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    public void convert(TreeNode root){
        if(root==null) return ;
        convert(root.right);
        root.val+=sum;
        sum=root.val;
        convert(root.left);
    }

}
