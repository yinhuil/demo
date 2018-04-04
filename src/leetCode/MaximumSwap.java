package leetCode;

public class MaximumSwap {
   /* Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
    Return the maximum valued number you could get.

    Example 1:
    Input: 2736
    Output: 7236
    Explanation: Swap the number 2 and the number 7.
    Example 2:
    Input: 9973
    Output: 9973
    Explanation: No swap.*/
   public static int maximumSwap(int num) {
       char[] ch=(num+"").toCharArray();
       int[] dp=new int[10];
       for(int i=0;i<ch.length;i++){
           dp[ch[i]-'0']=i;
       }
       int max=9;
       for(int i=0;i<ch.length;i++){
           for(int j=max;j>ch[i]-'0';j--){
               if(dp[j]>i){
                   char temp=ch[i];
                   ch[i]=ch[dp[j]];
                   ch[dp[j]]=temp;
                   return Integer.valueOf(new String(ch));
               }
           }
           max=ch[i]-'0';
       }
       return num;
   }

    public static void main(String[] args) {
        int num=9973;
        System.out.println(maximumSwap(num));
    }
}
