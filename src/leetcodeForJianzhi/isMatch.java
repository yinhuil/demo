package leetcodeForJianzhi;

public class isMatch {
/*	题目描述

	Implement wildcard pattern matching with support for'?'and'*'.
	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).

	The matching should cover the entire input string (not partial).

	The function prototype should be:
	bool isMatch(const char *s, const char *p)

	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "*") → true
	isMatch("aa", "a*") → true
	isMatch("ab", "?*") → true
	isMatch("aab", "c*a*b") → false*/
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null)
           return false;

       boolean[][] res = new boolean[s.length() + 1][p.length() + 1];
       res[0][0] = true;
     /*  for (int i = 0; i < p.length(); i++) {
           if(p.charAt(i)=='*')
               res[0][i+1]=res[0][i];
       }  */
       for(int i=0;i<s.length();i++){
           for(int j=0;j<p.length();j++){
               if(p.charAt(j)=='?'||p.charAt(j)==s.charAt(i))
                   res[i+1][j+1]=res[i][j];
               if(p.charAt(j)=='*'){
                   res[i+1][j+1]=res[i+1][j]||res[i][j+1];
               }
           }
       }
        
       return res[s.length()][p.length()];
   }
    public static void main(String[] args) {
		String s1="abcca";
		String s2="a?*a";
		System.out.println(isMatch(s1, s2));
	}
}
