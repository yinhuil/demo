package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static  List<List<String>> partition(String s) {
		List<List<String>>  res=new ArrayList<List<String>>();
		List<String> list=new ArrayList<String>();
		dfs(s,0,res,list);
		return res;
	}
	private static void dfs(String s, int pos, List<List<String>> res,
			List<String> list) {
		if(pos==s.length()) res.add(new ArrayList<String>(list));
		else{
			for(int i=pos;i<s.length();i++){
//				if(ispal(s,pos,i)){
					list.add(s.substring(pos,i+1));
					dfs(s, i+1, res, list);
					list.remove(list.size()-1);
//				}
			}
		}
		
	}
	private static boolean ispal(String s, int low, int high) {
		while(low<high){
			if(s.charAt(low++)!=s.charAt(high--)) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		String str="aaab";
		List<List<String>> list=partition(str);
		for (List<String> list2 : list) {
			System.out.println(list2.toString());
		}
//		System.out.println(isPal(str, 0, 2));

	}

}
