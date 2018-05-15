package leetCode;

import java.util.ArrayList;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        StringBuffer sb=new StringBuffer();
        ArrayList<Integer> result=new ArrayList<>();
        int fact=1;
        for(int i=1;i<=n;i++){
            fact*=i;
            result.add(i);
        }
        for(int i=0,l=k-1;i<n;i++){
            fact=fact/(n-i);
            int index=(l/fact);
            sb.append(result.remove(index));
            l-=index*fact;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getPermutation(1,1));
    }
}
