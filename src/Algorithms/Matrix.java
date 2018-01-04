package Algorithms;

public class Matrix {
	static int[][] m=new int[7][7];
	static int[][] s=new int[7][7];
	public static void Matrix_chain_order(int[] p,int n){
		for (int index = 1; index <=n ; index++) {
			m[index][index]=0;
		}
		for(int L=2;L<=n;L++ ){
			for(int i=1;i<=n-L+1;i++){
				int j=i+L-1;
				m[i][j]=-1;
				for(int k=i;k<=j-1;k++){
					int temp=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
					if(temp<m[i][j] || m[i][j]==-1){
						m[i][j]=temp;
						s[i][j]=k;
					}
				}
			}
	    }
   }
	public static void print_optimal(int[][] s,int i,int j){
		if(i==j){
			System.out.printf("A"+"%d",i);
		}else{
			System.out.println("(");
			print_optimal(s, i, s[i][j]);
			print_optimal(s, s[i][j]+1, j);
			System.out.println(")");
		}
	}
	public static void main(String[] args) {
		int[] p={30,35,15,5,10,20,25};
		Matrix_chain_order(p, 6);
		for(int i=1;i<=6;i++){
			for(int j=1;j<=6;j++){
				System.out.println(m[i][j]);
				
			}
			System.out.println();
		}
		System.out.println("**********");
		for(int i=1;i<=6;i++){
			for(int j=1;j<=6;j++){
				System.out.println(s[i][j]);
				
			}
			System.out.println();
		}
		print_optimal(s, 1, 6);
		System.out.println();	
	}
}
