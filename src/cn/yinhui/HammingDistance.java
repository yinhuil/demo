package cn.yinhui;

public class HammingDistance {

	public static int hammingDistance(int x, int y) {
		int ans=x^y;
		String str=Integer.toBinaryString(ans);
		int sum=0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)=='1')
				sum++;
		}
		return sum;
	}

	public static int superPow(int a, int[] b) {
	    if (a % 1337 == 0) return 0;
	    int p = 0;
	    for (int i : b) p = (p * 10 + i) % 1140;
	    if (p == 0) p += 1440;
	    return power(a, p, 1337);
	}
	public static int power(int a, int n, int mod) {
	    a %= mod;
	    int ret = 1;
	    while (n != 0) {
	        if ((n & 1) != 0) ret = ret * a % mod;
	        a = a * a % mod;
	        n >>= 1;
	    }
	    return ret;
	}
	public static void main(String[] args) {
		int[] b={1,0};
		System.out.println(superPow(2, b));
	}

}
