package Algorithms;

public class bag {
	public static int bagFind(int[] weight,int[] quality,int limit){
		int[][] bag=new int[quality.length][limit+1];
		for(int i=1;i<=quality.length-1;i++){
			for(int j=1;j<=limit;j++){
				if(i==1){
					if(j<weight[i]){
						bag[i][j]=0;
					}else{
						bag[i][j]=quality[i];
					}
				}else{
					if(j<weight[i]){
						bag[i][j]=bag[i-1][j];
					}else{
						bag[i][j]=Math.max(bag[i-1][j], bag[i-1][j-weight[i]]+quality[i]);
					}
				}
			}
		}
		return bag[quality.length-1][limit];
	}
	public static void main(String[] args) {
		int[] weight={0,3,6,3,8,6};
		int[] quality={0,4,6,6,12,10};
		int ans=bagFind(weight, quality, 10);
		System.out.println(ans);
	}
}
