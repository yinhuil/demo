package leetCode;

public class PartitionList {
  /*  Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

    You should preserve the original relative order of the nodes in each of the two partitions.

    For example,
    Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.*/
    static class ListNode{
        ListNode next;
        int val;
        ListNode(int x){ val=x;}
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode root=new ListNode(0);
        root.next=head;
        ListNode dummpy=root;
        while(dummpy.next!=null){
            if(dummpy.next.val>=x){
                dummpy=dummpy.next;
            }else{
                ListNode temp=root;
                ListNode now=dummpy.next;
                ListNode next=now.next;
                while(temp.next!=null){
                    if(temp.next.val>now.val){
                        dummpy.next=next;
                        ListNode next1=temp.next;
                        temp.next=now;
                        now.next=next1;
                        break;
                    }
                    temp=temp.next;
                }
                dummpy=dummpy.next;
            }
        }
        return root.next;
    }
    public ListNode partition1(ListNode head,int x){
        ListNode dummy1=new ListNode(0),dummy2=new ListNode(0);
        ListNode curr1=dummy1,curr2=dummy2;
        while (head!=null){
            if(head.val<x){
                curr1.next=head;
                curr1=head;
            }else{
                curr2.next=head;
                curr2=head;
            }
            head=head.next;
        }
        curr2.next=null;
        curr1.next=dummy2.next;
        return dummy1.next;
    }
    public static void main(String[] args) {
        ListNode root1=new ListNode(1);
        ListNode root2=new ListNode(4);
        ListNode root3=new ListNode(3);
        ListNode root4=new ListNode(2);ListNode root5=new ListNode(5);
        root1.next=root2;
        root2.next=root3;
        root3.next=root4;
        root4.next=root5;
        System.out.println(partition(root1,3));


    }
}
