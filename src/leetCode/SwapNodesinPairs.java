package leetCode;

public class SwapNodesinPairs {

 /*   Given a linked list, swap every two adjacent nodes and return its head.

    For example,
    Given 1->2->3->4, you should return the list as 2->1->4->3.

    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed*/
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int x){
            val=x;
        }
 }
// 第一种方法：采用非递归
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dumpy=new ListNode(0);
        dumpy.next=head;
        ListNode result=dumpy;
        ListNode current=result.next;
        while(current!=null && current.next!=null){
            ListNode next=current.next;
            current.next=next.next;
            next.next=result.next;
            result.next=next;
            result=current;
            current=current.next;
        }
        return dumpy.next;
    }
//    第二种，采用递归的方法
  public ListNode swapPairs1(ListNode head) {
    if (head == null || head.next == null) {
        return head;
    }
    ListNode nextNode  = head.next;
    head.next = swapPairs(nextNode.next);
    nextNode.next = head;
    return nextNode;
}
}
