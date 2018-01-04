package DP;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> list=new ArrayList<Integer>();
        dfs(result,list,k,n,1);
        return result;
    }
	private void dfs(List<List<Integer>> result, List<Integer> list, int lens,
			int number, int start) {
		if(list.size()==lens && number==0) {
			result.add(new ArrayList<Integer>(list));
			return;
		}
			for(int i=start;i<=9;i++){
				list.add(i);
				dfs(result, list, lens--, number-i, i+1);
				list.remove(list.size()-1);
			}
		}
		

	public static void main(String[] args) {
		

	}

}
