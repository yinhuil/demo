package leetCode;

import java.util.List;

public class ReorderList {
    /*Given a singly linked list L: L0→L1→…→Ln-1→Ln,
    reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

    You must do this in-place without altering the nodes' values.

    For example,
    Given {1,2,3,4}, reorder it to {1,4,2,3}.*/
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int x){
            val=x;
        }
    }

    public static void reorderList(ListNode head) {
        if(head==null||head.next==null) return;

        //Find the middle of the list
        ListNode p1=head;
        ListNode p2=head;
        while(p2.next!=null&&p2.next.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }

        //Reverse the half after middle  1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle=p1;
        ListNode preCurrent=p1.next;
        ListNode pre=null;
        while(preCurrent!=null){
            if(preCurrent.next==null) {
                preCurrent.next=pre;
                break;
            }
            ListNode next=preCurrent.next;
            preCurrent.next=pre;
            pre=preCurrent;
            preCurrent=next;
        }
        preMiddle.next=preCurrent;

        //Start reorder one by one  1->2->3->6->5->4 to 1->6->2->5->3->4
        p1=head;
        p2=preMiddle.next;
        while(p1!=preMiddle){
            preMiddle.next=p2.next;
            p2.next=p1.next;
            p1.next=p2;
            p1=p2.next;
            p2=preMiddle.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        reorderList(node1);

    }
}
