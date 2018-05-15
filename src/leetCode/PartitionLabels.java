package leetCode;
import javax.print.attribute.IntegerSyntax;
import java.util.ArrayList;
import java.util.List;
/*
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

        Example 1:
        Input: S = "ababcbacadefegdehijhklij"
        Output: [9,7,8]
        Explanation:
        The partition is "ababcbaca", "defegde", "hijhklij".
        This is a partition so that each letter appears in at most one part.
        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
*/
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> list=new ArrayList<>();
        int[] in=new int[26];
        for(int i=0;i<S.length();i++){
            in[S.charAt(i)-'a']=i;
        }
        int start=-1,end=-1;
        for(int i=0;i<S.length();i++){
            if(start==-1) start=i;
            end=Math.max(end,in[S.charAt(i)-'a']);
            if(end==i){
                list.add(end-start+1);
                start=-1;
            }
        }
        return list;
    }
}
