package Tree;

public class isSubTree {
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public static boolean HasSubTree(TreeNode root1,TreeNode root2){
    	boolean result=false;
    	if(root1!=null && root2!=null){
    		if(root1.val == root2.val){
    			result=DoedHasSubTree(root1,root2);
    		}
    		if(!result) result=HasSubTree(root1.left, root2);
    		if(!result) result=HasSubTree(root1.right, root2);
    	}
    	return result;
    }
	private static boolean DoedHasSubTree(TreeNode root1, TreeNode root2) {
		if(root2==null) return true;
		if(root1==null) return false;
		if(root1.val!=root2.val) return false;
		return DoedHasSubTree(root1.left, root2.left) && DoedHasSubTree(root1.right, root2.right);
	}
}
