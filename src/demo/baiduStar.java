package demo;

import java.util.Scanner;

class baiduStar {
   
	public static int maxSparConsumeHelper(int[][] panda,int[] monster ){
		int lifeValue=monster[0];
		int defendValue=monster[1];
		int pandaNumber=panda.length;
		int[] dp=new int[lifeValue+1];
		for(int i=1;i<=lifeValue;i++){
			dp[i]=Integer.MAX_VALUE;
			for(int j=0;j<pandaNumber;j++ ){
				if((panda[j][1]-defendValue)<=0){
					continue;
				}
				if((panda[j][1]-defendValue)>=i){
					dp[i]=Math.min(dp[i], panda[j][0]);
				}else{
					dp[i]=Math.min(dp[i], dp[i-(panda[j][1]-defendValue)]+panda[j][0]);
				}
			}
		}
		if(dp[lifeValue]==Integer.MAX_VALUE){
			return -1;
		}else{
		     return dp[lifeValue];}
		
	}
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int monsterLens=in.nextInt();
		int pandaLens=in.nextInt();
		int[][] monster=new int[monsterLens][2];
		int[][] panda=new int[pandaLens][2];
		int i=1;
		int k=0,j=0;
		while(in.hasNext()){
			if(i<=monsterLens){
				monster[j][0]=in.nextInt();
				monster[j][1]=in.nextInt();
				j++;
			}else{
				panda[k][0]=in.nextInt();
				panda[k][1]=in.nextInt();
				k++;
			}
		    i++;
		}
		int ans=0;
		for(int monsterNum=0;monsterNum<monsterLens;monsterNum++){
			ans+=maxSparConsumeHelper(panda, monster[0]);
		}
		if(ans==-monsterLens){
			System.out.println(-1);
		}else{
			System.out.println(ans);
		}
		
		
	}
}
