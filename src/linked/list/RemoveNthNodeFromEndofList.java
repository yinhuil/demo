package linked.list;

import java.util.Arrays;

public class RemoveNthNodeFromEndofList {
	static class ListNode {
		int value;
		ListNode next;
		ListNode(int x) {
			value = x;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		 ListNode start=new ListNode(0);
		 ListNode slow=start,fast=start;
		 slow.next=head;
		 for(int i=1;i<=n+1;i++){
			 fast=fast.next;
		 }
		 while(fast!=null){
			 slow=slow.next;
			 fast=fast.next;
		 }
		 slow.next=slow.next.next;
		 return start.next;

	}
	public static ListNode reverse(ListNode head){
		if(head==null||head.next==null) return head;
		ListNode n1=head.next;
		ListNode n2=reverse(n1);
		n1.next=head;
		head.next=null;
		return n2;
	}
	 public static ListNode reverse1(ListNode head) {
         ListNode pre=null;
         while(head!=null){
             ListNode next=head.next;
             head.next=pre;
             pre=head;
             head=next;
         }
         return pre;
      }
	 public static ListNode  transfer(int[] in){
	    	ListNode newNode=new ListNode(in[0]);
	    	ListNode root=newNode;
	    	for (int i=1;i<in.length;i++) {
	    		ListNode temp=new ListNode(in[i]);
				root.next=temp;
				root=root.next;
			}
	    	return newNode;
 	}
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3 };
		ListNode out = transfer(arr);
		removeNthFromEnd(out, 2);
		for (ListNode x = out; x != null; x = x.next) {
			System.out.println(x.value);
		}

	}

}
