package leetCode;

public class LongestPalindromicSubsequence {
  /*  Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

    Example 1:
    Input:

            "bbbab"
    Output:
            4
    One possible longest palindromic subsequence is "bbbb".
    Example 2:
    Input:

            "cbbd"
    Output:
            2
    One possible longest palindromic subsequence is "bb".*/
//理解：这里面的dp[i][j]表示i到j之间的最大长度回文序列
    public static int longestPalindromeSubseq(String s) {
        int lens=s.length();
        int[][] dp=new int[lens][lens];
        for(int j=0;j<lens;j++){
            dp[j][j]=1;
            for(int i=j-1;i>=0;i--){
                if(s.charAt(i)==s.charAt(j)) dp[i][j]=dp[i+1][j-1]+2;
                else dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][lens-1];
    }

    public static void main(String[] args) {
        String str="bbbab";
        System.out.println(longestPalindromeSubseq(str));
    }
}
