package leetCode;

public class MaxChunksToMakeSortedII {
   /* This question is the same as "Max Chunks to Make Sorted" except the integers of the given array are not necessarily distinct, the input array could be up to length 2000, and the elements could be up to 10**8.

    Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

    What is the most number of chunks we could have made?

    Example 1:

    Input: arr = [5,4,3,2,1]
    Output: 1
    Explanation:
    Splitting into two or more chunks will not return the required result.
    For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
    Example 2:

    Input: arr = [2,1,3,4,4]
    Output: 4
    Explanation:
    We can split into two chunks, such as [2, 1], [3, 4, 4].
    However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.*/

    public int maxChunksToSorted(int[] arr) {
        int lens=arr.length;
        int[] maxOfLeft=new int[lens];
        int[] minOfRight=new int[lens];
        maxOfLeft[0]=arr[0];
        for(int i=1;i<lens;i++){
            maxOfLeft[i]=Math.max(maxOfLeft[i-1],arr[i]);
        }
        minOfRight[lens-1]=arr[lens-1];
        for(int i=lens-2;i>=0;i--){
            minOfRight[i]=Math.min(minOfRight[i+1],arr[i]);
        }
        int res=0;
        for(int i=0;i<lens-1;i++){
            if(maxOfLeft[i]<=minOfRight[i+1]) res++;
        }
        return res+1;

    }

}
