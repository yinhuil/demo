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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int lens=queue.size();
            int sum=Integer.MIN_VALUE;
            while(lens==0){
                TreeNode temp=queue.poll();
                sum=Math.min(sum,temp.val);
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            result.add(sum);
        }
        return result;
    }
}
