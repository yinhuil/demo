package leetCode;

import java.util.Stack;

public class BasicCalculator {
  /*  Implement a basic calculator to evaluate a simple expression string.

    The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

    You may assume that the given expression is always valid.

    Some examples:
            "1 + 1" = 2
            " 2-1 + 2 " = 3
            "(1+(4+5+2)-3)+(6+8)" = 23*/

//  解释，sta是为了存储前面的正负位置，如(1+2)-(3+4),那么最后一个+就要变成负号才好

  public int calculate(String s){
     if(s==null) return 0;
     int result=0,sign=1,num=0;
     Stack<Integer> sta=new Stack<>();
     sta.push(sign);
     for(int i=0;i<s.length();i++){
         char c=s.charAt(i);
         if(c>='0' && c<='9'){
             num=num*10+(c-'0');
         }else if(c=='+'||c=='-'){
             result+=num*sign;
             sign=sta.peek()*(c=='+'?1:-1);
             num=0;
         }else if(c=='('){
             sta.push(sign);
         }else if(c==')') sta.pop();
     }
     result+=sign*num;
      return result;
  }
}
