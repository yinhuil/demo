package DP;

public class UniqueSubstringsinWraparoundString {

	public static int findSubstringInWraproundString(String p) {
		int[] count = new int[26];
	    int maxLengthCur = 0;	    
	    for (int i = 0; i < p.length(); i++) {
	        if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25)))
	            maxLengthCur++;
	        else
	            maxLengthCur = 1;

	        int index = p.charAt(i) - 'a';
	        count[index] = Math.max(count[index], maxLengthCur);
	    }
	    int sum = 0;
	    for (int i = 0; i < 26; i++) {
	        sum += count[i];
	    }
	    return sum;
	}
	public static int findSubstringInWraproundString1(String p){
        if(p == null || p.isEmpty()) return 0;
        int dp[] = new int[26];
        int i = 0;
        int n = p.length();
        char [] s = p.toCharArray();
        int len = 1;
        while(i<n){
            char prev = s[i];
            i++;
            dp[prev - 'a'] = Math.max(dp[prev-'a'], len);
            while(i<p.length() && s[i]-'a' == (prev-'a'+1)%26){
                prev = s[i];
                len++;
                i++;
                dp[prev - 'a'] = Math.max(dp[prev-'a'], len);
            }
            dp[prev - 'a'] = Math.max(dp[prev-'a'], len);
            len = 1;
        }
        int count = 0;
        for(int j = 0;j<26;j++) count+=dp[j];
        return count;
	}
	public static void main(String[] args) {
		String str="z";
		System.out.println(findSubstringInWraproundString1(str));
		
	}

}
