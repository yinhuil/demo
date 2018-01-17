package leetCode;

public class SortList {
//    Sort a linked list in O(n log n) time using constant space complexity.

    static class ListNode{
        ListNode next;
        int val;
        ListNode(int x){
            val=x;
        }
    }

//   这是插入排序的方法，但是会超时；下面使用归并的方法
    public ListNode sortList1(ListNode head) {
        ListNode result=new ListNode(Integer.MIN_VALUE);
        result.next=head;
        ListNode pHead=head;
        ListNode pre=result;
        while(pHead!=null){
            if(pHead.val>pre.val){
                pre=pHead;
                pHead=pHead.next;
            }else{
                ListNode next=pHead.next;
                pHead.next=null;
                pre.next=next;
                ListNode temp=result;
                while(temp.val<=pHead.val){
                    if(temp.next.val>pHead.val){
                        break;
                    }
                    temp=temp.next;
                }
                ListNode tempNext=temp.next;
                temp.next=pHead;
                pHead.next=tempNext;
                pHead=next;
            }
        }
        return result.next;
    }

//    使用归并的方法
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // step 1. cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        // step 3. merge l1 and l2
        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0), p = l;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 != null)
            p.next = l1;
        if (l2 != null)
            p.next = l2;
        return l.next;
    }
}
