package BinarySearch;

public class solution {
	 boolean isBadVersion(int version) {
		return false;
	}
	public int firstBadVersion(int n) {
		int start=1,end=n;
		while(start!=end){
			int mid=start+(end-start)/2;
			if(isBadVersion(mid)) end=mid;
			else start=mid+1;
		}
		return start;
	}

	public static void main(String[] args) {

	}
}
