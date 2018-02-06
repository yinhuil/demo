package leetCode;

public class LinkedListCycle {
//    Given a linked list, determine if it has a cycle in it.
    static class ListNode{
      ListNode next;
      int val;
      ListNode(int x){val=x;}
    }
//    一定要注意fast.next!=null && fast.next.next!=null这个条件。
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}
