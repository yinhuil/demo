package leetCode;

public class ArrayNesting {
   /* A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S,
    where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

    Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should
    be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.
            Example 1:
    Input: A = [5,4,0,3,1,6,2]
    Output: 6
    Explanation:
    A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

    One of the longest S[K]:
    S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}*/

    public int arrayNesting(int[] a) {
        int maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            int size = 0;
            for (int k = i; a[k] >= 0; size++) {
                int ak = a[k];
                a[k] = -1; // mark a[k] as visited;
                k = ak;
            }
            maxsize = Integer.max(maxsize, size);
        }

        return maxsize;
    }
}