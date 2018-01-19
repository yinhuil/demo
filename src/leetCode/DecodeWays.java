package leetCode;

public class DecodeWays {
   /* A message containing letters from A-Z is being encoded to numbers using the following mapping:

            'A' -> 1
            'B' -> 2
            ...
            'Z' -> 26
    Given an encoded message containing digits, determine the total number of ways to decode it.

    For example,
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

    The number of ways decoding "12" is 2.*/

    public int numDecodings(String s) {
        int lens=s.length();
        if(lens==0) return 0;
        int[] dp=new int[lens+1];
        dp[lens]=1;
        dp[lens-1]=s.charAt(lens-1)=='0'?0:1;
        for(int i=lens-2;i>=0;i--){
            if(s.charAt(i)=='0') continue;
            else dp[i]=(Integer.parseInt(s.substring(i,i+2))<=26)?dp[i+1]+dp[i+2]:dp[i+1];
        }
        return dp[0];
    }
}
