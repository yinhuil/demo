package Arrays;

public class LongestRepeatingCharacterReplacement {

	public static int characterReplacement(String s, int k) {
		int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
	}
	public static int characterReplacement1(String s, int k){
		int[] count=new int[26];
		int start=0,maxlength=0,maxcount=0;
		for(int end=0;end<s.length();end++){
			maxcount=Math.max(maxcount, ++count[s.charAt(end)-'A']);
			while(end-start+1-maxcount>k){
				count[s.charAt(start)-'A']--;
				start++;
			}
			maxlength=Math.max(maxlength, end-start+1);
		}
		return maxlength;
	}
	public static void main(String[] args) {
		String str="AABABBA";
		System.out.println(characterReplacement1(str, 1));
	}

}
