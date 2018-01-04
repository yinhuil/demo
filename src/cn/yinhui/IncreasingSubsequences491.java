package cn.yinhui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import edu.princeton.cs.algs4.In;
public class IncreasingSubsequences491 {

	public static List<List<Integer>> findSubsequences(int[] nums) {
		Set<List<Integer>> se=new HashSet<List<Integer>>();
		List<Integer> list=new ArrayList<Integer>();
		findSeq(se,list,0,nums);
		return new ArrayList(se);
	}
	private static void findSeq(Set<List<Integer>> se, List<Integer> list, int index,
			int[] nums) {
		if(list.size()>=2) se.add(new ArrayList(list));
		for(int i=index;i<nums.length;i++){
			if(list.size()==0 || list.get(list.size()-1)<=nums[i]){
				list.add(nums[i]);
				findSeq(se, list, i+1, nums);
				list.remove(list.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		int[] nums={1,2,3};
		List<List<Integer>> list=findSubsequences(nums);
		for (List<Integer> list2 : list) {
			System.out.println(list2.toString());
		}
	}

}
