package leetCode;

public class findKFromTwoSortedArray {
    public static  double findMedianSortedArrays(int[] A, int[] B) {
        int m=A.length,n=B.length;
        int l=(m+n+1)/2;
        int r=(m+n+2)/2;
        return (findK(A,B,l)+findK(A,B,r))/2.0;
    }
    public static int findK(int[] nums1,int[] nums2,int k){
        int lens1=nums1.length-1,lens2=nums2.length-1;
        int result=Integer.MAX_VALUE;
        while(k>0){
            if(lens1<0 && lens2>=0){
                if(result-nums2[lens2]==0) {lens2--;}
                else {result=nums2[lens2];lens2--;}
            }
            if(lens2<0 && lens1>=0){
                if(result-nums1[lens1]==0) lens1--;
                else {result=nums1[lens1];lens1--;}
            }
            if(lens1>=0 && lens2>=0){
                if(nums1[lens1]>=nums2[lens2] && nums1[lens1]<result) {result=nums1[lens1];lens1--;}
                else if(nums2[lens2]>nums1[lens1] && nums2[lens2]<result) {result=nums2[lens2];lens2--;}
                else{
                    if(nums1[lens1]==result && nums2[lens2]==result){
                        lens1--;lens2--;k--;
                    }else if(nums1[lens1]==result) lens1--;
                    else lens2--;
                }
            }
            k--;
        }
        return  result;
    }
    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }

    public static void main(String[] args) {
        int[] in1={1};
        int[] in2={2,3,4,5,6};
        System.out.println(getkth(in1,0,in2,0,3));
    }
}
