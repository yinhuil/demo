package leetCode;

public class CountDifferentPalindromicSubsequences {
 /*   Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.

    A subsequence of a string S is obtained by deleting 0 or more characters from S.

    A sequence is palindromic if it is equal to the sequence reversed.

    Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.

            Example 1:
    Input:
    S = 'bccb'
    Output: 6
    Explanation:
    The 6 different non-empty palindromic subsequences are 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
    Note that 'bcb' is counted only once, even though it occurs twice.
    Example 2:
    Input:
    S = 'abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba'
    Output: 104860361
    Explanation:
    There are 3104860382 different non-empty palindromic subsequences, which is 104860361 modulo 10^9 + 7.
*/
// 这种方法是不包括重复的
     public static int countPalindromicSubsequences(String S) {
         int len=S.length();
         int[][] dp=new int[len][len];
         char[] chs=S.toCharArray();
         for(int i=0;i<len;i++)dp[i][i]=1;
         for(int distance=1;distance<len;distance++){
             for (int i=0;i<len-distance;i++){
                 int j=i+distance;
                 if(chs[i]==chs[j])
             }
         }
     }
// 这种方法包括重复的
     public static int countPalindromicSubsequences1(String S) {
        int lens=S.length();
        int[][] dp=new int[lens][lens];
        for(int j=0;j<lens;j++){
            dp[j][j]=1;
            for(int i=j-1;i>=0;i--){
                dp[i][j]=dp[i+1][j]+dp[i][j-1]-dp[i+1][j-1];
                if(S.charAt(i)==S.charAt(j)) dp[i][j]+=dp[i+1][j-1]+1;
            }
        }
        return dp[0][lens-1];
     }

    public static void main(String[] args) {
        System.out.println(countPalindromicSubsequences("aba"));
    }

}
