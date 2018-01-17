package leetCode;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
 /*   Given a matrix of m x n elements (m rows, n columns), return all
    elements of the matrix in spiral order.

    For example,
    Given the following matrix:

            [
            [ 1, 2, 3 ],
            [ 4, 5, 6 ],
            [ 7, 8, 9 ]
            ]
    You should return [1,2,3,6,9,8,7,4,5].*/

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        ArrayList<Integer> list=new ArrayList<Integer>();
        int start=0;
        while(rows>2*start && cols>2*start){
            printMatrixHelp(list,matrix,rows,cols,start);
            start++;
        }
        return list;
    }

    private static void printMatrixHelp(ArrayList<Integer> list, int[][] matrix,
                                        int rows, int cols, int start) {
        int endX=rows-start-1;
        int endY=cols-start-1;
        for(int i=start;i<=endY;i++){
            list.add(matrix[start][i]);
        }
        if(endX>start){
            for(int i=start+1;i<=endX;i++){
                list.add(matrix[i][endY]);
            }
        }
        if(endX>start && endY>start){
            for(int i=endY-1;i>=start;i--){
                list.add(matrix[endX][i]);
            }
        }
        if(endX>start+1 && endY>start){
            for(int i=endX-1;i>=start+1;i--){
                list.add(matrix[i][start]);
            }
        }

    }

//    第二种方法，很便捷；
public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<Integer>();

    if (matrix.length == 0) {
        return res;
    }

    int rowBegin = 0;
    int rowEnd = matrix.length-1;
    int colBegin = 0;
    int colEnd = matrix[0].length - 1;

    while (rowBegin <= rowEnd && colBegin <= colEnd) {
        // Traverse Right
        for (int j = colBegin; j <= colEnd; j ++) {
            res.add(matrix[rowBegin][j]);
        }
        rowBegin++;

        // Traverse Down
        for (int j = rowBegin; j <= rowEnd; j ++) {
            res.add(matrix[j][colEnd]);
        }
        colEnd--;

        if (rowBegin <= rowEnd) {
            // Traverse Left
            for (int j = colEnd; j >= colBegin; j --) {
                res.add(matrix[rowEnd][j]);
            }
        }
        rowEnd--;

        if (colBegin <= colEnd) {
            // Traver Up
            for (int j = rowEnd; j >= rowBegin; j --) {
                res.add(matrix[j][colBegin]);
            }
        }
        colBegin ++;
    }

    return res;
}
    public static void main(String[] args) {
        int[][] matrix={{1,2}};
        System.out.println(printMatrix(matrix));
    }
}
