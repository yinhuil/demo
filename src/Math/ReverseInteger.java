package Math;

public class ReverseInteger {

	public static int reverse(int x) {
		int rev=0;
		while(x!=0){
			if (Math.abs(rev) > Integer.MAX_VALUE / 10) return 0;
			rev=rev*10+x%10;
			x/=10;
		}
	   return rev;
	}
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);

	}

}
