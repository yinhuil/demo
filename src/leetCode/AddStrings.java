package leetCode;

public class AddStrings {
    public static String addStrings(String num1, String num2){
        int len1=num1.length()-1,len2=num2.length()-1;
        StringBuffer sb=new StringBuffer();
        int carry=0;
        while(len1>=0 ||len2>=0){
            int x=len1<0?0:(num1.charAt(len1)-'0');
            int y=len2<0?0:(num2.charAt(len2)-'0');
            sb.append((x+y+carry)%10);
            carry=(x+y+carry)/10;
            len1--;len2--;
        }
        if(carry>0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("122","899"));
    }
}
