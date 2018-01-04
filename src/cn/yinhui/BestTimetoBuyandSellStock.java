package cn.yinhui;

public class BestTimetoBuyandSellStock {

	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;

		int max_profit = 0;
		int prev_profit = 0;
		int min_price = prices[0];

		for (int i = 1; i < prices.length; ++i) {
			int curr_profit = prices[i] - min_price;

			if (curr_profit < prev_profit) {
				// prev_proft is local max profit
				max_profit += prev_profit;

				// reset prev_profit
				prev_profit = 0;

				// current price is the new min price
				min_price = prices[i];
			} else {
				prev_profit = curr_profit;
			}
		}

		max_profit += prev_profit;

		return max_profit;

	}
	public static void main(String[] args) {
		

	}

}
