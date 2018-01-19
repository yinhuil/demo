package leetCode;

public class ReverseLinkedListII {

   /* Reverse a linked list from position m to n. Do it in-place and in one-pass.

    For example:
    Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

            Note:
    Given m, n satisfy the following condition:
            1 ≤ m ≤ n ≤ length of list.*/
    static class ListNode {
        ListNode next;
        int val;
        ListNode(int x){
            val=x;
        }
   }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result=new ListNode(0);
        result.next=head;
        ListNode pre=result;
        for(int i=1;i<m;i++) pre=pre.next;
        ListNode start=pre.next;
        ListNode then=start.next;
        for(int i=0;i<n-m;i++){
            start.next=then.next;
            then.next=pre.next;
            pre.next=then;
            then=start.next;
        }
        return result.next;


    }
}
