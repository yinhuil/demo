package baiduStar;

import java.util.ArrayList;
import java.util.List;

public class MGloveApple {
	public static boolean MgLoveApple(int[] appleSequence, int deleteLens) {
		List<List<Integer>> checkSeq=new ArrayList<List<Integer>>();
		List<Integer> list=new ArrayList<Integer>();
		boolean[] checkLens=new boolean[appleSequence.length];
		hepler(appleSequence,deleteLens,checkSeq,list,checkLens);
		for (List<Integer> temp : checkSeq) {
			if(isMgloveApple(temp)){
				return true;
			}
		}
		return false;
	}

	public static boolean isMgloveApple(List<Integer> temp) {
		int lens=temp.size();
		int tempValue=0;
		for(int i=lens-1;i>=0;i--){
			tempValue=10*tempValue+temp.get(i);
		}
		if(tempValue!=0 && tempValue%3==0) return true;
		else return false;
	}

	public static void hepler(int[] appleSequence, int deleteLens,
			List<List<Integer>> checkSeq, List<Integer> list,
			boolean[] checkLens) {
		if (list.size()==appleSequence.length-deleteLens) {
			checkSeq.add(new ArrayList<Integer>(list));
			return;
		}
		for(int i=0;i<appleSequence.length;i++){
			if(!checkLens[i]){
				checkLens[i]=true;
				list.add(appleSequence[i]);
				hepler(appleSequence, deleteLens, checkSeq, list, checkLens);
				list.remove(list.size()-1);
				checkLens[i]=false;
			}
		}
		
	}
	public static void main(String[] args) {
		int[] in={1,0,0,0};
		System.out.println(MgLoveApple(in, 2));
	}
}
