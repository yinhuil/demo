package cn.yinhui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import edu.princeton.cs.algs4.In;
public class Matrix542 {
	public List<List<Integer>> updateMatrix(List<List<Integer>> matrix) {
		int m=matrix.size();
		int n=matrix.get(0).size();
		Queue<int[]> queue=new LinkedList<int[]>();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(matrix.get(i).get(j)==0){
					queue.offer(new int[]{i,j});
				}else{
					matrix.get(i).set(j, Integer.MAX_VALUE);
				}
			}
		}
		int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
		while(!queue.isEmpty()){
			int[] cell=queue.poll();
			for (int[] d : dirs) {
				int r=cell[0]+d[0];
				int c=cell[1]+d[1];
				if(r<0||r>=m||c<0||c>=n||matrix.get(r).get(c)<=matrix.get(cell[0]).get(cell[1])+1) continue;
				queue.offer(new int[]{r,c});
				matrix.get(r).set(c, matrix.get(cell[0]).get(cell[1])+1);
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			if(i==2) continue;
			System.out.println(i);
		}
	}
}
