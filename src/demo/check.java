package demo;

public class check {
	private static int box;
	public static void process(int[] price,int[] length,int[] width,int[] hight){
		int number=price.length;
		int[][][] dp=new int[number+1][2001][box+1];
		for(int i=0;i<number;i++){
			int tempcir=length[i]+width[i]+hight[i];
			int tempPrice=price[i];
			for(int j=1;j<=2000;j++){
				for(int k=1;k<=box;k++){
					if()
				}
			}
		}
		
	}
}
