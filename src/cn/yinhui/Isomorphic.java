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
public class Isomorphic {
	public static boolean isIsomorphic(String s, String t) {
		if(s.length()!=t.length()) return false;
		Map<Character, Integer> map1=new HashMap<Character, Integer>();
		Map<Character, Integer> map2=new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++){
			if(map1.put(s.charAt(i), i)!=map2.put(t.charAt(i), i))
				return false;
		}
		return true;
	}

	public static boolean isIsomorphic1(String s, String t) {
		int[] m = new int[512];
		for (int i = 0; i < s.length(); i++) {
			if (m[s.charAt(i)] != m[t.charAt(i) + 256])
				return false;
			m[s.charAt(i)] = m[t.charAt(i) + 256] = i + 1;
		}
		return true;
	}
	public static  String frequencySort(String s) {
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++){
			if(!map.containsKey(s.charAt(i))) map.put(s.charAt(i),1);
			else map.put(s.charAt(i), map.get(s.charAt(i))+1);
		}
		List<Character>[] list=new List[s.length()+1];
		for (char key : map.keySet()) {
			int frency=map.get(key);
			if(list[frency]==null){
				list[frency]=new ArrayList<Character>();
			}
			list[frency].add(key);
		}
		StringBuffer sb=new StringBuffer();
		for(int pos=list.length-1;pos>=0;pos--){
			if(list[pos]!=null){
				for(int j=0;j<list[pos].size();j++ ){
					for(int w=0;w<map.get(list[pos].get(j));w++){
						sb.append(list[pos].get(j));
					}
				}
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s1="zgg";
		String s2="add";
//		System.out.println(s1.charAt(0)+1);
		System.out.println(Character.MAX_VALUE+1);
//		String s="Aabb";
//		System.out.println(frequencySort(s));
		
	}

}
