package leetcode;

public class Candy {
/*    There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:

    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?*/


    public int candy(int[] ratings) {
        int lens=ratings.length;
        int[] dp=new int[lens];
        int result=0;
        dp[0]=1;
        for(int i=1;i<lens;i++){
            if(ratings[i]>ratings[i-1]) dp[i]=dp[i-1]+1;
            else dp[i]=1;
        }
        for(int i=lens-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                dp[i]=Math.max(dp[i],dp[i+1]+1);
            }
        }
        for(int i=0;i<lens;i++){
            result+=dp[i];
        }
        return result;
    }

}
