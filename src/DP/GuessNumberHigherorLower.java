package DP;

public class GuessNumberHigherorLower {

	public static int getMoneyAmount(int n) {
		int[][] table = new int[n + 1][n + 1];
		return DP(table, 1, n);
	}

	static int DP(int[][] t, int s, int e) {
		if (s >= e)
			return 0;
		if (t[s][e] != 0)
			return t[s][e];
		int res = Integer.MAX_VALUE;
		for (int x = s; x <= e; x++) {
			int tmp = x + Math.max(DP(t, s, x - 1), DP(t, x + 1, e));
			res = Math.min(res, tmp);
		}
		t[s][e] = res;
		return res;
	}
	 public int getMoneyAmount1(int n) {
	        int[][] table = new int[n+1][n+1];
	        for(int j=2; j<=n; j++){
	            for(int i=j-1; i>0; i--){
	                int globalMin = Integer.MAX_VALUE;
	                for(int k=i+1; k<j; k++){
	                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
	                    globalMin = Math.min(globalMin, localMax);
	                }
	                table[i][j] = i+1==j?i:globalMin;
	            }
	        }
	        return table[1][n];
	    }

	public static void main(String[] args) {
		System.out.println(getMoneyAmount(10));
	}

}
