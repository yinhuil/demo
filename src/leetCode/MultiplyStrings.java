package leetCode;

public class MultiplyStrings {
 /*   Given two non-negative integers num1 and num2 represented as strings,
    return the product of num1 and num2.

    Note:

    The length of both num1 and num2 is < 110.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.*/

     public static  String multiply(String num1, String num2) {
        int m=num1.length(),n=num2.length();
        int[] pos=new int[m+n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int index=i+j,index2=i+j+1;
                int sum=mul+pos[index2];
                pos[index]+=sum/10;
                pos[index2]=sum%10;
            }
        }
        String str="";
         for(int i=0;i<pos.length;i++){
             if(!(str.length()==0&&pos[i]==0)) str=str+""+pos[i];
         }
         return str.length()==0?"0":str;

     }

    public static void main(String[] args) {
        String str="123";
        String str2="456";
        System.out.println(multiply(str,str2));
    }
}
