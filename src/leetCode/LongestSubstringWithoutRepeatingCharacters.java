package leetcode;

public class LongestSubstringWithoutRepeatingCharacters {
/*    Given a string, find the length of the longest substring without repeating characters.

    Examples:

    Given "abcabcbb", the answer is "abc", which the length is 3.

    Given "bbbbb", the answer is "b", with the length of 1.

    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is
    a subsequence and not a substring.*/
    public static int lengthOfLongestSubstring(String s) {
        int[] dp=new int[256];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;
        }
        int start=0,result=0;
        for(int i=0;i<s.length();i++){
            start=Math.max(dp[s.charAt(i)]+1,start);
            dp[s.charAt(i)]=i;
            result=Math.max(result,i-start+1);
        }
        return result;
    }

    public static void main(String[] args) {
        String str="abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
