package leetCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result=new ArrayList<>();
        int lo=0,hi=arr.length-k;
        int mid;
        while (lo<hi){
            mid=lo+(hi-lo)/2;
            if(x-arr[mid]>arr[mid+k]-x) lo=mid+1;
            else hi=mid;
        }
        for(int i=0;i<k;i++) result.add(arr[lo+i]);
        return result;
    }
    public static List<Integer> findClosestElements1(int[] arr, int k, int x){
        List<Integer> list=new ArrayList<>();
        for(Integer i:arr) list.add(i);
        while(list.size()>k){
            int start=0,end=list.size()-1;
            if(x-list.get(start)<=list.get(end)-x) list.remove(end);
            else list.remove(start);
        }
        return list;

    }

    public static void main(String[] args) {
        int[] in ={1,2,3,4,5};
        List<Integer> list=findClosestElements1(in,4,3);
        for (Integer i: list
             ) {
            System.out.println(i);
        }
    }
}
