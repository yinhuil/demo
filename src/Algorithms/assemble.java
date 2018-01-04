package Algorithms;

public class assemble {
	public static int assemble(int[][] a,int[][] t,int[] x,int[] e){
		int n=a[0].length-1;
		int[][] assemble=new int[3][n+1];
		assemble[1][1]=e[0];
		assemble[2][1]=e[1];
		
		for(int i=2;i<=n;i++){
			assemble[1][i]=Math.max(assemble[1][i-1]+a[0][i-1],assemble[2][i-1]+a[1][i-1]+t[1][i-1] );
			assemble[2][i]=Math.max(assemble[1][i-1]+a[0][i-1]+t[0][i-1], assemble[2][i-1]+a[1][i-1]);
		}
		return Math.max(assemble[1][n]+x[0]+a[0][n], assemble[2][n]+x[1]+a[1][n]);
	}
	public static void main(String[] args) {
		int[][] a={{0,7,9,3,4,8,4},{0,8,5,6,4,5,7}};
		int[][] t={{0,2,3,1,3,4},{0,2,1,2,2,1}};
		int[]x={3,2};
		int[] e={2,4};
		int ans=assemble(a, t, x, e);
		System.out.println(ans);
	}
}
