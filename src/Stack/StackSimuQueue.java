package Stack;

import java.util.Stack;

public class StackSimuQueue {
	public static int pop(int[] in){
		Stack<Integer> sta1=new Stack<Integer>();
		Stack<Integer> sta2=new Stack<Integer>();
		for(int i=0;i<in.length;i++){
			sta1.push(in[i]);
		}
		if(sta2.size()<=0){
			while(!sta1.isEmpty()){
				sta2.push(sta1.pop());
			}
		}
		int ans=sta2.peek();
		sta2.pop();
		return ans;
	}
	public static void main(String[] args) {
		int[] in={1,2,3};
		System.out.println(pop(in));
	}
}
