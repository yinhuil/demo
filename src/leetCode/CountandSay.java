package leetCode;

public class CountandSay {
    public static String countAndSay(int n) {
        if(n==1) return "1";
        String str=countAndSay(n-1);
        char[] ch=str.toCharArray();
        String res="";
        int count=1;
        for(int i=0;i<ch.length;i++){
            if(i==ch.length-1 || ch[i]!=ch[i+1] ){
                res+=count+""+ch[i];
                count=1;
            }else{
                count++;
            }
        }
        return res;
     }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
