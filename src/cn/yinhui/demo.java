package cn.yinhui;

import java.util.*;
public class demo
 {
		public static  boolean isPalindrome(ListNode head) {
			if(head==null||head.next==null) return true;
			ListNode node=reverse(head);
			while(head.next!=null){
				if(head.value!=node.value){
					return false;
				}
				head=head.next;
				node=node.next;
			}
			return true;
		}
		public static ListNode reverse(ListNode head){
			if(head==null||head.next==null) return head;
			ListNode n1=head.next;
			ListNode n2=reverse(n1);
			n1.next=head;
			head.next=null;
			return n2;
		}

	    public static class ListNode {
	        int value;
	        ListNode next;
	        ListNode(int x) { value = x; }
	  
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
	    public ListNode insertionSortList(ListNode head) {
	    	 ListNode helper=new ListNode(0);
	    	    ListNode pre=helper;
	    	    ListNode current=head;
	    	    while(current!=null) {
	    	        pre=helper;
	    	        while(pre.next!=null&&pre.next.value<current.value) {
	    	            pre=pre.next;
	    	        }
	    	        ListNode next=current.next;
	    	        current.next=pre.next;
	    	        pre.next=current;
	    	        current=next;
	    	    }
	    	    return helper.next;
	    }
	    
	   
	    public static void main(String[] args) {

	    	
	    	int[] array={1,2};
	    	
	    	ListNode out2=transfer(array);
	    	ListNode newnode=reverse(out2);
      	    for(ListNode x=newnode;x!=null;x=x.next){
    		System.out.println(x.value);
	    	}
	    	System.out.println(isPalindrome(out2));
      	    
	    	
		}
	    
	}






		