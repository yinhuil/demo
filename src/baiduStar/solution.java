package baiduStar;

import java.util.Scanner;

class solution {
	public static int A(int first, int second) {
		int tmp = first;
		int result = first;
		int count = 0;
		while (count < second - 1) {
			if (second == 1) {
				return first;
			} else {
				count++;
				tmp--;
				result = result * tmp;
			}
		}
		return result;
	}

	public static int factorialA(int number) {
		return A(number, number);
	}

	public static double C(int n, int r) {
		return factorialA(n) / (factorialA(n - r) * factorialA(r));
	}  
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		int totalNumber=in.nextInt();
		int[][] arrayNbyM=new int[totalNumber][2];
		int i=0;
		while(in.hasNext()){
			arrayNbyM[i][0]=in.nextInt();
			arrayNbyM[i][1]=in.nextInt();
			i++;
		}
		for (int[] is : arrayNbyM) {
			System.out.println(is[0]+"..."+is[1]);
		}
	}

}
