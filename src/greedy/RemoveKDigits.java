package greedy;

import java.util.Stack;

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
		while(idx<lens && stk[idx]=='0') idx++;
		return idx==lens? "0":new String(stk,idx,lens-idx);
	}
	public static String solution(String num,int k){
		 if (k == 0) {
	            return num;
	        }
	        int len = num.length();
	        if (k == len) {
	            return "0";
	        }
	        
	        char[] content = num.toCharArray();
	        // newContent store the result
	        char[] newContent = new char[len];

	        newContent[0] = content[0];
	        // newIndex points to the next value to be filled in(which means newIndex - 1 is the last value)
	        int newIndex = 1;
	        for (int i = 1; i <= len - 1; i++) {
	            char ch = content[i];
	            // replace the old value that smaller than ch
	            while (k > 0 && newIndex >= 1 && ch < newContent[newIndex - 1]) {
	                newIndex--;
	                k--;
	            }
	            // place ch
	            newContent[newIndex] = ch;
	            newIndex++;
	            // if k is 0, copy the rest to the newContent, the size of rest is (len - 1 - i + 1)
	            if (k == 0) {
	                i++;
	                System.arraycopy(content, i, newContent, newIndex, len - i);
	                newIndex += (len - i);
	                break;
	            }
	            
	        }
	        // remove head '0'
	        int startIndex = 0;
	        while (newContent[startIndex] == '0') {
	            startIndex++;
	        }
	        if (newIndex - startIndex - k == 0) {
	            return "0";
	        }
	        return new String(newContent, startIndex, newIndex - startIndex - k);
	}
	public static  String removeKdigits1(String num, int k) {
		int digits = num.length() - k;
		char[] stk = new char[num.length()];
		int top = 0;
		// k keeps track of how many characters we can remove
		// if the previous character in stk is larger than the current one
		// then removing it will get a smaller number
		// but we can only do so when k is larger than 0
		for (int i = 0; i < num.length(); ++i) {
			char c = num.charAt(i);
			while (top > 0 && stk[top - 1] > c && k > 0) {
				top -= 1;
				k -= 1;
			}
			stk[top++] = c;
		}
		// find the index of first non-zero digit
		int idx = 0;
		while (idx < digits && stk[idx] == '0')
			idx++;
		return idx == digits ? "0" : new String(stk, idx, digits - idx);
	}

	public static void main(String[] args){
	   String num="1432219";
	   char[] ch={'1','2','3','4','5'};
	   System.out.println(2>>1);
	}

}
