package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class MostFrequentSubtreeSum {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        TreeNode(int x){val=x;}
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        add(root,hash);
        int max=0;
        for(Integer num:hash.keySet()){
            max=Math.max(max,hash.get(num));
        }
        List<Integer> list=new ArrayList<>();
        for(Integer num:hash.keySet()){
            if(hash.get(num)==max) list.add(num);
        }
        int[] result=new int[list.size()];
        int i=0;
        for(Integer temp:list) result[i++]=temp;
        return result;
    }
    public static int add(TreeNode root,HashMap<Integer,Integer> hash){
        if(root==null) return 0;
        int sum=root.val+add(root.left,hash)+add(root.right,hash);
        hash.put(sum,hash.getOrDefault(sum,0)+1);
        return sum;
    }
}
