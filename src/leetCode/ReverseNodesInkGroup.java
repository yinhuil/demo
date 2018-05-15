package leetCode;

public class ReverseNodesInkGroup {
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int x){val=x;}
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        if(getlens(head)<k) return head;
        ListNode pHead=new ListNode(0);
        pHead.next=head;
        ListNode current=pHead;
        ListNode start=current.next;
        for(int i=1;i<k;i++){
            ListNode nextNode=start.next;
            start.next=nextNode.next;
            nextNode.next=current.next;
            current.next=nextNode;
        }
        start.next=reverseKGroup(start.next,k);
        return pHead.next;
    }
    public static int getlens(ListNode head){
        int result=0;
        while(head!=null){
            result++;
            head=head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);
        ListNode node5=new ListNode(5);
        node1.next=node2;node2.next=node3;node3.next=node4;node4.next=node5;
        ListNode result=reverseKGroup(node1,2);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }



    }
}
