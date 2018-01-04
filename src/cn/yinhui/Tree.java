package cn.yinhui;

import java.util.Stack;

import cn.yinhui.SearchTree.TreeNode;

public class Tree {

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	static int[] h=new int[7];
	static int i=0;
/*递归版的遍历*/
	public static void Traversal(TreeNode root) {
		if (root != null) {

			Traversal(root.left);
			h[i++] = root.val;
			Traversal(root.right);
		}
	}
// 非递归版的前序遍历
	public static void iterativePreorder(TreeNode root){
		Stack<TreeNode> sta=new Stack<Tree.TreeNode>();
		if(root!=null){
			sta.push(root);
			while(!sta.isEmpty()){
				TreeNode temp=sta.pop();
				h[i++]=temp.val;
				if(temp.right!=null){
					sta.push(temp.right);
				}
				if(temp.left!=null){
					sta.push(temp.left);
				}
			}
		}
	}
//	非递归版的后序遍历
	public static void iterativePostorder(TreeNode root){
		TreeNode q=root;
		Stack<TreeNode> sta=new Stack<Tree.TreeNode>();
		while(root!=null){
			for(;root.left!=null;root=root.left)
				sta.push(root);
			while(root!=null && (root.right==null || root.right==q)){
				h[i++]=root.val;
				q=root;
				if(sta.isEmpty())
					return;
				root=sta.pop();
			}
			sta.push(root);
			root=root.right;
		}
		
	}
//	非递归的中序遍历
	public static void iterativeInorder(TreeNode root){
	 	Stack<TreeNode> sta=new Stack<Tree.TreeNode>();
	 	while(root!=null){
	 		while(root!=null){
	 			if(root.right!=null)
	 				sta.push(root.right);
	 			sta.push(root);
	 			root=root.left;
	 		}
	 		root=sta.pop();
	 		while(!sta.isEmpty() && root.right==null){
	 			h[i++]=root.val;
	 			root=sta.pop();
	 		}
	 		h[i++]=root.val;
	 		if(!sta.isEmpty())
	 			root=sta.pop();
	 		else 
	 			root=null;
	 	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1=new TreeNode(1);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(3);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(5);
		TreeNode node6=new TreeNode(6);
		TreeNode node7=new TreeNode(7);
		node1.left=node2;
		node1.right=node3;
		node1.left.left=node4;
		node1.left.right=node5;
		node1.right.left=node6;
		node1.right.right=node7;
//		Traversal(node1);
//		iterativePreorder(node1);
//		iterativePostorder(node1);
		iterativeInorder(node1);
		for (int  in : h) {
			System.out.println(in);
		}
		
	}

}
