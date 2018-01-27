package leetCode;

import java.util.Stack;

public class AddTwoNumbersII {
   /* You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Follow up:
    What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

    Example:

    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 8 -> 0 -> 7*/
   static class ListNode{
       ListNode next;
       int val;
       ListNode(int x){
           val=x;
       }
   }
//   第一种方法，简单粗暴。
   public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode add1=reverse(l1);
        ListNode add2=reverse(l2);
        int sum=0;
        ListNode result=new ListNode(0);
        ListNode d=result;
        while(add1!=null ||add2!=null){
            sum=sum/10;
            if(add1!=null) {
                sum+=add1.val;
                add1=add1.next;
            }
            if(add2!=null) {
                sum+=add2.val;
                add2=add2.next;
            }
            d.next=new ListNode(sum%10);
            d=d.next;
        }
        if(sum/10==1) d.next=new ListNode(1);
        return reverse(result.next);
   }
   public static ListNode  reverse(ListNode head){
       ListNode newHead = null;
       while (head != null) {
           ListNode next = head.next;
           head.next = newHead;
           newHead = head;
           head = next;
       }
       return newHead;
   }
//第二种方法：想到堆栈的反转
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        while(l1!=null) {
            s1.push(l1.val); l1=l1.next;
        }
        while(l2!=null){
            s2.push(l2.val);l2=l2.next;
        }
        int sum=0;
        ListNode list=new ListNode(0);
        while(!s1.isEmpty()||!s2.isEmpty()){
            if(!s1.isEmpty()) sum+=s1.pop();
            if(!s2.isEmpty()) sum+=s2.pop();
            list.val=sum%10;
            ListNode head=new ListNode(sum/10);
            head.next=list;
            list=head;
            sum/=10;
        }
        return list.val==0?list.next:list;
    }











    public static void main(String[] args) {
        ListNode root1=new ListNode(1);
        ListNode root2=new ListNode(8);
        ListNode root3=new ListNode(1);
        ListNode root4=new ListNode(9);
        root1.next=root2;
        root3.next=root4;
        ListNode result=addTwoNumbers(root1,root3);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }

    }
}
