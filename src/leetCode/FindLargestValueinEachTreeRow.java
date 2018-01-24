package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow {
    /*You need to find the largest value in each row of a binary tree.

    Example:
    Input:

            1
            / \
            3   2
            / \   \
            5   3   9

    Output: [1, 3, 9]*/
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){
            val=x;
        }
    }
//    第一种：使用非递归的方法；
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int lens=queue.size();
            int sum=Integer.MIN_VALUE;
            while(lens>0){
                TreeNode temp=queue.poll();
                sum=Math.max(sum,temp.val);
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
                lens--;
            }
            result.add(sum);
        }
        return result;
    }
//    第二种：使用递归的方法
    public List<Integer> largestValues1(TreeNode root) {
         List<Integer> result=new ArrayList<>();
         if(root==null) return result;
         return helper(root,0,result);
    }
    public List<Integer> helper(TreeNode root,int layer,List<Integer> list){
        if(layer>=list.size()){
            list.add(root.val);
        }else if(root.val>list.get(layer)) list.set(layer,root.val);
        if(root.left!=null) helper(root.left,layer+1,list);
        if(root.right!=null) helper(root.right,layer+1,list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root1=new TreeNode(1);
        TreeNode root2=new TreeNode(3);
        TreeNode root3=new TreeNode(2);
        TreeNode root4=new TreeNode(5);
        TreeNode root5=new TreeNode(3);
        TreeNode root6=new TreeNode(9);
        root1.left=root2;
        root1.right=root3;
        root2.left=root4;
        root2.right=root5;
        root3.right=root6;
        List<Integer> list=largestValues(root1);
        for (Integer i: list
             ) {
            System.out.println(i);
        }

    }
}
