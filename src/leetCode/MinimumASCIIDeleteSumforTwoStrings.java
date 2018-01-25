package leetCode;

public class MinimumASCIIDeleteSumforTwoStrings {
/*    Given two strings s1, s2, find the lowest ASCII sum of deleted characters to make two strings equal.

    Example 1:
    Input: s1 = "sea", s2 = "eat"
    Output: 231
    Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
            Deleting "t" from "eat" adds 116 to the sum.
    At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
    Example 2:
    Input: s1 = "delete", s2 = "leet"
    Output: 403
    Explanation: Deleting "dee" from "delete" to turn the string into "let",
    adds 100[d]+101[e]+101[e] to the sum.  Deleting "e" from "leet" adds 101[e] to the sum.
    At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
    If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.*/

    public static int minimumDeleteSum(String s1, String s2) {
        int m=s1.length(),n=s2.length();
        char[] a=s1.toCharArray(),b=s2.toCharArray();
        int[][] dp=new int[m+1][n+1];
        for(int j=1;j<=n;j++) dp[0][j]=dp[0][j-1]+b[j-1];
        for(int i=1;i<=m;i++){
            dp[i][0]=dp[i-1][0]+a[i-1];
            for(int j=1;j<=n;j++){
                dp[i][j]=(a[i-1]==b[j-1])?dp[i-1][j-1]:Math.min(dp[i-1][j]+a[i-1],dp[i][j-1]+b[j-1]);
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1="delete",str2="leet";
        System.out.println(minimumDeleteSum(str1,str2));
    }
}
