package leetCode;

public class SortColors {
   /* Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

            Note: You are not suppose to use the library's sort function for this problem.

    Example:

    Input: [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]*/
   public static void sortColors(int[] nums) {
       int start=0,end=nums.length-1;
       for(int i=start;i<=end;){
           if(nums[i]==2){
               int temp=nums[i];
               nums[i]=nums[end];
               nums[end]=temp;
               end--;
               i++;
           }else if (nums[i]==0){
               int temp=nums[i];
               nums[i]=nums[start];
               nums[start]=temp;
               start++;
               i++;
           }else i++;
       }
   }
   public static void sortedColors2(int[] nums){
       int i=0,j=0;
       for(int k=0;k<nums.length;k++){
           int temp=nums[k];
           nums[k]=2;
           if(temp<2){
               nums[j]=1;
               j+=1;
           }
           if(temp<1){nums[i]=0;i+=1;}
       }
   }

    public static void main(String[] args) {
        int[] in={2,0,2,1,1,0};
        sortedColors2(in);
        for (Integer i:in
             ) {
            System.out.print(i);
        }
    }
}
