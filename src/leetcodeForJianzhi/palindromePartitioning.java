package leetcodeForJianzhi;

import java.util.ArrayList;

public class palindromePartitioning {
/*	题目描述

	Given a string s, partition s such that every substring of the partition is a palindrome.
	Return all possible palindrome partitioning of s.
	For example, given s ="aab",
	Return
	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]*/
	 public static ArrayList<ArrayList<String>> partition(String s) {
		    ArrayList<ArrayList<String>> lists = new ArrayList<ArrayList<String>>();
		    ArrayList<String> list = new ArrayList<String>();
		    partitionHepler(lists, list, s);
		    return lists;
		  }
		 
		  public static void partitionHepler(ArrayList<ArrayList<String>> lists, ArrayList<String> list, String s) {
		    if (null == s || s.length() == 0) {
		      lists.add(new ArrayList<String>(list));
		      return;
		    }
		    int len = s.length();
		    for (int i = 0; i <= len;i++) {
		      String subStr = s.substring(0, i);
		      if (isPalindrome(subStr)) {
		        list.add(subStr);
		        partitionHepler(lists, list, s.substring(i, len));
		        list.remove(list.size() - 1);
		      }
		    }
		  }
		 
		  public static boolean isPalindrome(String s) {
		    if (null == s || s.length() == 0) return false;
		    int length = s.length();
		    int middle = length / 2;
		    for (int i = 0; i < middle;i++) {
		      if (s.charAt(i) != s.charAt(length - 1 - i)) {
		        return false;
		      }
		    }
		    return true;
		  }
	public static void main(String[] args) {
		String s="aab";
		ArrayList<ArrayList<String>> res=partition(s);
		for (ArrayList<String> arrayList : res) {
			System.out.println(arrayList.toString());
		}
		
		
		
	}
}
