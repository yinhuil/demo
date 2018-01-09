package leetCode;

public class NonNegativeIntegers {
  /*  Given a positive integer n, find the number of non-negative integers less than or equal to n,
    whose binary representations do NOT contain consecutive ones.

    Example 1:
    Input: 5
    Output: 5
    Explanation:
    Here are the non-negative integers <= 5 with their corresponding binary representations:
            0 : 0
            1 : 1
            2 : 10
            3 : 11
            4 : 100
            5 : 101
    Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.*/

    public static int findIntegers(int num) {
       int cnt=0,n=num;
       String str="";
       while(n>0){
           cnt++;
           str+=((n & 1)==1)?"1":"0";
           n>>=1;
       }
       int[] zero=new int[cnt];
       int[] ones=new int[cnt];
       zero[0]=1;ones[0]=1;
       for(int i=1;i<cnt;i++){
           zero[i]=zero[i-1]+ones[i-1];
           ones[i]=zero[i-1];
       }
       int res=zero[cnt-1]+ones[cnt-1];
        for(int i=cnt-2;i>=0;i--){
            if(str.charAt(i)=='1' && str.charAt(i+1)=='1') break;
            if(str.charAt(i)=='0' && str.charAt(i+1)=='0') res-=ones[i];
        }
        return res;

    }
    public static int contString(int n){
        int a[] = new int [n];
        int b[] = new int [n];
        a[0] = b[0] = 1;
        for (int i = 1; i < n; i++)
        {
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        return a[n-1] + b[n-1];
    }
    public static void main(String[] args){
        System.out.println(contString(3));
    }
}
