package cn.yinhui;

public class sorted {
    private static boolean less(Comparable v,Comparable w){
    	return v.compareTo(w)<0;
    	}
    private static void exch(Comparable[] a,int i,int j){
    	Comparable t=a[i];
    	a[i]=a[j];
    	a[j]=t;
    }
//   选择排序法
    public static void sorted(Comparable[] a){
    	int n=a.length;
    	for(int i=0;i<n;i++){
    		int min=i;
    		for(int j=i+1;j<n;j++){
    			if(less(a[j], a[min])) min=j;
    		exch(a, min, i);
    		}
    	}
    	for (Comparable comparable : a) {
			System.out.println(comparable);
		}
    }
//    插入排序
    public static void sorted2(Comparable[] a){
    	int n=a.length;
    	for(int i=1;i<n;i++){
    		for(int j=i;j>0 && less(a[j], a[j-1]);j--){
    			exch(a, j, j-1);
    		}
    	}
    	for (Comparable comparable : a) {
			System.out.println(comparable);
		}
    }
//    希尔排序
    public static void sorted3(Comparable[] a){
    	int N=a.length;
    	int h=1;
    	while(h<N/3) h=3*h+1;
    	while(h>=1){
    		for(int i=h;i<N;i++){
    			for(int j=i;j>=h && less(a[j], a[j-h]);j-=h)
    				exch(a, j, j-h);
    		}
    		h=h/3;
    	}
    	for (Comparable comparable : a) {
			System.out.println(comparable);
		}
    }
    
//  原地归并排序
    public static void sorted4(Comparable[] a,int  lo,int mid,int hi){
    	int i=lo,j=mid+1;
    	Comparable[] aux=new Comparable[hi+1];
    	for(int k=lo;k<=hi;k++){
    		aux[k]=a[k];
    	}
    	for(int k=lo;k<=hi;k++){
    		if(i>mid) a[k]=aux[j++];
    		else if(j>hi) a[k]=aux[i++];
    		else if(less(aux[j], aux[i]))  a[k]=aux[j++];
    		else 						   a[k]=aux[i++];
    	}
    	
    }
//    自顶向下的归并排序
    public static void sorted5(Comparable[] a,int lo,int hi){
    	if(hi<=lo) return;
    	int mid=lo+(hi-lo)/2;
    	sorted5(a,lo,mid);
    	sorted5(a,mid+1,hi);
    	sorted4(a, lo, mid, hi);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a={"o","p","h","d","q","r"};
		sorted5(a,0,5);
		for (String string : a) {
			System.out.println(string);
		}
	   System.out.println(less(1, 2));

	}

}
