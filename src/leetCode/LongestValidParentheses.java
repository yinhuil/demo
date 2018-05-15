package leetCode;

import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
        Stack<Integer> sta=new Stack<>();
        int maxlen=0,last=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                sta.push(i);
            }else {
                if (sta.empty()) {
                    last = i;
                } else {
                    sta.pop();
                    if (sta.empty()) {
                        maxlen = Math.max(maxlen, i - last);
                    } else {
                        maxlen = Math.max(maxlen, i - sta.peek());
                    }
                }
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        String str=")()())";
        System.out.println(longestValidParentheses(str));
    }
}
