package cn.yinhui;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ArithmeticSlices {

	public static int numberOfArithmeticSlices(int[] A) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		int ans=0;
		for(int i=0;i<A.length;i++){
			for(int j=i+1;j<A.length;j++){
				int temp=A[j]-A[i];
				if(!map.containsKey(temp)) map.put(temp, 1);
				else{
					
					map.put(temp, map.get(temp)+1);
				}
			}
		}
		Set<Integer> se=map.keySet();
		for (Integer integer : se) {
			int index=map.get(integer);
			if(index>=3){
				ans+=(index-2)*(index-1)/2;
			}
		}
		return ans;
	}
	public static int numberOfArithmeticSlices1(int[] A) {
	    int res = 0;
	    Map<Integer, Integer>[] map = new Map[A.length];
			
	    for (int i = 0; i < A.length; i++) {
	        map[i] = new HashMap<Integer, Integer>(i);
	        	
	        for (int j = 0; j < i; j++) {
	            long diff = (long)A[i] - A[j];
	            if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
	            int d = (int) diff;
	            int c1 = map[i].getOrDefault(d, 0);
	            int c2 = map[j].getOrDefault(d, 0);
	            res += c2;
	            map[i].put(d, c1 + c2 + 1);
	        }
	    }
			
	    return res;
	}
	public static void main(String[] args) {
	  int[] a={2,4,6,8,10};
	  System.out.println(numberOfArithmeticSlices(a));

	}

}
