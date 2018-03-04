package leetCode;

import java.util.List;

public class MergeKSortedLists {
//    Merge k sorted linked lists and return it as one sorted list.
// Analyze and describe its complexity.
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int x){val =x;}
}
    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists,0,lists.length-1);
    }
    public static ListNode partion(ListNode[] lists,int start,int end){
        if(start==end) return lists[start];
        if(start<end){
            int mid=start+(end-start)/2;
            ListNode l1=partion(lists,start,mid);
            ListNode l2=partion(lists,mid+1,end);
            return merge(l1,l2);
        }else return null;
    }
    public static ListNode merge(ListNode l1,ListNode l2){
       if(l1==null) return l2;
       if (l2==null) return l1;
       if(l1.val>l2.val){
           l2.next=merge(l1,l2.next);
           return l2;
       }else {
           l1.next=merge(l1.next,l2);
           return l1;
       }
    }
}
