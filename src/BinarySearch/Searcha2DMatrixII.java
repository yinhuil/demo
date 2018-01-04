package BinarySearch;

public class Searcha2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix==null||matrix.length==0){
    		return false;
    	}
    	int start =0,start1=0,row =matrix.length-1,cols=matrix[0].length-1;
    	int index=0;
    	while(row>=start){
    		int mid=(start+row)/2;
    		if(matrix[mid][0]<=target && (mid==row||matrix[mid+1][0]>target))index=mid;
    		if(matrix[mid][0]>target) row=mid-1;
    		else{
    			start=mid+1;
    		}
    	}
    	while(cols>=start1){
    		int temp=(start1+cols)/2;
    		if(matrix[index][temp]==target) return true;
    		if(matrix[index][temp]<target) start1=temp+1;
    		else{
    			cols=temp-1;
    		}
    	}
    	return false;   
    }
    public boolean searchMatrixII(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

	public boolean searchMatrix1(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int start = 0, rows = matrix.length, cols = matrix[0].length;
		int end = rows * cols - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (matrix[mid / cols][mid % cols] == target) {
				return true;
			}
			if (matrix[mid / cols][mid % cols] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][] in ={ {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}};
		System.out.println(searchMatrix(in, 12));
	}
}
