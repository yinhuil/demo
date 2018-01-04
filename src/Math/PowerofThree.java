package Math;

public class PowerofThree {
	
	public static boolean isPowerOfFour(int num) {
		return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
	}

	public static void main(String[] args) {

	}
}
