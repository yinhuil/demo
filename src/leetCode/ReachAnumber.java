package leetCode;

public class ReachAnumber {
	/*You are standing at position 0 on an infinite number line. There is a goal at position target.

	On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

	Return the minimum number of steps required to reach the destination.

	Example 1:
	Input: target = 3
	Output: 2
	Explanation:
	On the first move we step from 0 to 1.
	On the second step we step from 1 to 3.
	Example 2:
	Input: target = 2
	Output: 3
	Explanation:
	On the first move we step from 0 to 1.
	On the second move we step  from 1 to -1.
	On the third move we step from -1 to 2.*/
//	解析：对于target是正数还是负数都是一样的，只是向左还是向右的问题
//	如果step之间的和正好等于target，那就是这个step，如果不等于的话，肯定是中间有一个多个方向应该往左，那么sum和target
//	之间的差值肯定是2*i，所以他们之间的差值肯定可以把2整除，发现一个就停下，这个时候肯定就是最小的step
	public static int reachNumber(int target) {
		target=Math.abs(target);
		int step=0;
		int sum=0;
		while(sum<target){
			step++;
			sum+=step;
		}
		while((sum-target)%2!=0){
			step++;
			sum+=step;
		}
		return step;
	}
	public static void main(String[] args) {
		System.out.println(reachNumber(3));
	}
}
