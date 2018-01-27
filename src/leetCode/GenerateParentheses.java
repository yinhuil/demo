package leetCode;

import java.util.ArrayList;
import java.util.List;
public class GenerateParentheses {
    /*Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    For example, given n = 3, a solution set is:

            [
            "((()))",
            "(()())",
            "(())()",
            "()(())",
            "()()()"
            ]*/
    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        if(n==0) return result;
        help(result,"",0,0,n);
        return result;
    }
    public static void help(List<String> list,String str ,int open,int close,int max ){
        if(str.length()==2*max){
            list.add(str);
            return;
        }
        if(open<max) help(list,str+"(",open+1,close,max);
        if(close<open) help(list,str+")",open,close+1,max);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
