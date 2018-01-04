package cn.yinhui;

public class HashTable <Key,Value>{

	private int N;
	private int M=16;
	private Key[] key;
	private Value[] vals;
	public HashTable(){
		key=(Key[]) new Object[M];
		vals=(Value[]) new Object[M];
	}
	private int hash(Key key){
		return (key.hashCode() & 0x7fffffff)%M;
	}
	private void resize()
	public void put(Key key,Value val){
		if(N>=M/2) resize(2*M);
		int i;
		for(i=hash(key);key[i]!=null;i=(i+1)%M)
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
