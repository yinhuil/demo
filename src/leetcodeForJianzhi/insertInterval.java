package leetcodeForJianzhi;

import java.util.ArrayList;

public class insertInterval {
	static class Interval{
		int start;
		int end;
		Interval(){
			start=0;end=0;
		}
		Interval(int s,int e){
			start=s;end=e;
		}
	}
	/*题目描述

	Given a set of non-overlapping intervals, insert a new interval into the intervals 
	(merge if necessary).
	You may assume that the intervals were initially sorted according to their start times.
	Example 1: 
	Given intervals[1,3],[6,9], insert and merge[2,5]in as[1,5],[6,9].
	Example 2: 
	Given[1,2],[3,5],[6,7],[8,10],[12,16], insert and merge[4,9]in as[1,2],[3,10],[12,16].
	This is because the new interval[4,9]overlaps with[3,5],[6,7],[8,10].*/
//解析：这道题的想找到属于中间的这个点，并把他赋值给newinterval并把第一次出现这个点的位置记录下来，最后给插入进去。  方法很妙！
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		ArrayList<Interval> result=new ArrayList<Interval>();
		int index=0;
		for (Interval interval : intervals) {
			if(interval.start>newInterval.end){
				result.add(interval);
			}else if(interval.end<newInterval.start){
				result.add(interval);
				index++;
			}else{
				newInterval.start=Math.min(newInterval.start, interval.start);
				newInterval.end=Math.max(newInterval.end, interval.end);
			}
		}
		result.add(index, newInterval);
        return result;

	}
}































