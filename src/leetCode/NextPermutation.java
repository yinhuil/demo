package leetCode;

public class NextPermutation {
  /*  Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

    The replacement must be in-place, do not allocate extra memory.

    Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
            1,2,3 → 1,3,2
            3,2,1 → 1,2,3
            1,1,5 → 1,5,1*/
//  方法：首先来判断是不是递减数列，如果是的话，就整体反转，不是的话，就找到其中一个递增的数列，找到这个时候的K
//    然后从最后一个往前找，找到后面的一个值大于这个值，进行交换，在将这个值后面的一些列数组进行反转。
  public void nextPermutation(int[] nums) {
     int lens=nums.length;
     int k=-1;
     for(int i=lens-2;i>=0;i--) {
         if (nums[i] < nums[i + 1]) {
             k = i;
             break;
         }
     }
     if(k==-1) {
         reverse(nums,0,lens-1); return;
     }
     int l=-1;
      for(int j=lens-1;j>k;j--){
          if(nums[j]>nums[k]){
              l=j;break;
          }
      }
      swap(nums,l,k);
      reverse(nums,k+1,lens-1);

  }
  public void reverse(int[] nums,int start,int end){
      while(start<end){
          swap(nums,start,end);
          end--;
          start++;
      }
  }
  public void swap(int[] nums,int i,int j){
      int temp=nums[i];
      nums[i]=nums[j];
      nums[j]=temp;
  }

    public static void main(String[] args) {
        int[] in={1,3,2};
       for(Integer i:in){
           System.out.println(i);
       }
    }

}
