package BitManipulation;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbersinanArray {

	public static int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		for (int i = 31; i >= 0; i--) {
			mask = mask | (1 << i);
			System.out.println(Integer.toBinaryString(mask));
			Set<Integer> set = new HashSet<Integer>();
			for (int num : nums) {
				set.add(num & mask);
			}
			int tmp = max | (1 << i);
			for (int prefix : set) {
				if (set.contains(tmp ^ prefix)) {
					max = tmp;
					break;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		
		int[] in={3,10,5,25,2,8};
		System.out.println(findMaximumXOR(in));
	}

}
