package leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LongestUncommonSubsequenceII {
    /*Given a list of strings, you need to find the longest uncommon subsequence among them. The longest uncommon
    subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be
    any subsequence of the other strings.

    A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing
    the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a
    subsequence of any string.

    The input will be a list of strings, and the output needs to be the length of the longest uncommon subsequence.
    If the longest uncommon subsequence doesn't exist, return -1.

    Example 1:
    Input: "aba", "cdc", "eae"
    Output: 3
    Note:

    All the given strings' lengths will not exceed 10.
    The length of the given list will be in the range of [2, 50].*/

    public int findLUSlength(String[] strs) {
        if(strs.length<=1) return strs.length;
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()!=o2.length()?o2.length()-o1.length():o2.compareTo(o1);
            }
        });
        if(!strs[1].equals(strs[0])) return strs[0].length();
        int curr=2;
        boolean flag=true;
        while(curr<strs.length){
            flag=true;
            if(!strs[curr].equals(strs[curr-1]) &&(curr==strs.length-1||!strs[curr].equals(strs[curr+1]))){
                for(int i=0;i<curr;i++){
                    if(isSubsequence(strs[i],strs[curr])){
                        flag=false;
                        break;
                    }
                }
            }
            if(flag) return strs[curr].length();
            curr++;
        }
        return -1;
    }
    public boolean isSubsequence(String str1,String str2){
        int i=0,j=0;
        while(i<str1.length() && j<str2.length()){
            if(str1.charAt(i)==str2.charAt(j)) j++;
            i++;
        }
        return j==str2.length();
    }
}
























