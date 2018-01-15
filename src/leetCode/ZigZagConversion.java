package leetCode;

public class ZigZagConversion {
/*    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
            (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string text, int nRows);
    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".*/
//用一个stringbuffer的数组来表示。

    public static String convert(String s, int numRows) {
       char[] c=s.toCharArray();
       int lens=c.length;
       StringBuffer[] sb=new StringBuffer[numRows];
       for(int i=0;i<numRows;i++) sb[i]=new StringBuffer();
       int index=0;
       while(index<lens){
           for(int i=0;i<numRows && index<lens;i++){
               sb[i].append(c[index++]);
           }
           for(int j=numRows-2; j>0 && index<lens;j--){
               sb[j].append(c[index++]);
           }
       }
       for(int i=1;i<numRows;i++){
           sb[0].append(sb[i]);
       }
       return sb[0].toString();
    }

    public static void main(String[] args) {
        String str="PAYPALISHIRING";
        System.out.println(convert(str,3));
    }
}
