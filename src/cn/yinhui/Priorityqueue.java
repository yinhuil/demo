package cn.yinhui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
public class Priorityqueue<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N=0;
	public boolean less(int i,int j){
		return pq[i].compareTo(pq[j])<0;
	}
	public void exch(int i,int j){
		Key t=pq[i];
		pq[i]=pq[j];
		pq[j]=t;
	}
	public void swim(int k){
		while(k>1 && less(k/2,k)){
			exch(k, k/2);
			k=k/2;
		}
	}
	public void sink(int k){
		while (2*k<=N){
			int j=2*k;
			if(j<N && less(j, j+1)) j++;
			if(!less(k,j)) break;
			exch(k, j);
			k=j;
		}
	}
	public int size(){
		return N;
	}
	public void insert(Key v){
		pq[++N]=v;
		swim(N);
	}
	public Key deMax(){
		Key max=pq[1];
		exch(1,N--);
		pq[N+1]=null;
		sink(1);
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
