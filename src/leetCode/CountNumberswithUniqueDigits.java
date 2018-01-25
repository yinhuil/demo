package leetCode;

public class CountNumberswithUniqueDigits {
    /*Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

            Example:
    Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100,
    excluding [11,22,33,44,55,66,77,88,99])*/
//    就是一个站队的过程的过程
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int res=10;
        int unique=9;
        int available=9;
        while(n-->1 && available>0){
            unique=unique*available;
            res+=unique;
            available--;
        }
        return res;
    }
}
