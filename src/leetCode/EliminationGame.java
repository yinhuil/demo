package leetCode;

import java.util.Stack;

public class EliminationGame {
 /*   There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number
    afterward until you reach the end of the list.
    Repeat the previous step again, but this time from right to left, remove the right most number and every other number from
    the remaining numbers.
    We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
    Find the last number that remains starting with a list of length n.
            Example:
    Input:
    n = 9,
            1 2 3 4 5 6 7 8 9
            2 4 6 8
            2 6
            6
    Output:
            6*/
// 这个方法特别好，我们只考虑第一个值，也就是head值，只有当从左边开始，或者剩余个数为奇数的时候，我们才会改变head的值，当剩下最后一个值的
//    时候即head的值，就为最后一个剩下的值
     public static int lastRemaining(int n) {
         int head=1;
         int remain=n;
         boolean left=true;
         int step=1;
         while(remain>1){
             if(left || remain%2==1){
                 head+=step;
             }
             remain=remain/2;
             step*=2;
             left=!left;
         }
         return head;
     }

    public static void main(String[] args) {
        System.out.println(lastRemaining(6));
    }
}