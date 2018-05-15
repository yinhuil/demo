package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorofaBinaryTree {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1=new ArrayList<>();
        List<TreeNode> list2=new ArrayList<>();
        help(root,p,list1);
        help(root,q,list2);
        int i=0;
        TreeNode result=null;
        while(i<list1.size()&& i<list2.size()){
            if(list1.get(i)==list2.get(i)) result=list1.get(i);
        }
        return result;

    }
    public static List<Integer> findPath(TreeNode root,TreeNode p){
        List<Integer> list=new ArrayList<>();
        help(root,p,list);
        return list;
    }
    public static void help(TreeNode root,TreeNode p,List<Integer> list){
        if(root==null ) return;
        list.add(root.val);
        if(root==p) {
            System.out.println("yijingwanchneg");
            return;
        }
        if(root.left!=null) help(root.left,p,list);
        if(root.right!=null) help(root.right,p,list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(5);
        TreeNode n3=new TreeNode(1);
        TreeNode n4=new TreeNode(6);
        TreeNode n5=new TreeNode(2);
        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        List<Integer> list=findPath(n1,n5);
        for (Integer i: list
             ) {
            System.out.println(i);
        }


    }
}
