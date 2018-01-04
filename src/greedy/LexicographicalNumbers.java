package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class LexicographicalNumbers {

	public static List<Integer> lexicalOrder(int n) {
		List<Integer> list=new ArrayList<Integer>();
		int[] ans=new int[n];
		int cur=1;
		for(int i=0;i<n;i++){
			ans[i]=cur;
			if(cur*10<=n){
				cur=10*cur;
			}else{
				if(cur>=n) cur/=10;
				cur+=1;
				while(cur%10==0) cur/=10;
			}
		}
		for (int i : ans) {
			list.add(i);
		}
		return list;
	}
	public static List<Integer> lexicalOrder1(int n){
		List<Integer> list=new ArrayList<Integer>();
		for(int i=1;i<10;i++){
			dfs(i,n,list);
		}
		return list;
	}
	private static void dfs(int i, int n, List<Integer> list) {
		if(i>n) return;
		list.add(i);
		for(int j=0;j<10;j++){
			if(10*i+j>n) return;
			dfs(10*i+j, n, list);
		}
		
	}
	public static void main(String[] args) {
		int x=23;
		List<Integer> li=lexicalOrder1(x);
		for (Integer integer : li) {
			System.out.println(integer);
		}

	}

}
