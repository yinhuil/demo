package demo;

import java.util.ArrayList;
import java.util.List;

public class demo {
	public static  List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(nums==null){
			return result;
		}
		List<Integer> list=new ArrayList<Integer>();
		boolean[] check=new boolean[nums.length];
		permuteHelper(result,list,check,nums);
		return result;
	}

	public static void permuteHelper(List<List<Integer>> result, List<Integer> list,
			boolean[] check, int[] nums) {
		if(list.size()==nums.length){
			result.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=0;i<nums.length;i++){
			if(!check[i]){
				check[i]=true;
				list.add(nums[i]);
				permuteHelper(result, list, check, nums);
				list.remove(list.size()-1);
				check[i]=false;
			}
		}
		
	}
	public static ArrayList<ArrayList<Integer>> permute1(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0)
			return res;
		helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
		return res;
	}

	private static  void helper(int[] num, boolean[] used, ArrayList<Integer> item,
			ArrayList<ArrayList<Integer>> res) {
		if (item.size() == num.length) {
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (!used[i]) {
				used[i] = true;
				item.add(num[i]);
				helper(num, used, item, res);
				item.remove(item.size()-1);
				used[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		int[] in={1,2,3};
		System.out.println(permute(in));
	}
}
