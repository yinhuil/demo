package cn.yinhui;

import java.util.Arrays;

public class AssignCookies {

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
	   int ans=0;
	   int index=0;
	   if(s.length==0) return 0;
	   for(int i=0;i<g.length;i++){
		   int temp=g[i];
		   while(index<s.length){
			   if(s[index]>=temp){
				   ans++;
				   index++;
				   break;
			   }else{
				   index++;
			   }
			 
		   }
	   }
	   return ans;
	}

	public static int findContentChildren1(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int i=0;
		for(int j=0;i<g.length && j<s.length;j++){
			if(g[i]<=s[j]) i++;
		}
		return i;
	}
	public static void main(String[] args) {
		int[] g={10,9,8,7};
		int[] s={5,6,7,8};
		System.out.println(findContentChildren1(g, s));
	}

}
