package leetCode;

public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        int lens=num.length()-k;
        char[] stk=new char[num.length()];
        int index=0;
        for(int i=0;i<num.length();i++){
            char temp=num.charAt(i);
            while(index>0 && stk[index-1]>temp && k>0){
                index--;
                k--;
            }
            stk[index++]=temp;
        }
        int idx=0;
        while (idx<lens && stk[idx]=='0') idx++;
        return idx==lens? "0":new String(stk,idx,lens-idx);
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("1432219",2));
    }
}
