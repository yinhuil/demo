package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
  /*  Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

            For example,
    If n = 4 and k = 2, a solution is:

            [
            [2,4],
            [3,4],
            [2,3],
            [1,2],
            [1,3],
            [1,4],
            ]*/

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        if(n<k) return result;
        dfs(result,list,n,k,1);
        return result;
    }
    public void dfs(List<List<Integer>> result,List<Integer> list,int n,int k,int start){
        if(list.size()==k) {
            result.add(new ArrayList<>(list));
        }else{
            for(int i=start;i<=n;i++){
                list.add(i);
                dfs(result,list,n,k,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
