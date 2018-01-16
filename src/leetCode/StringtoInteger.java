package leetCode;
//用一个字符串的数字来转化为数字
public class StringtoInteger {
    public int myAtoi(String str) {
        if(str==null ||str.length()==0) return 0;
        int sign=1,base=0,i=0;
        while(str.charAt(i)==' ') i++;
        if(str.charAt(i)=='-'|| str.charAt(i)=='+') sign=str.charAt(i++)=='-'?-1:1;
        while(i<str.length()&& str.charAt(i)>='0'&&str.charAt(i)<='9'){
            if(base>Integer.MAX_VALUE/10||(base==Integer.MAX_VALUE/10 && str.charAt(i)-'0'>7)){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            base=base*10+(str.charAt(i++)-'0');
        }
        return sign*base;
    }

    public static void main(String[] args) {

    }
}
