package Stack;

import java.util.Stack;

public class BasicCalculator {
	
	
	
    public static int calculate(String s) {
		if(s==null) return 0;
		Stack<Integer> sta=new Stack<Integer>();
		int result=0,sign=1;
		int num=0;
		sta.push(sign);
		for(int i=0;i<s.length();i++){
			char temp=s.charAt(i);
			if(temp>='0' && temp<='9')
				num=num*10+temp-'0';
			else if(temp=='+' ||temp=='-'){
				result+=num*sign;
				sign=sta.peek()*(temp=='+'?1:-1);
				num=0;
			}else if(temp=='('){
				sta.push(sign);
			}else if(temp==')'){
				sta.pop();
			}
		}
		return result+num*sign;
    }
    public static void main(String[] args) {
    	 String str="2-1 + 2";
    	 System.out.println(calculate(str));
	}
}
