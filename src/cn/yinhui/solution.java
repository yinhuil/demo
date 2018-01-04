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

public class solution {
	public static boolean find(int m){
		int count=0;
		for(int i=1;i<=m;i++){
			if(m%i==0)
				count++;
		}
		if(count==8)
			return true;
		else return false ;
		
	}
   
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length())
            return false;
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;
    }
    
    
    public static String frequencySort(String s) {
        int[] freq = new int [256];
        for (char ch: s.toCharArray()) freq [ch]++;
        TreeMap<Integer, List<Character>> tree = new TreeMap<Integer, List<Character>>();
        for (int i=0; i<freq.length; i++) {
            if (freq[i] > 0) {
                if (!tree.containsKey(freq[i])) {
                    tree.put(freq[i], new LinkedList<Character>());
                }
                tree.get(freq[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(tree.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            for (Character ch: entry.getValue()) {
                sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
            }
        }
        return sb.toString();
    }
    public String frequencySort1(String s) {   
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
	    for (char c : s.toCharArray()) {
	        if (map.containsKey(c)) {
	            map.put(c, map.get(c) + 1);
	        } else {
	            map.put(c, 1);
	        }
	    }
	    List<Character> [] bucket = new List[s.length() + 1];
	    for (char key : map.keySet()) {
	        int frequency = map.get(key);
	        if (bucket[frequency] == null) {
	            bucket[frequency] = new ArrayList<Character>();
	        }
	        bucket[frequency].add(key);
	    }
	    StringBuilder sb = new StringBuilder();
	    for (int pos = bucket.length - 1; pos >=0; pos--) {
	        if (bucket[pos] != null) {
	            for (char num : bucket[pos]) {
	                for (int i = 0; i < map.get(num); i++) {
	                    sb.append(num);
	             }
	        }
	    }
    }
    return sb.toString();}
    public static String frequencySort2(String s){
    	TreeMap<Character, Integer> tree=new TreeMap<Character, Integer>();
    	for(int i=0;i<s.length();i++){
    		if(! tree.containsKey(s.charAt(i))){
    			tree.put(s.charAt(i), 1);
    		}else{
    		tree.put(s.charAt(i), tree.get(s.charAt(i))+1);}
    	}
    	System.out.println(tree.entrySet());
    	StringBuffer sb=new StringBuffer();
    	for (Integer inter : tree.values()) {
    		int temp=inter;
    		for (Character chara : tree.keySet()) {
    			char c=chara;
				if(tree.get(c)==temp){
					for(int i=0;i<temp;i++){
						sb.append(c);
					}
					
				}
			tree.keySet().remove(c);
			}
		}
    	return sb.toString();
    }
	
    
    
    public static void main(String[] args) {
    	int count=0;
		for(int i=1;i<=100;i++){
			if(find(i))
				count++;
		}
		System.out.println(count);
		
	}
}

